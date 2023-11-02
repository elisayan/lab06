package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1000; i <= 2000; i++) {
            array.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> list = new LinkedList<>(array);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int firstElement = list.getFirst();
        list.set(0, list.getLast());
        list.set((list.size()-1), firstElement);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : array) {
            System.out.println(integer);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 1; i <= 100000; i++) {
            array.add(0, i);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Inserting 100.000 elements in ArrayList took " + time + "ns (" + millis + "ms)");
        
        long time1 = System.nanoTime();
        for (int i = 1; i <= 100000; i++) {
            list.add(0, i);
        }
        time1 = System.nanoTime() - time1;
        final var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        System.out.println("Inserting 100.000 elements in LinkedList took " + time1 + "ns (" + millis1 + "ms)");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long time2 = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {            
            array.get(array.size()/2);
        }
        time2 = System.nanoTime() - time2;
        final double millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
        System.out.println("Reading 1000 times an element in the middle of array took " + time2 + " ns (" + millis2 + "ms)");

        long time3 = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {            
            array.get(array.size()/2);
        }
        time3 = System.nanoTime() - time3;
        final double millis3 = TimeUnit.NANOSECONDS.toMillis(time3);
        System.out.println("Reading 1000 times an element in the middle of array took " + time3 + " ns (" + millis3 + "ms)");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1110635000L);
        map.put("Americas", 972005000L);
        map.put("Antarctica", 0L);
        map.put("Asia", 4298723000L);
        map.put("Europe", 742252000L);
        map.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        Long sumLong = 0L;
        for (Long l : map.values()) {
            sumLong = sumLong + l;
        }
        System.out.println(sumLong);
    }
}
