package CTCI74ParkingLot;

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public int getSpotsNeeded() {
        return 1;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MOTORCYCLE;
    }
}
