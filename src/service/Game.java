package service;

import model.Unit;

import java.util.Scanner;

public class Game {

    public static final Scanner scanner = new Scanner(System.in);

    public static int getRandom(int min, int max) {
        return  min + (int)(Math.random() * (max - min + 1));
    }

    public static void makeTurn(Unit[] offense, Unit[] defense) {
        System.out.println("Отряд нападающих:");
        for (int i = 0; i < offense.length; i++) {
            if (offense[i].getHp() > 0) {
                System.out.println((i + 1) + ". " + offense[i].toString());
            }
        }
        System.out.println("Отряд защищающихся:");
        for (int i = 0; i < defense.length; i++) {
            if (defense[i].getHp() > 0) {
                System.out.println((i + 1) + ". " + defense[i].toString());
            }
        }

        System.out.println("Выберите нападающего:");
        int offenser = scanner.nextInt();
        while (offenser < 1 || offenser > offense.length || offense[offenser - 1].getHp() <= 0) {
            System.out.println("Такого нападающего нет!");
            offenser = scanner.nextInt();
        }


        System.out.println("Выберите кого атаковать:");
        int defenser = scanner.nextInt();
        while (defenser < 1 || defenser > defense.length || defense[defenser - 1].getHp() <= 0) {
            System.out.println("Выберите правильную цель!");
            defenser = scanner.nextInt();
        }

        offense[offenser - 1].doDmg(defense[defenser - 1]);
        if (defense[defenser - 1].getHp() <= 0) {
            System.out.println(defense[defenser - 1].toString() + " повержен " + offense[offenser - 1]);
        }
        else {
            System.out.println(defense[defenser - 1].toString() + " получает урон от " + offense[offenser - 1]);
        }
    }
}
