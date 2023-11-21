package service;

import model.Archer;
import model.Mage;
import model.Unit;
import model.Warrior;


/*
 Экранизация битвы древних русов против ящеров окаянных на Байкальских водах
 */


public class Demo {

    private boolean turn = true;

    public void demo() {
        Unit[] squadRusov = new Unit[3];
        squadRusov[0] = new Mage("Gandalf", 70, 50);
        squadRusov[1] = new Warrior("DOBROGNEV", 100, 10);
        squadRusov[2] = new Archer("YAYTSESLAV", 80, 10);

        Unit[] squadYasherov = new Unit[3];
        squadYasherov[0] = new Mage("Ящер окаянный", 50, 30);
        squadYasherov[1] = new Warrior("Ящер поганый", 80, 5);
        squadYasherov[2] = new Archer("Ящер проклятый", 65, 10);

        System.out.println("Битва байкальская против ящеров окаянных!");
        System.out.println("Начать битву? y/n ");
        if (!Game.scanner.next().equals("y")) return;

        while ((squadRusov[0].getHp() > 0 || squadRusov[1].getHp() > 0 || squadRusov[2].getHp() > 0)
                && (squadYasherov[0].getHp() > 0 || squadYasherov[1].getHp() > 0 || squadYasherov[2].getHp() > 0)) {

            if (turn) {
                Game.makeTurn(squadRusov, squadYasherov);
                turn = false;
            } else {
                Game.makeTurn(squadYasherov, squadRusov);
                turn = true;
            }

        }

        if (squadRusov[0].getHp() > 0 || squadRusov[1].getHp() > 0 || squadRusov[2].getHp() > 0) {
            System.out.println("Слава русам!");
        } else {
            System.out.println("Ящеры победили");
        }
    }
}
