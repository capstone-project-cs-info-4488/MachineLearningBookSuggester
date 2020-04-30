package edu.isu.capstone.bookrec.android.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * A generic class that holds a result success w/ data or an error exception.
 */
public abstract class Result<T> {
    // hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }

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

    public abstract LiveData<Exception> errorLiveData();

    // Success sub-class
    public final static class Success<T> extends Result<T> {
        private T data;

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
        public LiveData<Exception> errorLiveData() {
            return new MutableLiveData<>();
        }
    }

    // Error sub-class
    public final static class Error<T> extends Result<T> {
        private Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        public Exception getError() {
            return this.error;
        }

        @Override
        public LiveData<T> successLiveData() {
            return new MutableLiveData<>();
        }

        @Override
        public LiveData<Exception> errorLiveData() {
            MutableLiveData<Exception> data = new MutableLiveData<>();
            data.setValue(this.error);
            return data;
        }
    }
}
