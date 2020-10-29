package com.example.lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalGroups {

    private final static ArrayList<Animal> animals = new ArrayList<>(
            Arrays.asList(
                new Animal("Nemo", "Fish", false, false),
                new Animal("Guppie", "Fish", false, false),
                new Animal("Penguin", "Birds", true, false),
                new Animal("Parrot", "Birds", true, true),
                new Animal("Monkey", "Mammals", false, false),
                new Animal("Lemur", "Mammals", false, false)
            )
    );


    public static List<Animal> getAnimals(String group){
        return animals.stream().filter(a -> a.getGroup().equals(group)).collect(Collectors.toList());
    }

    public static Animal getAnimal(String animalName){
        for (Animal a : animals) {
            if (a.getName().equals(animalName)){
                return a;
            }
        }
        return null;
    }

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }
}
