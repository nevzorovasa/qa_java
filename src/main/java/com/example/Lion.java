package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final FelineActions felineActions;  // Зависимость только от интерфейса

    public Lion(String sex, FelineActions felineActions) throws Exception {
        this.felineActions = felineActions;

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public int getKittens() {
        return felineActions.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        if (felineActions instanceof Predator) {
            return ((Predator) felineActions).eatMeat();
        } else {
            throw new UnsupportedOperationException("Этот лев не может получить еду!");
        }
    }
}