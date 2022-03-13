package ru.vtb.homework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vtb.homework2.model.Premiere;
import ru.vtb.homework2.services.PremiereService;

@SpringBootApplication
public class ConcertsalesSpringApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ConcertsalesSpringApplication.class, args);

        PremiereService premiereService = ctx.getBean(PremiereService.class);

        //Добавили 2 концерта
        premiereService.addPremiere(new Premiere("20 лет", "БИ 2", 20, 10000));
        premiereService.addPremiere(new Premiere("Бордерлайн", "Земфира", 18, 500));

        for (Premiere p :  premiereService.getPremieres()) {
            System.out.println(p.toString());
        }
        System.out.println("======================================================");

        //Добавлен новый концерт
        premiereService.addPremiere(new Premiere("Стендап 2022",  "Евгений Чебатков", 18, 200));

        for (Premiere p :  premiereService.getPremieres()) {
            System.out.println(p.toString());
        }
        System.out.println("======================================================");

        //Удален концерт
        premiereService.deletePremiere("20 лет");
        for (Premiere p :  premiereService.getPremieres()) {
            System.out.println(p.toString());
        }
        System.out.println("======================================================");

        //Куплено 500 билетов на Земфиру
        if (!premiereService.buyTickets("Бордерлайн", 500)) {
            System.out.println("Все билеты на премьру \"Бордерлайн\" выкуплены");
        }

        for (Premiere p :  premiereService.getPremieres()) {
            System.out.println(p.toString());
        }
        System.out.println("======================================================");
    }

}
