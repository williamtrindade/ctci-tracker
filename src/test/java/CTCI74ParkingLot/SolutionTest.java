package CTCI74ParkingLot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void vehiclesUseCompatibleSpots() {
        Solution.ParkingLot lot = new Solution.ParkingLot("MCL");
        assertTrue(lot.parkVehicle(new Car("car-1")));        // vai para a C
        assertTrue(lot.parkVehicle(new Car("car-2")));        // vai para a L
        assertFalse(lot.parkVehicle(new Car("car-3")));       // carro não cabe na M
        assertTrue(lot.parkVehicle(new Motorcycle("moto")));  // moto cabe na M
        assertEquals(0, lot.availableSpots());
    }

    @Test
    void busNeedsFiveConsecutiveLargeSpots() {
        Solution.ParkingLot lot = new Solution.ParkingLot("LLLLCLLLL", "LLLLL");
        Bus bus = new Bus("bus");
        assertTrue(lot.parkVehicle(bus)); // só cabe no segundo nível
        assertEquals(9, lot.availableSpots());
        assertFalse(lot.parkVehicle(new Bus("bus-2")));
    }

    @Test
    void busCannotSpanLevels() {
        Solution.ParkingLot lot = new Solution.ParkingLot("LLL", "LL");
        assertFalse(lot.parkVehicle(new Bus("bus")));
    }

    @Test
    void removingFreesSpots() {
        Solution.ParkingLot lot = new Solution.ParkingLot("CLLLLL");
        Bus bus = new Bus("bus");
        assertTrue(lot.parkVehicle(bus));
        Car car = new Car("car");
        assertTrue(lot.parkVehicle(car));
        assertFalse(lot.parkVehicle(new Car("car-2")));
        assertTrue(lot.removeVehicle(bus));
        assertEquals(5, lot.availableSpots());
        assertTrue(lot.parkVehicle(new Car("car-2")));
        assertFalse(lot.removeVehicle(new Car("never-parked")));
    }

    @Test
    void sameVehicleCannotParkTwice() {
        Solution.ParkingLot lot = new Solution.ParkingLot("CC");
        Car car = new Car("car");
        assertTrue(lot.parkVehicle(car));
        assertFalse(lot.parkVehicle(car));
        assertEquals(1, lot.availableSpots());
    }

    @Test
    void motorcyclesAreFlexible() {
        Solution.ParkingLot lot = new Solution.ParkingLot("L");
        assertTrue(lot.parkVehicle(new Motorcycle("m")));
        assertFalse(lot.parkVehicle(new Motorcycle("m2")));
    }
}
