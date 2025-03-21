// Album.java
import java.util.*;

public class Album {
    // Instance Variables
    private String artist;
    private String title;
    private int year;
    private List<Track> tracks;

    // Constructor - initialises these fields
    public Album(String artist, String title, int year) {
        this.artist = artist;
        this.title = title;
        this.year = year;
        this.tracks = new ArrayList<>();
    }

    // Adds a track to album
    public void addTrack(Track track) {
        tracks.add(track);
    }

    // Getter methods
    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    // Method to calculate total duration of the album
    public Duration getTotalDuration() {
        Duration totalDuration = new Duration(0, 0, 0);
        for (Track track : tracks) {
            totalDuration = totalDuration.add(track.getDuration());
        }
        return totalDuration;
    }

    // toString - method to display Album Artist, name, year and tracks
    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();

        // toString format - prints out Artist, title, year and tracks
        // https://www.tutorialspoint.com/converting-a-stringbuilder-to-string-in-java (Used as a reference)
        details.append(artist).append(" - ").append(title).append(" (").append(year).append(")\n");
        details.append("Tracks: \n");

        // Adds a number for each track, indicating track number for each album
        for (int i = 0; i < tracks.size(); i++) {

            // Adds 1 to i(track number) after every song it reads
            details.append((i + 1)).append(". ").append(tracks.get(i)).append("\n");
        }
        return details.toString();
    }

    // Test Harness
    public static void main(String[] args) {
        // Create test tracks with their duration
        Duration trackDuration1 = new Duration(0, 2, 27); // 2 minutes 27 seconds
        Track track1 = new Track("Foxy Lady", trackDuration1);

        Duration trackDuration2 = new Duration(0, 6, 13); // 6 minutes 13 seconds
        Track track2 = new Track("Purple Haze", trackDuration2);

        // Create an album
        Album album = new Album("The Jimi Hendrix Experience", "Are You Experienced?", 1967);

        // Add tracks to the album
        album.addTrack(track1);
        album.addTrack(track2);

        // Display album details
        System.out.println("Album Name: " + album); // Album: Are You Experienced? by The Jimi Hendrix Experience (1967)

        // Display the total duration of the album
        System.out.println("Total Duration of the Album: " + album.getTotalDuration()); // Total duration of the album

        // Display the list of tracks in the album
        System.out.println("Tracks Used:");
        for (Track track : album.getTracks()) {
            System.out.println(track); // Prints each track
        }
    }
}







