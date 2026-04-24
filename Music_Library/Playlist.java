import java.util.ArrayList;

class Playlist {
    private String playlistName;
    ArrayList<Media> items;

    public Playlist(String playlistName) {
        this.playlistName = playlistName;

    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void addItems(Media other) {
        this.items.add(other);
    }

    public void removeItems(Media other) {
        this.items.remove(other);
    }

    public int getSize(Playlist other) {
        return other.items.size();
    }

    public Media getIndex(int index) {
        return items.get(index);
    }

    public void playAll(Playlist otherobj) {
        for (Media n : otherobj.items) {
            if (n instanceof Song) {
                n.play();
            }
            if (n instanceof PodcastEp) {
                n.play();
            }
        }

    }
}