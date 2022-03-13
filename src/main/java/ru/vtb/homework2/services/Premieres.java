package ru.vtb.homework2.services;

import org.springframework.stereotype.Component;
import ru.vtb.homework2.model.Premiere;

import java.util.*;

@Component
public class Premieres {
    private final Set<Premiere> list;

    public Premieres() {
        list = new HashSet<>();
    }

    public Set<Premiere> getList() {
        return list;
    }

}
