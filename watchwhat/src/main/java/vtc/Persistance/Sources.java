package vtc.Persistance;

public class Sources {
    private int ScID;
    private int episode;
    private String sc_url;
    private int movie_id;

    public void setSourceID(int scid) {
        this.ScID = scid;
    }

    public int getSourceID() {
        return ScID;
    }
    public void setEpisode(int ep) {
        this.episode = ep;
    }

    public int getEpisode() {
        return episode;
    }
    public void setMovieID(int mvid) {
        this.movie_id = mvid;
    }

    public int getMovieID() {
        return movie_id;
    }
    public void setLink(String url) {
        this.sc_url = url;
    }

    public String getLink() {
        return sc_url;
    }

    @Override
    public String toString() {
        return " Episode: " + this.episode + " | " + this.sc_url;
    }
}