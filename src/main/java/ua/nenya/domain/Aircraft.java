package ua.nenya.domain;

public class Aircraft {

    private double capacity;
    private double carryingCapacity;
    private double flightRange;
    private double fuelConsumption;
    private AircraftType aircraftType;

    public Aircraft(double capacity,
                    double carryingCapacity,
                    double flightRange,
                    double fuelConsumption,
                    AircraftType aircraftType) {
        this.capacity = capacity;
        this.carryingCapacity = carryingCapacity;
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.aircraftType = aircraftType;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(double flightRange) {
        this.flightRange = flightRange;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(AircraftType aircraftType) {
        this.aircraftType = aircraftType;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "capacity=" + capacity +
                ", carryingCapacity=" + carryingCapacity +
                ", flightRange=" + flightRange +
                ", fuelConsumption=" + fuelConsumption +
                ", aircraftType=" + aircraftType.getType() +
                '}';
    }
}
