// Track.java
public class Track {
    // Member variables
    private String title;
    private Duration duration;

    // Constructor - initialises these fields
    public Track(String title, Duration duration) {
        this.title = title;
        this.duration = duration;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }

    // toString - method prints the track's title and duration
    @Override
    public String toString() {
        return title + " - " + duration;
    }


    // Test Harness
    public static void main(String[] args) {

        // Creates new Duration object
        Duration trackDuration = new Duration(0, 3, 45); // 3 minutes 45 seconds
        Track track = new Track("Foxy Lady", trackDuration); // Track title and duration

        // Test the get methods
        System.out.println("Track Title: " + track.getTitle()); // Expected: Foxy Lady
        System.out.println("Track Duration: " + track.getDuration()); // Expected: 0:03:45

        // Test toString
        System.out.println("Track: " + track); // Expected: Foxy Lady (0:03:45)
    }
}



