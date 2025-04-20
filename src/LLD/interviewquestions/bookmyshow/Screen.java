package LLD.interviewquestions.bookmyshow;

import java.util.List;

public class Screen {

    int screenId ;
    int theaterId ;
    List<Show> shows ;

    public Screen(int screenId, int theaterId) {
        this.screenId = screenId;
        this.theaterId = theaterId;
    }

    public void addShows(Show show){
        shows.add(show);
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }




}
