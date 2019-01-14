package agh.cs.projekt2;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Animal {
    private Position position;
    private int energy;
    private MapDirection direction;
    private final Gender gender;
    private final HashMap<MoveDirection, Integer> genotype;

    public Animal(Position position, Gender gender) { // konstruktor dla zwierząt początkowych
        this.position = position;
        this.energy = 1000;
        this.direction = MapDirection.NORTH;
        this.gender = gender;
        this.genotype = Animal.initRandomGenotype();
    }

    public Animal(Animal mom, Animal dad) {
        this.position = mom.position;
        this.energy = 1000;
        this.direction = dad.direction;

    }

    private static HashMap<MoveDirection, Integer> combineParentsGenotype(Animal mom, Animal dad) {
        HashMap<MoveDirection, Integer> genotype = new HashMap<>();
        double random = Math.random();
        if (random < 0.5)
            genotype.put(MoveDirection.FORWARD, dad.genotype.get(MoveDirection.FORWARD));
        else ()
    }

    private static HashMap<MoveDirection, Integer> initRandomGenotype() {
        HashMap<MoveDirection, Integer> genotype = new HashMap<>();
        int random = (int)(Math.random() * 10 + 1);
        genotype.put(MoveDirection.FORWARD, random);
        random = (int)(Math.random() * 10 + 1);
        genotype.put(MoveDirection.BACKWARD, random);
        random = (int)(Math.random() * 10 + 1);
        genotype.put(MoveDirection.LEFT, random);
        random = (int)(Math.random() * 10 + 1);
        genotype.put(MoveDirection.RIGHT, random);
        random = (int)(Math.random() * 10 + 1);
        genotype.put(MoveDirection.FORWARD_LEFT, random);
        random = (int)(Math.random() * 10 + 1);
        genotype.put(MoveDirection.FORWARD_RIGHT, random);
        random = (int)(Math.random() * 10 + 1);
        genotype.put(MoveDirection.BACKWARD_LEFT, random);
        random = (int)(Math.random() * 10 + 1);
        genotype.put(MoveDirection.BACKWARD_RIGHT, random);
    }
}
