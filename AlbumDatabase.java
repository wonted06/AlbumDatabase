// AlbumDatabase.java
import java.io.*;
import java.util.*;

public class AlbumDatabase {
    public static void main(String[] args) {
        AlbumCollection albumCollection = new AlbumCollection();

        // Scanner used to read txt file
        try (Scanner scanner = new Scanner(new File("albums.txt"))) {
            Album currentAlbum = null;
            Track currentTrack = null;

            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine().trim();
                char firstChar = currentLine.charAt(0);

                // Compares first character, looking for letter
                if (Character.isLetter(currentLine.charAt(0))) {

                    // Split artist, title, and year from the first line
                    String[] albumParts = currentLine.split(":");
                    String titleYear = albumParts[1].trim();

                    // Extracts title and year
                    String title = titleYear.substring(0, titleYear.indexOf("(")).trim();
                    int year = Integer.parseInt(titleYear.substring(titleYear.indexOf("(") + 1, titleYear.indexOf(")")));

                    // Creates new Album object
                    currentAlbum = new Album(albumParts[0], title, year);

                    // Adds currentAlbum to albumCollection
                    albumCollection.addAlbum(currentAlbum);

                }
                // Compares first character, looking for digit
                else if (Character.isDigit(currentLine.charAt(0))) {

                    // Line starts with a duration
                    String[] trackParts = currentLine.split(" - ");
                    String[] durationParts = trackParts[0].trim().split(":");
                    int hours = Integer.parseInt(durationParts[0]);
                    int minutes = Integer.parseInt(durationParts[1]);
                    int seconds = Integer.parseInt(durationParts[2]);

                    // Creates new Duration object
                    Duration trackDuration = new Duration(hours, minutes, seconds);
                    String trackTitle = trackParts[1].trim();

                    // Creates new Track object
                    currentTrack = new Track(trackTitle, trackDuration);
                    if (currentAlbum != null) {

                        // Adds track object into album object
                        currentAlbum.addTrack(currentTrack);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file!");
            e.printStackTrace();
        }

        // Displays album.txt in alphabetical order & Year order for Artist
        albumCollection.sortAlbums();
        System.out.println("Sorted Album Collection:"  + "\n");
        System.out.println(albumCollection);

        System.out.println("-------------------------");

        // Displays total playtime of Kraftwerk albums
        Duration kraftwerkTotalDuration = albumCollection.getTotalDurationForArtist("Kraftwerk");
        System.out.println("Total playtime of Kraftwerk albums: " + kraftwerkTotalDuration + "\n");

        // Displays the album with the shortest title
        Album shortestTitleAlbum = albumCollection.getAlbumWithShortestTitle();
        System.out.println("Album with shortest Album title: " + shortestTitleAlbum + "\n");

        // Displays the longest track
        Track longestTrack = albumCollection.getLongestTrack();
        System.out.println("Track with Longest duration: " + longestTrack);
    }
}
