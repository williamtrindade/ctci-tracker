package CTCI74ParkingLot;

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public int getSpotsNeeded() {
        return 1;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.COMPACT;
    }
}
