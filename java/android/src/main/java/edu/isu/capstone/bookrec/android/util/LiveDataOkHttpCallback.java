package edu.isu.capstone.bookrec.android.util;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.jetbrains.annotations.NotNull;

import edu.isu.capstone.bookrec.android.data.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataOkHttpCallback<T> implements Callback<T> {
    private final MutableLiveData<Result<T>> result = new MutableLiveData<>();

    @Override
    public void onResponse(@NotNull Call<T> call, Response<T> response) {
        result.postValue(new Result.Success<>(response.body()));
    }

    @Override
    public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
        Log.e("LiveDataOkHttpCallback", "Error calling api", t);
        result.postValue(new Result.Error<>(t));
    }

    public LiveData<Result<T>> getResult() {
        return result;
    }
}