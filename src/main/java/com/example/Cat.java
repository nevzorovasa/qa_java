package com.example;

import java.util.List;

public class Cat {
    private final Predator predator;  // Теперь зависит от интерфейса

    public Cat(Predator predator) {  // Принимает Predator вместо Feline
        this.predator = predator;
    }

    public String getSound() {
        return "Мяу";
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

}
