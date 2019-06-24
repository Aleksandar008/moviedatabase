package aleksandar.moviesdatabase.models;

import java.util.ArrayList;

public class VideoModel {
    int id;
    ArrayList<Video> results = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Video> getResults() {
        return results;
    }

    public void setResults(ArrayList<Video> results) {
        this.results = results;
    }
}
