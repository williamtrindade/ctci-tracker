package CTCI86TowersOfHanoi;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** Torre de Hanói (pilha de discos). Já implementada. */
public class Tower {
    private final Stack<Integer> disks = new Stack<>();
    private final String name;
    private final int[] moveCounter;

    /** moveCounter é compartilhado entre as torres para contar o total de movimentos. */
    public Tower(String name, int[] moveCounter) {
        this.name = name;
        this.moveCounter = moveCounter;
    }

    /** Coloca um disco na torre (usado para montar o estado inicial). */
    public void add(int disk) {
        if (!disks.isEmpty() && disks.peek() <= disk) {
            throw new IllegalStateException("Disco " + disk + " não pode ficar sobre o disco " + disks.peek());
        }
        disks.push(disk);
    }

    /** Move o disco do topo desta torre para o topo de outra. */
    public void moveTopTo(Tower t) {
        if (disks.isEmpty()) {
            throw new IllegalStateException("Torre " + name + " está vazia");
        }
        int top = disks.pop();
        try {
            t.add(top);
        } catch (IllegalStateException e) {
            disks.push(top);
            throw e;
        }
        moveCounter[0]++;
    }

    public int size() {
        return disks.size();
    }

    /** Discos da base para o topo. */
    public List<Integer> disks() {
        return new ArrayList<>(disks);
    }

    @Override
    public String toString() {
        return name + disks;
    }
}
