package edu.isu.capstone.bookrec.recommender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static edu.isu.capstone.bookrec.recommender.TestUtils.hs;
import static java.util.Arrays.asList;

class AprioriTest {

    @Test
    void example() {
        List<Set<Character>> associations = asList(
                hs('a', 'd', 'e'),
                hs('b', 'c', 'd'),
                hs('a', 'c', 'e'),
                hs('a', 'c', 'd', 'e'),
                hs('a', 'e'),
                hs('a', 'c', 'd'),
                hs('b', 'c'),
                hs('a', 'c', 'd', 'e'),
                hs('c', 'b', 'e'),
                hs('a', 'd', 'e')
        );
        int minFrequency = 3;

        Set<Set<Character>> result = Apriori.apriori(associations, minFrequency).getSubsetsFound();

        Set<Set<Character>> expectedResult = hs(
                hs('a', 'c'),
                hs('a', 'c', 'd'),
                hs('a', 'c', 'e'),
                hs('a', 'd'),
                hs('a', 'd', 'e'),
                hs('a', 'e'),
                hs('b', 'c'),
                hs('c', 'd'),
                hs('c', 'e'),
                hs('d', 'e'),
                hs('a'),
                hs('b'),
                hs('c'),
                hs('d'),
                hs('e')
        );

        Assertions.assertEquals(expectedResult, result);
    }
}