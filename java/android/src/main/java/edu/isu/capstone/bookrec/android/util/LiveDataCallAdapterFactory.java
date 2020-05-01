package edu.isu.capstone.bookrec.android.util;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import edu.isu.capstone.bookrec.android.data.Result;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    @Nullable
    @Override
    public CallAdapter<?, ?> get(
            @NotNull Type returnType,
            @NotNull Annotation[] annotations,
            @NotNull Retrofit retrofit
    ) {
        if (!(returnType instanceof ParameterizedType)) return null;
        ParameterizedType type = (ParameterizedType) returnType;
        if (type.getRawType() != LiveData.class) return null;
        if (type.getActualTypeArguments().length != 1) return null;
        Type typeArgUncast = type.getActualTypeArguments()[0];
        if (!(typeArgUncast instanceof ParameterizedType)) return null;
        ParameterizedType typeArg = (ParameterizedType) typeArgUncast;
        if (typeArg.getRawType() != Result.class) return null;
        if (typeArg.getActualTypeArguments().length != 1) return null;
        Type innerType = typeArg.getActualTypeArguments()[0];
        return new LiveDataCallAdapter(innerType);
    }
}
