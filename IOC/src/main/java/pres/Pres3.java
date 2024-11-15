package pres;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Pres3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        IMetier metier = (IMetier) context.getBean("metier");
        System.out.println("Résultat du calcul : " + metier.calcul());
    }
}
