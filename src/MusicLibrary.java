import java.util.ArrayList;
public class MusicLibrary {
    private String libraryName;
    private String owner;
    private ArrayList<String> tracks;
    private ArrayList<Playlist> playlists;
    public MusicLibrary(String libraryName, String owner) {
        this.libraryName = libraryName;
        this.owner = owner;
        this.tracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }
    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track " + track + " already exists in the library.");
        }
    }
    public void removeTrack(String track) {
        if (tracks.remove(track)) {
            for (Playlist playlist : playlists) {
                playlist.removeTrack(track);
            }
        } else {
            System.out.println("Track not found in the library.");
        }
    }
    public void displayTracks() {
        System.out.println("Tracks in the library:");
        if (tracks.isEmpty()) {
            System.out.println("No tracks available.");
        } else {
            for (String track : tracks) {
                System.out.println("- " + track);
            }
        }
    }
    public void searchTracks(String phrase) {
        System.out.println("Tracks containing '" + phrase + "':");
        boolean found = false;
        for (String track : tracks) {
            if (track.toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println("- " + track);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tracks found containing '" + phrase + "'.");
        }
    }
    public void createPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(playlistName)) {
                System.out.println("Playlist " + playlistName + " already exists.");
                return;
            }
        }
        playlists.add(new Playlist(playlistName));
    }
    public Playlist findPlaylist(String playlistName) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equalsIgnoreCase(playlistName)) {
                return playlist;
            }
        }
        return null;
    }
    public void addTrackToPlaylist(String track, String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist == null) {
            System.out.println("Playlist " + playlistName + " not found.");
        } else if (!tracks.contains(track)) {
            System.out.println("Track " + track + " does not exist in the library.");
        } else {
            playlist.addTrack(track);
        }
    }
    public void displayPlaylist(String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist == null) {
            System.out.println("Playlist " + playlistName + " not found.");
        } else {
            playlist.display();
        }
    }
    public void displayAllPlaylists() {
        System.out.println("Playlists in the library:");
        if (playlists.isEmpty()) {
            System.out.println("No playlists available.");
        } else {
            for (Playlist playlist : playlists) {
                System.out.println("- " + playlist.getName());
            }
        }
    }
    public int getTrackCount() {
        return tracks.size();
    }
    public int getPlaylistCount() {
        return playlists.size();
    }
}