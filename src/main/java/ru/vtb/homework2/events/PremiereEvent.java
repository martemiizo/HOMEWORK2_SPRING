package ru.vtb.homework2.events;

import org.springframework.context.ApplicationEvent;

public class PremiereEvent extends ApplicationEvent {
    private EvenInfo evenInfo;


    public PremiereEvent(EvenInfo evenInfo) {
        super(evenInfo);
        this.evenInfo = evenInfo;
    }

    public EvenInfo getEvenInfo() {
        return evenInfo;
    }
}
