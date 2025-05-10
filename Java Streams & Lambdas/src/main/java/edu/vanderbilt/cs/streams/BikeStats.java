package edu.vanderbilt.cs.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.vanderbilt.cs.streams.BikeRide.LatLng;

public class BikeStats {

    // Instance variable to hold the BikeRide object
    private final BikeRide ride;

    // Constructor to initialize the BikeStats object with a BikeRide instance
    public BikeStats(BikeRide ride) {
        this.ride = ride;
    }

    /**
     * Returns a stream of averaged DataFrame objects. Each DataFrame in the stream
     * represents the average of a sliding window of DataFrames from the original ride data.
     *
     * @param windowSize the size of the sliding window
     * @return a stream of averaged DataFrame objects
     */
    public Stream<BikeRide.DataFrame> averagedDataFrameStream(int windowSize) {
        // Convert the stream of DataFrames to a list for easier processing with slidingWindow
        List<BikeRide.DataFrame> frames = ride.fusedFramesStream().collect(Collectors.toList());

        // Use the slidingWindow method to create a stream of sliding windows of DataFrames
        return StreamUtils.slidingWindow(frames, windowSize)
                .map(window -> {
                    // Calculate the average values for each property in the window
                    double avgGrade = window.stream().mapToDouble(BikeRide.DataFrame::getGrade).average().orElse(0);
                    double avgAltitude = window.stream().mapToDouble(BikeRide.DataFrame::getAltitude).average().orElse(0);
                    double avgVelocity = window.stream().mapToDouble(BikeRide.DataFrame::getVelocity).average().orElse(0);
                    double avgHeartRate = window.stream().mapToDouble(BikeRide.DataFrame::getHeartRate).average().orElse(0);

                    // Use the coordinate of the first DataFrame in the window
                    LatLng coordinate = window.get(0).coordinate;

                    // Return a new DataFrame with the averaged values and the coordinate
                    return new BikeRide.DataFrame(coordinate, avgGrade, avgAltitude, avgVelocity, avgHeartRate);
                });
    }

    /**
     * Returns a stream of LatLng coordinates where the bike ride had stops (velocity = 0).
     *
     * @return a stream of LatLng coordinates where the bike ride had stops
     */
    public Stream<LatLng> locationsOfStops() {
        // Filter the frames where velocity is 0 to find stops
        // Map the frames to their coordinates and use distinct to ensure uniqueness
        return ride.fusedFramesStream()
                .filter(frame -> frame.getVelocity() == 0)
                .map(BikeRide.DataFrame::getCoordinate)
                .distinct();
    }
}

