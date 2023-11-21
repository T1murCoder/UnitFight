package model;

public class Mage extends Unit {
    private int mp;

    public Mage(String name, int hp, int mp) {
        super(name, hp);
        this.mp = mp;
    }

    public int getMp() {
        return mp;
    }

    @Override
    public void getDmg(int dmg) {
        hp -= dmg;
    }

    @Override
    public void doDmg(Unit unit) {
        if (mp >= 5) {
            mp -= 5;
            unit.getDmg(20);
        } else {
            unit.getDmg(2);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Mp : " + mp;
    }
}
