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
    private int geneSum;

    public Animal(Position position, Gender gender) { // konstruktor dla zwierząt początkowych
        this.position = position;
        this.energy = 1000;
        this.direction = MapDirection.NORTH;
        this.gender = gender;
        this.genotype = initRandomGenotype();
        this.geneSum = initGeneSum();
    }

    public Animal(Animal mom, Animal dad) {
        this.position = mom.position;
        this.energy = 1000;
        this.direction = dad.direction;
        this.genotype = combineParentsGenotype(mom, dad);
        this.geneSum = initGeneSum();
        double random = Math.random();
        if (random < 0.5)
            this.gender = Gender.MALE;
        else
            this.gender = Gender.FEMALE;
    }

    private int initGeneSum() {
        int result = 0;
        for(Integer i : this.genotype.values())
            result += i;
        return result;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void eat() {
        this.energy += 10;
    }

    private static HashMap<MoveDirection, Integer> combineParentsGenotype(Animal mom, Animal dad) {
        HashMap<MoveDirection, Integer> genotype = new LinkedHashMap<>();
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
        HashMap<MoveDirection, Integer> genotype = new LinkedHashMap<>();
        List<MoveDirection> allDirections = MoveDirection.getAllDirections();
        int random;
        for (MoveDirection direction : allDirections) {
            random = (int) (Math.random() * 10 + 1);
            genotype.put(direction, random);
        }
        return genotype;
    }

    public Position move(){
        MoveDirection moveDirection = this.chooseNextStep();
        MapDirection mapDirection = this.rotate(moveDirection);
        int deltaX = mapDirection.computeDeltaX();
        int deltaY = mapDirection.computeDeltaY();
        return new Position((position.x + deltaX), (position.y + deltaY));
    }

    private MapDirection rotate(MoveDirection moveDirection){
        MapDirection result = this.direction;
        int rotationsToDo = moveDirection.howManyRotations();
        for (int i = 0; i < rotationsToDo; i++)
            result = result.rotateRight();
        return result;
    }

    private MoveDirection chooseNextStep() {
        int currentScore = 0;
        int stepThreshold = (int) (Math.random() * geneSum + 1);
        List<MoveDirection> allDirections = MoveDirection.getAllDirections();
        for(MoveDirection direction : allDirections) {
            currentScore += genotype.get(direction);
            if (currentScore >= stepThreshold)
                return direction;
        }
        return MoveDirection.FORWARD;
    }
}
