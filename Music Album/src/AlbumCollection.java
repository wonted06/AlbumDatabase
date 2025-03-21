// AlbumCollection.java
import java.util.*;

public class AlbumCollection {
    // Member variable
    private List<Album> albums;

    // Constructor - initialises these fields
    public AlbumCollection() {
        this.albums = new ArrayList<>();
    }

    // Method to add an album to collection
    public void addAlbum(Album album) {
        albums.add(album);
    }

    // Method to sort album in alphabetical order and year order
    public void sortAlbums() {
        Collections.sort(albums,(a1, a2) -> {

            // compareTo - compares artist names with the following
            int artistCompare = a1.getArtist().compareTo(a2.getArtist());
            if (artistCompare == 0) {

                //.compare- compares the year of albums
                return Integer.compare(a1.getYear(), a2.getYear());
            }
            return artistCompare;
        });
    }


    // Method to get total duration of albums by an artist
    public Duration getTotalDurationForArtist(String artist) {
        // Creates new Duration object
        Duration totalDuration = new Duration(0, 0, 0);
        for (Album album : albums) {
            // Looks for 'Kraftwerk'
            if (album.getArtist().contains("Kraftwerk")) {
                for (Track track : album.getTracks()) {
                    // Adds duration of tracks, gets totalDuration
                    totalDuration = totalDuration.add(track.getDuration());
                }
            }
        }
        return totalDuration;
    }

    // Method to get the album with the shortest title
    public Album getAlbumWithShortestTitle() {
        Album shortestTitleAlbum = null;
        for (Album album : albums) {
            // Compares length of Album titles
            if (shortestTitleAlbum == null || album.getTitle().length() < shortestTitleAlbum.getTitle().length()) {
                shortestTitleAlbum = album;
            }
        }
        return shortestTitleAlbum;
    }

    // Method to get the longest track in the collection
    public Track getLongestTrack() {
        Track longestTrack = null;
        for (Album album : albums) {
            for (Track track : album.getTracks()) {
                // Compares Duration of tracks
                if (longestTrack == null || track.getDuration().compareTo(longestTrack.getDuration()) > 0) {
                    longestTrack = track;
                }
            }
        }
        return longestTrack;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Album album : albums) {
            sb.append(album.toString()).append("\n");
        }
        return sb.toString();
    }

    // Test Harness
    public static void main(String[] args) {

        AlbumCollection collection = new AlbumCollection();
        Track currentTrack = null;

        // Create track instances
        Duration trackDuration1 = new Duration(0, 3, 45);
        Track track1 = new Track("Foxy Lady", trackDuration1);

        Duration trackDuration2 = new Duration(0, 4, 10);
        Track track2 = new Track("Purple Haze", trackDuration2);

        // Create album instances
        List<Track> tracks1 = new ArrayList<>();
        tracks1.add(track1);
        Album album1 = new Album("The Jimi Hendrix Experience", "Are You Experienced?", 1967);

        List<Track> tracks2 = new ArrayList<>();
        tracks2.add(track2);
        Album album2 = new Album("The Jimi Hendrix Experience", "Axis: Bold As Love", 1967);

        // Add albums to album collection
        collection.addAlbum(album1);
        collection.addAlbum(album2);

        // Test sorting by artist and year of release
        System.out.println("Album Collection sorted by Artist and Year:");
        System.out.println(collection);

        // Test total playtime of Kraftwerk albums
        Duration kraftwerkTotalDuration = collection.getTotalDurationForArtist("Kraftwerk");
        System.out.println("Total playtime of Kraftwerk albums: " + kraftwerkTotalDuration + "\n");

        // Test finding album with shortest title
        System.out.println("Album with the shortest title: " + collection.getAlbumWithShortestTitle());

        // Test longest track in the collection
        // Display the longest track
        Track longestTrack = collection.getLongestTrack();
        System.out.println("Track with Longest duration: " + longestTrack);
    }
}



