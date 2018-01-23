package ua.nenya.domain;

import java.util.ArrayList;
import java.util.List;

public class Airline {

    List<Aircraft> airCrafts = new ArrayList<>();

    public List<Aircraft> getAirCrafts() {
        return airCrafts;
    }

    public void setAirCrafts(List<Aircraft> airCrafts) {
        this.airCrafts = airCrafts;
    }
}
