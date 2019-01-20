package agh.cs.projekt2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DayShifter {
    private WorldMap map;

    public DayShifter(WorldMap map) {
        this.map = map;
    }

    public void shiftDay(int dayNo) {
        HashMap<Position, Animal> animalsWithPositions = map.getAnimals();
        List<Animal> animals = new ArrayList<>(animalsWithPositions.values());
        HashMap<Position, Plant> plants = map.getPlants();
        if (!checkOverpopulation(animals, animalsWithPositions)) {
            handlePlants(dayNo, plants);
            handleAnimals(animals, animalsWithPositions, plants);
        }
    }

    private void handleAnimals(List<Animal> animals, HashMap<Position, Animal> animalsWithPositions, HashMap<Position, Plant> plants) {
        for (Animal animal : animals) {
            if (!killSurroundedAnimal(animal, animalsWithPositions)) {
                moveAnimal(animal, animalsWithPositions);
                tryToEat(animal, plants);
                cleanAnimal(animal, animalsWithPositions);
            }
        }
    }

    private boolean checkOverpopulation(List<Animal> animals, HashMap<Position, Animal> animalsWithPositions) {
        int population = animalsWithPositions.size();
        if (population >= map.getWidth() * map.getHeight() / 6) {
            performCataclysm(animals, animalsWithPositions);
            return true;
        }
        return false;
    }

    private void performCataclysm(List<Animal> animals, HashMap<Position, Animal> animalsWithPositions) {
        int killerIndex = 0;
        int animalsToKill = animalsWithPositions.size() * 8 / 10;
        printCataclysmMessage();
        System.out.print("Population before cataclysm: " + animalsWithPositions.size() + "\n");
        for (Animal animal : animals) {
            System.out.print("Disaster killed an animal at position: " + animal.getPosition().toString() + "\n");
            animalsWithPositions.remove(animal.getPosition());
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
            if (killerIndex >= animalsToKill)
                break;
            killerIndex++;
        }
        printCataclysmMessage();
    }

    private void printCataclysmMessage() {
        for (int i = 0; i < map.getHeight(); i++)
            System.out.print("CATACLYSM!CATACLYSM!CATACLYSM!CATACLYSM!CATACLYSM!\n");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
    }

    private boolean killSurroundedAnimal(Animal animal, HashMap<Position, Animal> animalsWithPositions) {
        Position nextPosition = animal.move(map);
        for (int i = 0; i < 8; i++) {
            if (map.canMoveTo(nextPosition))
                return false;
            nextPosition = animal.move(map);
        }
        animalsWithPositions.remove(animal.getPosition());
        return true;
    }

    private void moveAnimal(Animal animal, HashMap<Position, Animal> animalsWithPositions) {
        Position nextPosition = animal.move(map);
        if (map.canMoveTo(nextPosition)) {
            animalsWithPositions.remove(animal.getPosition());
            animalsWithPositions.put(nextPosition, animal);
            animal.setPosition(nextPosition);
        } else tryToReproduce(animal, animalsWithPositions.get(nextPosition), animalsWithPositions);
        animal.incrementAge();
    }

    private void tryToEat(Animal animal, HashMap<Position, Plant> plants) {
        if (map.hasPlantAt(animal.getPosition())) {
            animal.eat();
            plants.remove(animal.getPosition());
        }
    }

    private void cleanAnimal(Animal animal, HashMap<Position, Animal> animalsWithPositions) {
        if (animal.isOldEnoughToDie()) {
            animalsWithPositions.remove(animal.getPosition());
        }
    }

    private void tryToReproduce(Animal movingAnimal, Animal standingAnimal, HashMap<Position, Animal> animalsWithPositions) {
        if (movingAnimal.getGender().isOppositeGender(standingAnimal.getGender())) {
            if (movingAnimal.canHaveChildren() && standingAnimal.canHaveChildren()) {
                standingAnimal.copulate();
                movingAnimal.copulate();
                if (movingAnimal.getGender() == Gender.MALE) {
                    Animal child = new Animal(standingAnimal, movingAnimal);
                    moveAnimal(standingAnimal, animalsWithPositions);
                    animalsWithPositions.put(child.getPosition(), child);
                } else {
                    Animal child = new Animal(movingAnimal, standingAnimal);
                    moveAnimal(movingAnimal, animalsWithPositions);
                    animalsWithPositions.put(child.getPosition(), child);
                }
            }
        }
    }

    private void handlePlants(int dayNo, HashMap<Position, Plant> plants) {
        int xCoord = (int) (Math.random() * map.getWidth());
        int yCoord = (int) (Math.random() * map.getHeight());
        Position position = new Position(xCoord, yCoord);
        Plant plant = new Plant(position);
        plants.put(position, plant);
        if (dayNo % 2 == 0) {
            int xRange = map.getJungleWidth();
            int yRange = map.getJugleHeight();
            xCoord = (int) (Math.random() * xRange + map.getJungleLowerLeftCorner().x);
            yCoord = (int) (Math.random() * yRange + map.getJungleLowerLeftCorner().y);
            position = new Position(xCoord, yCoord);
            plant = new Plant(position);
            plants.put(position, plant);
        }
    }
}
