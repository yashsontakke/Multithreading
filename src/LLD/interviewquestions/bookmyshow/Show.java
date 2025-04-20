package LLD.interviewquestions.bookmyshow;

import java.util.Date;
import java.util.List;

public class Show {
    int showId ;
    int screenId ;
    Date starting ;
    Date ending ;
    int movieId ;
    List<Seat> seats ;

    public Show(int showId, int screenId, Date starting, Date ending, int movieId, List<Seat> seats) {
        this.showId = showId;
        this.screenId = screenId;
        this.starting = starting;
        this.ending = ending;
        this.movieId = movieId;
        this.seats = seats;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
