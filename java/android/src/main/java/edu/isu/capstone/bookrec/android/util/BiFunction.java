package edu.isu.capstone.bookrec.android.util;

@FunctionalInterface
public interface BiFunction<A, B, C> {
    C apply(A a, B b);
}
