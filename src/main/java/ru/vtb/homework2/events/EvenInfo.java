package ru.vtb.homework2.events;

import ru.vtb.homework2.model.Premiere;

public class EvenInfo {

    private Premiere premiere;
    private String method;

    public EvenInfo(Premiere premiere, String method) {
        this.premiere = premiere;
        this.method = method;
    }

    public Premiere getPremiere() {
        return premiere;
    }

    public String getMethod() {
        return method;
    }
}