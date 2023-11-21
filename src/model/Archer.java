package model;

import static service.Game.getRandom;

public class Archer extends Unit {
    public int crit;

    public Archer(String name, int hp, int crit) {
        super(name, hp);
        this.crit = crit;
    }

    @Override
    public void getDmg(int dmg) {
        hp -= dmg;
    }

    public void doDmg(Unit unit) {
        if (getRandom(0, 2) == 1) {
            unit.getDmg(15 + crit);
        } else unit.getDmg(15);
    }

    public int getCrit() {
        return crit;
    }

    @Override
    public String toString() {
        return super.toString() + " Crit : " + crit;
    }
}
