package com.POOCC.lab05;

import java.util.ArrayList;

public class WarriorPack {
    private ArrayList<Warrior> warriors;

    public WarriorPack() {
        warriors = new ArrayList<>();
    }

    public void addWarrior(Warrior newWarrior) {
        warriors.add(newWarrior);
    }

    public ArrayList<Warrior> getWarriors() {
        return warriors;
    }

    public int calculateDamage() {
        int damage = 0;
        for (Warrior warrior : warriors) {
            damage += warrior.getDamage();
        }
        return damage;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Warrior warrior : warriors) {
            result.append(warrior.toString()).append("\n");
        }
        return result.toString();
    }
}
