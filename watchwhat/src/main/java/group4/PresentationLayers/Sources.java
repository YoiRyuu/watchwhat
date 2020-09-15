package group4.PresentationLayers;

public class Sources {
    private int sources_id;
    private int movie_id;
    private int source_episode;
    private String source_url_watch;
    private String source_url_download;

    public void setSourceID(int scid) {
        this.sources_id = scid;
    }

    public int getSourceID() {
        return sources_id;
    }

    public void setMovieID(int mvid) {
        this.movie_id = mvid;
    }

    public int getMovieID() {
        return movie_id;
    }

    public void setEpisode(int ep) {
        this.source_episode = ep;
    }

    public int getEpisode() {
        return source_episode;
    }

    public void setLinkWatch(String url) {
        this.source_url_watch = url;
    }

    public String getLinkWatch() {
        return source_url_watch;
    }

    public void setLinkDown(String url) {
        this.source_url_download = url;
    }

    public String getLinkDown() {
        return source_url_download;
    }
}
