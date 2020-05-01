package edu.isu.capstone.bookrec.android.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

/**
 * A generic class that holds a result success w/ data or an error exception.
 */
public abstract class Result<T> {
    // hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }

    @NotNull
    @Override
    public String toString() {
        if (this instanceof Result.Success) {
            Result.Success<T> success = (Result.Success<T>) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error<T> error = (Result.Error<T>) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }

    public abstract LiveData<T> successLiveData();

    public abstract LiveData<Throwable> errorLiveData();

    // Success sub-class
    public final static class Success<T> extends Result<T> {
        private final T data;

        public Success(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        @Override
        public LiveData<T> successLiveData() {
            MutableLiveData<T> data = new MutableLiveData<>();
            data.setValue(this.data);
            return data;
        }

        @Override
        public LiveData<Throwable> errorLiveData() {
            return new MutableLiveData<>();
        }
    }

    // Error sub-class
    public final static class Error<T> extends Result<T> {
        private final Throwable error;

        public Error(Throwable error) {
            this.error = error;
        }

        public Throwable getError() {
            return this.error;
        }

        @Override
        public LiveData<T> successLiveData() {
            return new MutableLiveData<>();
        }

        @Override
        public LiveData<Throwable> errorLiveData() {
            MutableLiveData<Throwable> data = new MutableLiveData<>();
            data.setValue(this.error);
            return data;
        }

        @SuppressWarnings("unchecked")
        public <R> Error<R> as() {
            return (Error<R>) this;
        }
    }
}
