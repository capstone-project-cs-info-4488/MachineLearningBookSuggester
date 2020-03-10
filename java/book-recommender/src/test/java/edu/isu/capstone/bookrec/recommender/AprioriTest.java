package edu.isu.capstone.bookrec.recommender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.singleton;

class AprioriTest {
    @Test
    void example() {
        List<Set<Character>> associations = asList(
                new HashSet<>(asList('a', 'd', 'e')),
                new HashSet<>(asList('b', 'c', 'd')),
                new HashSet<>(asList('a', 'c', 'e')),
                new HashSet<>(asList('a', 'c', 'd', 'e')),
                new HashSet<>(asList('a', 'e')),
                new HashSet<>(asList('a', 'c', 'd')),
                new HashSet<>(asList('b', 'c')),
                new HashSet<>(asList('a', 'c', 'd', 'e')),
                new HashSet<>(asList('c', 'b', 'e')),
                new HashSet<>(asList('a', 'd', 'e'))
        );
        int minFrequency = 3;

        Set<Set<Character>> result = Apriori.apriori(associations, minFrequency).getSubsetsFound();

        Set<Set<Character>> expectedResult = new HashSet<>(asList(
                new HashSet<>(asList('a', 'c')),
                new HashSet<>(asList('a', 'c', 'd')),
                new HashSet<>(asList('a', 'c', 'e')),
                new HashSet<>(asList('a', 'd')),
                new HashSet<>(asList('a', 'd', 'e')),
                new HashSet<>(asList('a', 'e')),
                new HashSet<>(asList('b', 'c')),
                new HashSet<>(asList('c', 'd')),
                new HashSet<>(asList('c', 'e')),
                new HashSet<>(asList('d', 'e')),
                singleton('a'),
                singleton('b'),
                singleton('c'),
                singleton('d'),
                singleton('e')
        ));

        Assertions.assertEquals(expectedResult, result);
    }
}