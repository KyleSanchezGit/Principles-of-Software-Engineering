package edu.vanderbilt.cs.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BikeRide {

    /**
     * DataFrame class holds data for a specific moment during the bike ride,
     * including velocity, heart rate, grade, altitude, and coordinates.
     */
    public static class DataFrame {
        public final double velocity;
        public final double heartRate;
        public final double grade;
        public final double altitude;
        public final LatLng coordinate;

        public DataFrame(LatLng coordinate, double grade, double altitude, double velocity, double heartRate) {
            super();
            this.velocity = velocity;
            this.heartRate = heartRate;
            this.grade = grade;
            this.altitude = altitude;
            this.coordinate = coordinate;
        }

        public double getVelocity() {
            return velocity;
        }

        public double getHeartRate() {
            return heartRate;
        }

        public double getGrade() {
            return grade;
        }

        public double getAltitude() {
            return altitude;
        }

        public LatLng getCoordinate() {
            return coordinate;
        }
    }

    /**
     * LatLng class holds the latitude and longitude coordinates.
     */
    public static class LatLng {
        public final double latitude;
        public final double longitude;

        @JsonCreator
        public LatLng(double[] latlng) {
            this.latitude = latlng[0];
            this.longitude = latlng[1];
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LatLng latLng = (LatLng) o;
            return Double.compare(latLng.latitude, latitude) == 0 &&
                    Double.compare(latLng.longitude, longitude) == 0;
        }
    }

    /**
     * LatLngStream class holds an array of LatLng objects.
     */
    public static class LatLngStream {
        public final LatLng[] data;

        @JsonCreator
        public LatLngStream(@JsonProperty("data") LatLng[] data) {
            this.data = data;
        }

        @JsonAnySetter
        public void setOther(String key, Object v) {}
    }

    /**
     * DataStream class holds an array of double values.
     */
    public static class DataStream {
        public final double[] data;

        @JsonCreator
        public DataStream(@JsonProperty("data") double[] data) {
            this.data = data;
        }

        @JsonAnySetter
        public void setOther(String key, Object v) {}
    }

    // Arrays of heart rate, velocity, grade, altitude, and coordinates
    public final double[] heartRate;
    public final double[] velocity;
    public final double[] grade;
    public final double[] altitude;
    public final LatLng[] coordinates;

    /**
     * Constructor to initialize the BikeRide object with the provided data.
     */
    @JsonCreator
    public BikeRide(@JsonProperty("heartrate") DataStream heartRate,
                    @JsonProperty("velocity_smooth") DataStream velocity,
                    @JsonProperty("grade_smooth") DataStream grade,
                    @JsonProperty("altitude") DataStream altitude,
                    @JsonProperty("latlng") LatLngStream coordinates) {
        super();
        this.heartRate = heartRate.data;
        this.velocity = velocity.data;
        this.grade = grade.data;
        this.altitude = altitude.data;
        this.coordinates = coordinates.data;
    }

    /**
     * Returns a stream of heart rate values.
     */
    public DoubleStream heartRateStream() {
        return Arrays.stream(heartRate);
    }

    /**
     * Returns a stream of velocity values.
     */
    public DoubleStream velocityStream() {
        return Arrays.stream(velocity);
    }

    /**
     * Returns a stream of grade values.
     */
    public DoubleStream gradeStream() {
        return Arrays.stream(grade);
    }

    /**
     * Returns a stream of altitude values.
     */
    public DoubleStream altitudeStream() {
        return Arrays.stream(altitude);
    }

    /**
     * Returns a stream of LatLng coordinates.
     */
    public Stream<LatLng> coordinateStream() {
        return Arrays.stream(coordinates);
    }

    /**
     * Creates a stream of DataFrame objects by combining corresponding elements
     * from heart rate, velocity, grade, altitude, and coordinates arrays.
     */
    public Stream<DataFrame> fusedFramesStream() {
        int length = Math.min(heartRate.length, Math.min(velocity.length, Math.min(grade.length, Math.min(altitude.length, coordinates.length))));
        return IntStream.range(0, length)
                .mapToObj(i -> new DataFrame(coordinates[i], grade[i], altitude[i], velocity[i], heartRate[i]));
    }

    /**
     * Placeholder method for setting other properties.
     * This method is intentionally left blank.
     */
    @JsonAnySetter
    public void setOther(String key, Object v) {}
}

