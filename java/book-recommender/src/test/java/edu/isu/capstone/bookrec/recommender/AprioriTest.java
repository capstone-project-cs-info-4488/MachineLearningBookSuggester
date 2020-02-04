package edu.isu.capstone.bookrec.recommender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AprioriTest {
    @Test
    void example() {
        List<Set<Character>> associations = Arrays.asList(
                new HashSet<>(Arrays.asList('a', 'd', 'e')),
                new HashSet<>(Arrays.asList('b', 'c', 'd')),
                new HashSet<>(Arrays.asList('a', 'c', 'e')),
                new HashSet<>(Arrays.asList('a', 'c', 'd', 'e')),
                new HashSet<>(Arrays.asList('a', 'e')),
                new HashSet<>(Arrays.asList('a', 'c', 'd')),
                new HashSet<>(Arrays.asList('b', 'c')),
                new HashSet<>(Arrays.asList('a', 'c', 'd', 'e')),
                new HashSet<>(Arrays.asList('c', 'b', 'e')),
                new HashSet<>(Arrays.asList('a', 'd', 'e'))
        );
        int minFrequency = 3;

        Set<Set<Character>> result = Apriori.apriori(associations, minFrequency).getSubsetsFound();

        Set<Set<Character>> expectedResult = new HashSet<>(Arrays.asList(
                new HashSet<>(Arrays.asList('a', 'c')),
                new HashSet<>(Arrays.asList('a', 'c', 'd')),
                new HashSet<>(Arrays.asList('a', 'c', 'e')),
                new HashSet<>(Arrays.asList('a', 'd')),
                new HashSet<>(Arrays.asList('a', 'd', 'e')),
                new HashSet<>(Arrays.asList('a', 'e')),
                new HashSet<>(Arrays.asList('b', 'c')),
                new HashSet<>(Arrays.asList('c', 'd')),
                new HashSet<>(Arrays.asList('c', 'e')),
                new HashSet<>(Arrays.asList('d', 'e'))
        ));

        Assertions.assertEquals(expectedResult, result);
    }
}