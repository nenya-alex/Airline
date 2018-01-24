package ua.nenya.dao.memory;

import ua.nenya.dao.AircraftTypeDao;
import ua.nenya.domain.AircraftType;
import ua.nenya.domain.consts.Const;

import java.util.HashMap;
import java.util.Map;

public class AircraftTypeDaoMemoryImpl implements AircraftTypeDao {

    @Override
    public Map<String, AircraftType> initAircraftType() {

        AircraftType airliner = new AircraftType("Airliner");
        AircraftType cargoAircraft = new AircraftType("Cargo Aircraft");
        AircraftType executiveJet = new AircraftType("Executive Jet");


        Map<String, AircraftType> aircraftTypes = new HashMap<>();
        aircraftTypes.put(Const.AIRLINER, airliner);
        aircraftTypes.put(Const.CARGO_AIRCRAFT, cargoAircraft);
        aircraftTypes.put(Const.EXECUTIVE_JET, executiveJet);

        return aircraftTypes;
    }

}
