package vtc.Persistance;

import java.sql.Date;

public class Movie {
    private int movieID;
    private String movieNAME;
    private String movieDIC;
    private int movieYEAR;
    private Date moviePREDATE;
    private String movieCOVER;
    private String movieCERTIFICATE;
    private Double movieRate;
    private String movieDescrip;

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
    public void setMovieDIC(String moviedic) {
        this.movieDIC = moviedic;
    }

    public String getMovieDIC() {
        return movieDIC;
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
        this.movieRate=rate;
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

    @Override
    public String toString() {
        return this.movieID + " | " + this.movieNAME + " | " + this.movieDIC + " | " + this.movieYEAR + " | " + this.movieCOVER;
    }
}