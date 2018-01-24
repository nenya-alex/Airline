package ua.nenya.dao.memory;

import ua.nenya.dao.AircraftDao;
import ua.nenya.domain.Aircraft;
import ua.nenya.domain.AircraftType;
import ua.nenya.domain.consts.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AircraftDaoMemoryImpl implements AircraftDao {

    @Override
    public List<Aircraft> initAircrafts(Map<String, AircraftType> aircraftTypes) {

        List<Aircraft> aircrafts = new ArrayList<>();

        Aircraft airlinerFirst = new Aircraft(1000, 1000, 1000, 1000, aircraftTypes.get(Const.AIRLINER));
        Aircraft airlinerSecond = new Aircraft(2000, 2000, 2000, 2000, aircraftTypes.get(Const.AIRLINER));

        Aircraft cargoAircraftFirst = new Aircraft(3000, 3000, 3000, 3000, aircraftTypes.get(Const.CARGO_AIRCRAFT));
        Aircraft cargoAircraftSecond = new Aircraft(4000, 4000, 4000, 4000, aircraftTypes.get(Const.CARGO_AIRCRAFT));
        Aircraft cargoAircraftThird = new Aircraft(5000, 5000, 2000, 5000, aircraftTypes.get(Const.CARGO_AIRCRAFT));

        Aircraft executiveJetFirst = new Aircraft(1000, 100, 6000, 1000, aircraftTypes.get(Const.EXECUTIVE_JET));
        Aircraft executiveJetSecond = new Aircraft(2000, 200, 5000, 1500, aircraftTypes.get(Const.EXECUTIVE_JET));
        Aircraft executiveJetThird = new Aircraft(3000, 300, 8000, 2000, aircraftTypes.get(Const.EXECUTIVE_JET));
        Aircraft executiveJetFourth = new Aircraft(4000, 400, 9000, 2500, aircraftTypes.get(Const.EXECUTIVE_JET));

        aircrafts.add(airlinerFirst);
        aircrafts.add(airlinerSecond);
        aircrafts.add(cargoAircraftFirst);
        aircrafts.add(cargoAircraftSecond);
        aircrafts.add(cargoAircraftThird);
        aircrafts.add(executiveJetFirst);
        aircrafts.add(executiveJetSecond);
        aircrafts.add(executiveJetThird);
        aircrafts.add(executiveJetFourth);

        return aircrafts;
    }

}
