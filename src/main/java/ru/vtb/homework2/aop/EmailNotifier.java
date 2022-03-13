package ru.vtb.homework2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.vtb.homework2.model.Premiere;

@Component
@Aspect
@Profile("Aop")
public class EmailNotifier {

    @After("execution(* ru.vtb.dz2.services.PremiereService.addPremiere(..))")
    private void addPremiereEvent(JoinPoint jp) {
        System.out.println("<< Отправлено письмо(AOP) >> Анонс мероприятия: Концерт '" + ((Premiere) jp.getArgs()[0]).getName() + "'");
    }

    @After("execution(* ru.vtb.dz2.services.PremiereService.deletePremiere(..))")
    private void deletePremiereEvent(JoinPoint jp) {
        System.out.println("<< Отправлено письмо(AOP) >> Перенос мероприятия: Концерт '" + jp.getArgs()[0].toString() + "'");
    }

    @After("execution(* ru.vtb.dz2.services.PremiereService.buyTickets(..))")
    private void buyTicketsEvent(JoinPoint jp) {
        System.out.println("<< Отправлено письмо(AOP) >> Покупка билетов на мероприятие: Концерт '" + jp.getArgs()[0].toString() + "'");
    }
}
