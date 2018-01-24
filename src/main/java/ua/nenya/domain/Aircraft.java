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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        if (Double.compare(aircraft.capacity, capacity) != 0) return false;
        if (Double.compare(aircraft.carryingCapacity, carryingCapacity) != 0) return false;
        if (Double.compare(aircraft.flightRange, flightRange) != 0) return false;
        if (Double.compare(aircraft.fuelConsumption, fuelConsumption) != 0) return false;
        return aircraftType != null ? aircraftType.equals(aircraft.aircraftType) : aircraft.aircraftType == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(capacity);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(carryingCapacity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(flightRange);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fuelConsumption);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (aircraftType != null ? aircraftType.hashCode() : 0);
        return result;
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
