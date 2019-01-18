package agh.cs.projekt2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
        this.genotype = initRandomGenotype();
    }

    public Animal(Animal mom, Animal dad) {
        this.position = mom.position;
        this.energy = 1000;
        this.direction = dad.direction;
        this.genotype = combineParentsGenotype(mom, dad);
        double random = Math.random();
        if (random < 0.5)
            this.gender = Gender.MALE;
        else
            this.gender = Gender.FEMALE;
    }

    private static HashMap<MoveDirection, Integer> combineParentsGenotype(Animal mom, Animal dad) {
        HashMap<MoveDirection, Integer> genotype = new HashMap<>();
        List<MoveDirection> allDirections = MoveDirection.getAllDirections();
        double random;
        for (MoveDirection direction : allDirections) {
            random = Math.random();
            if (random < 0.5)
                genotype.put(direction, dad.genotype.get(direction));
            else
                genotype.put(direction, mom.genotype.get(direction));
        }
        return genotype;
    }

    private static HashMap<MoveDirection, Integer> initRandomGenotype() {
        HashMap<MoveDirection, Integer> genotype = new HashMap<>();
        List<MoveDirection> allDirections = MoveDirection.getAllDirections();
        int random;
        for (MoveDirection direction : allDirections) {
            random = (int) (Math.random() * 10 + 1);
            genotype.put(direction, random);
        }
        return genotype;
    }
}
