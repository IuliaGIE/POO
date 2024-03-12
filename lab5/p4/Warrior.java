package com.POOCC.lab05;

public abstract class Warrior {
    public static final int SNAKE_Warrior = 0;
    public static final int OGRE_Warrior = 1;
    public static final int MARSHMALLOW_MAN_Warrior = 2;

    private int health;
    private String name;

    public Warrior(int health, String name) {
        this.health = health;
        this.name = name;
    }

    public abstract int getDamage();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() + ", Name: " + name + ", Health: " + health;
    }
}
