package ua.nenya.main;

import ua.nenya.dao.AircraftDao;
import ua.nenya.dao.AircraftTypeDao;
import ua.nenya.dao.memory.AircraftDaoMemoryImpl;
import ua.nenya.dao.memory.AircraftTypeDaoMemoryImpl;
import ua.nenya.domain.Aircraft;
import ua.nenya.domain.AircraftType;
import ua.nenya.domain.Airline;

import java.util.List;
import java.util.Map;

public class Initializer {

    private AircraftTypeDao aircraftTypeDao;
    private AircraftDao aircraftDao;

    public Airline initAirline() {
        Airline airline = new Airline();

        aircraftTypeDao = new AircraftTypeDaoMemoryImpl();
        Map<String, AircraftType> aircraftTypes = aircraftTypeDao.initAircraftType();

        aircraftDao = new AircraftDaoMemoryImpl();
        List<Aircraft> aircrafts = aircraftDao.initAircrafts(aircraftTypes);

        airline.setAirCrafts(aircrafts);

        return airline;
    }

}
