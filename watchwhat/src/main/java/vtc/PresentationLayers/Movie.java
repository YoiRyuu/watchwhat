package vtc.PresentationLayers;

import java.sql.Date;

public class Movie {
    private int movieID;
    private String movieNAME;
    private String movieDIRECTORS;
    private String movieCAST;
    private int movieYEAR;
    private Date moviePREDATE;
    private String movieCOVER;
    private String movieCERTIFICATE;
    private Double movieRate;
    private String movieDescrip;
    private String movieNation;
    private String movieTag;

    // movie ID
    public void setMovieID(int movieid) {
        this.movieID = movieid;
    }

    public int getMovieID() {
        return movieID;
    }

    // movie Name
    public void setMovieNAME(String moviename) {
        this.movieNAME = moviename;
    }

    public String getMovieNAME() {
        return movieNAME;
    }

    // movie dicretor
    public void setMovieDIRECTORS(String moviedir) {
        this.movieDIRECTORS = moviedir;
    }

    public String getMovieDIRECTORS() {
        return movieDIRECTORS;
    }

    // movie dicretor
    public void setMovieCAST(String moviecast) {
        this.movieCAST = moviecast;
    }

    public String getMovieCAST() {
        return movieCAST;
    }

    // movie year
    public void setMovieYEAR(int movieyear) {
        this.movieYEAR = movieyear;
    }

    public int getMovieYEAR() {
        return movieYEAR;
    }

    // movie premiere date
    public void setmoviePREDATE(Date moviepredate) {
        this.moviePREDATE = moviepredate;
    }

    public Date getmoviePREDATE() {
        return moviePREDATE;
    }

    // movie image cover
    public void setmovieCOVER(String moviecover) {
        this.movieCOVER = moviecover;
    }

    public String getmovieCOVER() {
        return movieCOVER;
    }

    // movie certificate
    public void setmovieCERTIFICATE(String moviecertificate) {
        this.movieCERTIFICATE = moviecertificate;
    }

    public String getmovieCERTIFICATE() {
        return movieCERTIFICATE;
    }

    // movie rate
    public void setmovieRate(Double rate) {
        this.movieRate = rate;
    }

    public Double getmovieRate() {
        return movieRate;
    }

    // movie description
    public void setmovieDescription(String Descrip) {
        this.movieDescrip = Descrip;
    }

    public String getmovieDescription() {
        return movieDescrip;
    }

    // movie nation
    public void setmovieNation(String na) {
        this.movieNation = na;
    }

    public String getmovieNation() {
        return movieNation;
    }

    // movie tag
    public void setmovieTag(String tag) {
        this.movieTag = tag;
    }

    public String getmovieTag() {
        return movieTag;
    }
}
