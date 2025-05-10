package edu.vanderbilt.cs.streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamUtils {

    /**
     * Creates a stream of sliding windows of the specified size from the provided data list.
     * Each window is a list of the data points present at that step of the window sliding.
     * Only complete windows are returned.
     *
     * @param data the list of data points
     * @param windowSize the size of each sliding window
     * @param <T> the type of elements in the data list
     * @return a stream of sliding windows
     */
    public static <T> Stream<List<T>> slidingWindow(List<T> data, int windowSize) {
        // If the window size is less than 1, return an empty stream
        if (windowSize < 1) {
            return Stream.empty();
        }

        // Use IntStream.range to generate indices for the start of each window
        // Use List.subList to create each window and collect the windows into a stream
        return IntStream.rangeClosed(0, data.size() - windowSize)
                .mapToObj(start -> data.subList(start, start + windowSize));
    }

    /**
     * Creates a function that computes the average of a property extracted from a list of objects.
     * The property is extracted using the provided property function.
     *
     * @param f the function to extract the property value from an object
     * @param <T> the type of objects in the list
     * @return a function that computes the average of the extracted property values
     */
    public static <T> Function<List<T>, Double> averageOfProperty(ToDoubleFunction<T> f) {
        return (List<T> window) -> {
            // Use the provided function to map each object to a property value
            // Use the stream to calculate the average of the property values
            return window.stream().mapToDouble(f).average().orElse(0.0);
        };
    }
}
