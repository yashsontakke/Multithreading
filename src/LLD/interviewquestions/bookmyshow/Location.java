package LLD.interviewquestions.bookmyshow;

import java.util.List;

public class Location {
    int locationId ;
    String name ;
    int pincode ;
    List<Movie> movies ;

    public Location(int locationId, String name, int pincode) {
        this.locationId = locationId;
        this.name = name;
        this.pincode = pincode;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
