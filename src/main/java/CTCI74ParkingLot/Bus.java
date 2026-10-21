package CTCI74ParkingLot;

public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public int getSpotsNeeded() {
        return 5;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }
}
