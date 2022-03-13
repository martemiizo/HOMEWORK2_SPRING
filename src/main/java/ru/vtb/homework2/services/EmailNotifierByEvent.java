package ru.vtb.homework2.services;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.vtb.homework2.events.PremiereEvent;

@Component
@Profile("Event")
public class EmailNotifierByEvent implements ApplicationListener<PremiereEvent> {

    @Override
    public void onApplicationEvent(PremiereEvent event) {

        String method = null;
        if (event.getEvenInfo().getMethod().equalsIgnoreCase("addPremiere")) {
            method = "Анонс мероприятия:";
        } else if (event.getEvenInfo().getMethod().equalsIgnoreCase("deletePremiere")) {
            method = "Перенос мероприятия:";
        } else if (event.getEvenInfo().getMethod().equalsIgnoreCase("buyTickets")) {
            method = "Покупка билетов на мероприятие:";
        }

        System.out.println("<< Отправлено письмо(Event) >> " + method + " Опера '" + event.getEvenInfo().getPremiere().getName()+ "'");
    }
}
