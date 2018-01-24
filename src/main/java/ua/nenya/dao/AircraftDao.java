package ua.nenya.dao;

import ua.nenya.domain.Aircraft;
import ua.nenya.domain.AircraftType;

import java.util.List;
import java.util.Map;

public interface AircraftDao {

    List<Aircraft> initAircrafts(Map<String, AircraftType> aircraftTypes);

}
