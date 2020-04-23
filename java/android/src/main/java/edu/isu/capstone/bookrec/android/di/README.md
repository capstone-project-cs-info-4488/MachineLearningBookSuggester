# Dependency Injection

This document gives a basic overview of how to use the dependency injection that is set up. If you don't understand
 something or it is giving you problems, please ask me (Rosetta) for help.

## Concepts

### Scopes

In dependency injection, scopes represent the lifetime of objects created. One such scope is `Singleton`, which is
used for objects that are expected to exist for the entire life of the application. This is the default scope in
spring. Another example of a scope is the scope which doesn't have a lifetime. This is the `Prototype` scope in
Spring and the default scope in Dagger. Objects in this scope are newly created every time they are requested.

In this project, we use three scopes. The `Singleton` scope, the `ActivityScope` scope, and the default scope. For
most cases, you should use the default scope. If you have something that is expensive to create and will be used
across the app, use the `Singleton` scope. If you have something that is expensive to create and will be used by an
activity, use the `ActivityScope` scope.

Note that items like `Application`, `Activity`, `Fragment`, `View`, etc. are managed by Android, and not
our application. Therefore, Dagger cannot manage or create these objects. Instead, we have these objects indirectly
manage the lifetimes of objects created by Dagger. For example, when an `Application` is created, the main Dagger
container is constructed which remembers `Singleton` scoped objects. These objects are removed when the `Application
` is destroyed. Similarly between `Activity` and `ActivityScope` scoped objects.

## How to Use

For the vast majority of cases, you should use the `@Inject` annotation on the constructor of a class and it will
automatically inject the needed components. If you need the instants of a class to have a specific lifetime, annotate
them with `@Singleton` or `@ActivityScope`. Injection for Activities, Fragments, and ViewModels are done differently.

If you want to use injection for an Activity, first have the activity extend `DaggerAppCompatActivity`. This class
includes logic that calls Dagger code to inject dependencies. To declare dependencies, declare each dependency as a
non-private Field with the `@Inject` annotation. Finally, to tell Dagger to generate the code that actually does the
injection, add the following code to `ActivitiesModule`.

```java
@Module
interface ActivitiesModule {
    // ...
    // Previous activity code

    // Tells dagger that items annotated with @ActivityScope are managed by the created container.
    @ActivityScope
    // Tells dagger to generate a dependency injection container compatible with Android for MyActivity
    @ContributesAndroidInjector(modules = MyActivityModule.class)
    MyActivity myActivity();

    // Configure module specific dependencies and include other modules that 
    // depend on the scope of the the activity.
    @Module(includes = {FragmentModule.class})
    interface MyActivityModule {
        // Tells Dagger to inject MyActivity whenever an AppCompatActivity is needed to be injected.
        @ActivityScope
        @Binds
        AppCompatActivity activity(MyActivity activity);
    }
}
```

If you want to use injection for a Fragment, first have the fragment extend `DaggerFragment`. This class
includes logic that calls Dagger code to inject dependencies. To declare dependencies, declare each dependency as a
non-private Field with the `@Inject` annotation. Finally, to tell Dagger to generate the code that actually does the
injection, add the following code to `FragmentModule`.

```java
@Module
public interface FragmentModule {
    // Tells dagger to generate a dependency injection container compatible with Android for BookFragment
    @ContributesAndroidInjector
    BookFragment addBookFragment();
}
```

If you want to use injection for a ViewModel, annotate its primary injector with `@Inject` like any other normal object.
However, Android likes to manage each ViewModel after it is instantiated. To use a ViewModel in a fragment, add the
following code to your fragment.

```java
public class MyFragment extends DaggerFragment {
    // A factory that uses dagger to construct each view model.
    @Inject
    ViewModelProvider.Factory viewModelFactory;
    
    // ...

    @Nullable
    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState)
    {
        // Let android manager our view model while still using our own factory to create it.
        MyViewModel viewModel = new ViewModelProvider(this, viewModelFactory).get(MyViewModel.class);

        // ...
    }

    // ...
}
```

In addition, since the Fragment now doesn't directly declare a dependency, you have to inform Dagger of the ViewModel
so that the generated `ViewModelProvider.Factory` knows how to create the `ViewModel`. To do this, add the following
to `ViewModelModule.java.`

```java
@Module
public
interface ViewModelModule {
    // ...

    // Tells dagger to put into a map that is used by the ViewModelProvider.Factory to generate ViewModels.
    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel.class)
    ViewModel bindBookViewModel(MyViewModel model);
}
```

If there is an interface type you want to be able to inject, you have to tell Dagger which concrete type to use. To
do this, either create a new module or use an existing module and add the following to the module.
```java
@Module
public interface MyModule {
    @Bind
    MyInterface bindMyInstance(MyInstance instance);
}
```
or
```java
@Module
public class MyModule {
    // Tells dagger how to create MyType. You can add whatever dependencies you want to the method.
    @Provides
    MyType createMyInstance(AType dependency1) {
        // ...
        return calculatedValue;
    }
}
```
If you create a new module, don't forget to add the module to the list of modules in ApplicationComponent!