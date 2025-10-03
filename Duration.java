// Duration.java
// Implementing Comparable - to sort or find longest/shortest tracks
public class Duration implements Comparable<Duration> {
    // Integer member variables
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor - initialises these fields
    public Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    // Getter methods
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    // Add durations together
    public Duration add(Duration other) {
        int totalSeconds = this.hours * 3600 + this.minutes * 60 + this.seconds
                + other.hours * 3600 + other.minutes * 60 + other.seconds;

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        return new Duration(hours, minutes, seconds);
    }

    // Compare durations (to find longest track)
    @Override
    public int compareTo(Duration other) {
        int thisTotalSeconds = this.hours * 3600 + this.minutes * 60 + this.seconds;
        int otherTotalSeconds = other.hours * 3600 + other.minutes * 60 + other.seconds;

        return Integer.compare(thisTotalSeconds, otherTotalSeconds);
    }

    // toString - method outputs duration in readable format
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


    // Test Harness
    public static void main(String[] args) {

        // Create test instances of Duration
        Duration track1 = new Duration(1, 30, 45); // 1 hour, 30 minutes, 45 seconds
        Duration track2 = new Duration(1, 45, 30); // 1 hour, 45 minutes, 30 seconds
        Duration track3 = new Duration(1, 30, 45);

        // Comparing tracks (using compareTo)
        // -1 = No, 0 = Equal, 1 = Yes
        System.out.println("track1 vs track2: " + track1.compareTo(track2)); // Expected: -1 (d1 < d2)
        System.out.println("track2 vs track1: " + track2.compareTo(track1)); // Expected: 1 (d2 > d1)
        System.out.println("track1 vs track3: " + track1.compareTo(track3)); // Expected: 0 (d1 == d3)

        // Test toString method
        System.out.println("track1: " + track1); // Expected: 1:30:45
    }
}

