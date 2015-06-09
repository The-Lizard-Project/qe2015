package pl.lizardproject.qe2015.patterns;

import pl.lizardproject.qe2015.patterns.model.NumberList;

public class NumberListGeanie {

    private static NumberList numberListA = new NumberList("5,6.7,33,15,10", "33", "5");
    private static NumberList numberListB = new NumberList("7,10.5,11,150,10,1", "150", "1");

    public static NumberList giveMeNumberListA() {
        return numberListA;
    }

    public static NumberList giveMeNumberListB() {
        return numberListB;
    }
}