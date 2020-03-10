package edu.isu.capstone.bookrec.recommender;

import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.*;

public class Apriori {
    /**
     * Executes the apriori algorithm to find all sets of items with a frequency above the minFrequency and
     * uses it to create a recommender.
     *
     * @param associations a set of association data
     * @param minFrequency the minimum amount of input sets the data must be in
     */
    public static <T> Result<T> apriori(Collection<Set<T>> associations, int minFrequency) {
        Map<List<T>, Long> matchingSubsets = new HashMap<>();

        List<List<T>> candidates = associations
                .stream()
                .flatMap(Collection::stream)
                .distinct()
                .map(Collections::singletonList)
                .collect(toList());

        while (true) {
            LinkedHashMap<List<T>, Long> candidatesFrequencies = countSubsetFrequencies(associations, candidates);
            candidatesFrequencies.values().removeIf(frequency -> frequency < minFrequency);

            Set<List<T>> currentFrequentSubsets = candidatesFrequencies.keySet();
            if (currentFrequentSubsets.size() == 0) {
                break;
            }

            matchingSubsets.putAll(candidatesFrequencies);
            candidates = generatePrunedCandidates(currentFrequentSubsets);
        }

        return Result.fromListToLong(matchingSubsets);
    }

    private static <T> LinkedHashMap<List<T>, Long> countSubsetFrequencies(Collection<Set<T>> associations, List<List<T>> subsets) {
        return subsets
                .stream() // order matters here.
                .collect(toMap(
                        subset -> subset, // Let the subset itself be the key.
                        subset -> associations // Let the number of associations containing the subset be the value
                                .stream()
                                .filter(association -> association.containsAll(subset))
                                .count(),
                        (subset1, subset2) -> {
                            throw new IllegalStateException("There should not be two identical subsets.");
                        },
                        LinkedHashMap::new // using linked hash map to maintain order.
                ));
    }

    /**
     * Generates the next candidates given the current candidates
     *
     * @param currentFrequentSubsets A set of the current subsets. Each subset is assumed to be sorted lexicographically.
     *                               The set overall is also assumed to be sorted lexicographically.
     * @return A list of the next candidates. This list is also sorted lexicographically. Each candidate has size one
     * greater than the input elements. In addition, every subset that's one smaller that each candidate is in the input
     */
    private static <T> List<List<T>> generatePrunedCandidates(Set<List<T>> currentFrequentSubsets) {
        if (currentFrequentSubsets.isEmpty()) return emptyList();

        // A list of candidates in lexicographic order.
        List<List<T>> candidates = generateCandidates(currentFrequentSubsets);

        // prune candidates.
        candidates.removeIf(candidate ->
                hasInvalidOneElementSmallerSubsets(currentFrequentSubsets, candidate)
        );

        return candidates;
    }

    private static <T> List<List<T>> generateCandidates(Set<List<T>> currentFrequentSubsets) {
        List<List<T>> candidates = new ArrayList<>();

        // A list of everything except the last element in the previous subset.
        List<T> lastAllButLast = emptyList();
        // A list of the last elements in the last few subsets that have shared all elements except the last.
        List<T> lasts = new ArrayList<>();

        // Iterate in order so output is in order.
        for (List<T> subset : currentFrequentSubsets) {
            List<T> allButLast = subset.subList(0, subset.size() - 1);
            T last = subset.get(subset.size() - 1);

            if (!allButLast.equals(lastAllButLast)) {
                addCandidates(candidates, lastAllButLast, lasts);
                lasts.clear();
            }

            lastAllButLast = allButLast;
            lasts.add(last);
        }

        addCandidates(candidates, lastAllButLast, lasts);
        return candidates;
    }

    /**
     * @param allowedSubsets The allowed subsets that are each lexicographically sorted lists.
     * @param set            Lexicographically sorted list
     */
    private static <T> boolean hasInvalidOneElementSmallerSubsets(
            Set<List<T>> allowedSubsets,
            List<T> set) {
        for (int i = 0; i < set.size(); i++) {
            // Generate each subset by removing the ith item.
            List<T> subset = new ArrayList<>(set);
            //noinspection SuspiciousListRemoveInLoop
            subset.remove(i);

            // prune an element of a subset is found that wasn't in there before.
            if (!allowedSubsets.contains(subset)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates candidates
     *
     * @param candidates the list that the candidates are added to.
     * @param prefix     the prefix that is part of all candidates.
     * @param lasts      The last two elements of each candidate are selected from here. They are chosen in lexicographic order.
     */
    private static <T> void addCandidates(List<List<T>> candidates, List<T> prefix, List<T> lasts) {
        for (int i = 0; i < lasts.size(); i++) {
            for (int j = i + 1; j < lasts.size(); j++) {
                List<T> newCandidate = new ArrayList<>(prefix);
                // This specific ordering is important because it maintains that candidates are added
                // in lexicographic order.
                newCandidate.add(lasts.get(i));
                newCandidate.add(lasts.get(j));
                candidates.add(newCandidate);
            }
        }
    }

    /**
     * Returns a list of all items in the associations that have a frequency above the minFrequency.
     */
    private static <T> List<T> itemsWithMinFrequency(Collection<Set<T>> associations, int minFrequency) {
        Map<T, Long> itemFrequencies = associations
                .stream()
                .flatMap(Collection::stream)
                .collect(groupingBy(item -> item, counting()));

        // only return the items with a frequency above the min frequency.
        return itemFrequencies
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= minFrequency)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    public static class Result<T> {
        private final Map<Set<T>, Integer> subsetToSupport;

        public Result(Map<Set<T>, Integer> subsetToFrequency) {
            this.subsetToSupport = subsetToFrequency;
        }

        static <T> Result<T> fromListToLong(Map<List<T>, Long> subsetToFrequency) {
            // Adjust the map to be in the right format.
            Map<Set<T>, Integer> adjusted = subsetToFrequency
                    .entrySet()
                    .stream()
                    .map(entry -> {
                        // adjust the keys from lists to sets.
                        Set<T> newKey = new HashSet<>(entry.getKey());

                        // adjust the values from longs to integers.
                        if (entry.getValue() > Integer.MAX_VALUE) {
                            throw new UnsupportedOperationException("Unexpectedly large number");
                        }
                        Integer newValue = entry.getValue().intValue();

                        return new AbstractMap.SimpleEntry<>(newKey, newValue);
                    })
                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

            return new Result<>(adjusted);
        }

        public Set<Set<T>> getSubsetsFound() {
            return subsetToSupport.keySet();
        }

        public Map<Set<T>, Integer> getSubsetToFrequency() {
            return subsetToSupport;
        }
    }
}
