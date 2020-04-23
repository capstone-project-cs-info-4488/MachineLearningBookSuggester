package edu.isu.capstone.bookrec.android.util;

import androidx.annotation.Nullable;

import java.util.Arrays;

public class ObjectUtil {

    public static boolean equals(@Nullable Object item1, @Nullable Object item2) {
        // Added because Objects.equals doesn't work with our minsdk level
        //noinspection EqualsReplaceableByObjectsCall
        return item1 == item2 || (item1 != null && item1.equals(item2));
    }

    public static int hash(Object... items) {
        return Arrays.hashCode(items);
    }
}
