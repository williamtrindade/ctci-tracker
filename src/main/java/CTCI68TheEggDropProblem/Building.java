package CTCI68TheEggDropProblem;

/** Prédio que conta os lançamentos e os ovos quebrados. Já implementado. */
public class Building {
    private final int floors;
    private final int breakingFloor;
    private int drops = 0;
    private int brokenEggs = 0;

    public Building(int floors, int breakingFloor) {
        this.floors = floors;
        this.breakingFloor = breakingFloor;
    }

    public int getFloors() {
        return floors;
    }

    /** Lança um ovo do andar dado (1..floors). Retorna true se o ovo quebrou. */
    public boolean drop(int floor) {
        if (floor < 1 || floor > floors) {
            throw new IllegalArgumentException("Andar inválido: " + floor);
        }
        if (brokenEggs >= 2) {
            throw new IllegalStateException("Você não tem mais ovos!");
        }
        drops++;
        boolean breaks = floor >= breakingFloor;
        if (breaks) {
            brokenEggs++;
        }
        return breaks;
    }

    public int getDrops() {
        return drops;
    }

    public int getBrokenEggs() {
        return brokenEggs;
    }
}
