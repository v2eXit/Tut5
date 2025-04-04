import java.util.ArrayList;

public class Playlist {
    private String name;
    private ArrayList<String> tracks;

    public Playlist(String name) {
        this.name = name;
        tracks = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addTrack(String track) {
        if(!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track " + track + " already exists");
        }
    }

    public void removeTrack(String track) {
        boolean result = tracks.remove(track);
        if(!result) {
            System.out.println("Track not found");
        }
    }

    public void display(){
        System.out.println("Playlist name:" + this.name);
        if (tracks.isEmpty()) {
            System.out.println("No tracks found in the playlist");
        } else {
            for (String track : tracks) {
                System.out.println("-" + track);
            }
        }

    }
}
