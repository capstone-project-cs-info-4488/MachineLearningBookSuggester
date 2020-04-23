package edu.isu.capstone.bookrec.android.util;

import androidx.arch.core.util.Function;
import androidx.core.util.Predicate;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;


public class LiveDataUtil {
    public static <A, B, C> LiveData<C> combine2(LiveData<A> first, LiveData<B> second, BiFunction<A, B, C> combiner) {
        MediatorLiveData<C> combined = new MediatorLiveData<>();
        combined.addSource(first, a -> combined.setValue(combiner.apply(a, second.getValue())));
        combined.addSource(second, b -> combined.setValue(combiner.apply(first.getValue(), b)));
        return combined;
    }

    /**
     * Takes the first item returned by the right live data and inserts it into the mediator.
     * Subsequent items are ignored.
     *
     * @param mediator The live data that the data should be merged into.
     * @param liveData The live data that returns one unit of data that is merged in.
     */
    public static <T> void mergeFirstInto(MediatorLiveData<T> mediator, LiveData<T> liveData) {
        mediator.addSource(liveData, data -> {
            mediator.setValue(data);
            mediator.removeSource(liveData);
        });
    }


    public static <T> LiveData<T> filter(LiveData<T> source, Predicate<T> mapper) {
        MediatorLiveData<T> filtered = new MediatorLiveData<>();
        filtered.addSource(source, newItem -> {
            if (mapper.test(newItem)) {
                filtered.setValue(newItem);
            }
        });
        return filtered;
    }

    public static <T, R> MutableLiveData<R> mapMutable(LiveData<T> liveData, Function<T, R> mapper) {
        MediatorLiveData<R> mapped = new MediatorLiveData<>();
        mapped.addSource(liveData, data -> mapped.setValue(mapper.apply(data)));
        return mapped;
    }
}
