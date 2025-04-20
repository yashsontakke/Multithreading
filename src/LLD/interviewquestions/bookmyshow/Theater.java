package LLD.interviewquestions.bookmyshow;

import java.util.List;

public class Theater {
    int theaterId ;
    List<Screen> screens ;
    int locationId ;

    public Theater(int theaterId  , int locationId) {
        this.theaterId = theaterId;
        this.locationId = locationId;
    }

    public void addScreen(Screen screen ){
        screens.add(screen);
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

}
