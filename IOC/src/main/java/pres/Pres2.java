package pres;

import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        String metierClassName = scanner.nextLine();
        Class<?> cDao = Class.forName(daoClassName);
        Object dao = cDao.getDeclaredConstructor().newInstance();
        Class<?> cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getDeclaredConstructor().newInstance();
        Method setDao = cMetier.getMethod("setDao", Class.forName("dao.IDao"));
        setDao.invoke(metier, dao);
        System.out.println("Résultat du calcul : " + metier.calcul());
    }
}
