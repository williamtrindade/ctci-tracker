package CTCI74ParkingLot;

public abstract class Vehicle {
    private final String licensePlate;

    protected Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    /** Quantas vagas o veículo ocupa. */
    public abstract int getSpotsNeeded();

    /** Tamanho do veículo. */
    public abstract VehicleSize getSize();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + licensePlate + ")";
    }
}
