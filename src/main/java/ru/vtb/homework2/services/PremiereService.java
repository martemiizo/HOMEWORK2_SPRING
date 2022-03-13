package ru.vtb.homework2.services;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.vtb.homework2.events.EvenInfo;
import ru.vtb.homework2.events.PremiereEvent;
import ru.vtb.homework2.model.Premiere;

import java.util.Set;

@Service
public class PremiereService implements ApplicationContextAware {

    private final Premieres premieres;
    private ApplicationContext acx;

    @Autowired
    public PremiereService(Premieres premieres) {
        this.premieres = premieres;
    }

    @Override
    public void setApplicationContext(ApplicationContext acx) throws BeansException {
        this.acx = acx;
    }

    public void addPremiere(Premiere premiere) {
        premieres.getList().add(premiere);
        acx.publishEvent(new PremiereEvent(new EvenInfo(premiere, new Throwable().getStackTrace()[0].getMethodName())));

    }

    public void deletePremiere(String premiereName) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                premieres.getList().remove(p);
                acx.publishEvent(new PremiereEvent(new EvenInfo(p, new Throwable().getStackTrace()[0].getMethodName())));
                return;
            }
        }
    }


    public void changePremiere(String premiereName, String newDescription,
                               Integer newAgeCategory, Integer newNumberOfSeats) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                if (newDescription != null) {
                    p.setDescription(newDescription);
                }
                if (newAgeCategory > 0) {
                    p.setAgeCategory(newAgeCategory);
                }
                if (newAgeCategory >= 1) {
                    p.setAgeCategory(newAgeCategory);
                }
                if (newNumberOfSeats >= 1) {
                    p.setNumberOfSeats(newNumberOfSeats);
                }
            }
        }
    }


    public boolean buyTickets(String premiereName, Integer numTikets) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName) && p.getNumberOfSeats() - numTikets >= 0) {
                p.setNumberOfSeats(p.getNumberOfSeats() - numTikets);
                acx.publishEvent(new PremiereEvent(new EvenInfo(p, new Throwable().getStackTrace()[0].getMethodName())));
                return true;
            }
        }
        return false;
    }

    public void returnTickets(String premiereName, Integer numTikets) {
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                p.setNumberOfSeats(p.getNumberOfSeats() + numTikets);
            }
        }
    }

    public Set<Premiere> getPremieres() {
        return premieres.getList();
    }

    public String getPremeiresInfo(String premiereName) {
        StringBuilder sb = new StringBuilder();
        for (Premiere p : premieres.getList()) {
            if (p.getName().equalsIgnoreCase(premiereName)) {
                return p.toString();
            } else {
                sb.append(p.toString()).append("\n");
            }

        }
        return sb.toString();
    }


}
