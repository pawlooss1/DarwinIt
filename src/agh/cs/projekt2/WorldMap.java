package agh.cs.projekt2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class WorldMap {
    private int width;
    private int height;
    private int jungleWidth;
    private int jugleHeight;
    private Position upperRightCorner;
    private Position lowerLeftCorner;
    private Position jungleUpperRightCorner;
    private Position jungleLowerLeftCorner;
    private HashMap<Position, Animal> animals;
    private HashMap<Position, Plant> plants;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.jungleWidth = width / 3;
        this.jugleHeight = height / 3;
        this.upperRightCorner = new Position(width - 1, height - 1);
        this.lowerLeftCorner = new Position(0, 0);
        this.jungleUpperRightCorner = new Position(width * 2 / 3, height * 2 / 3);
        this.jungleLowerLeftCorner = new Position(width / 3, height / 3);
        this.animals = new LinkedHashMap<>();
        this.plants = new LinkedHashMap<>();
    }

    public HashMap<Position, Animal> getAnimals() {
        return animals;
    }

    public HashMap<Position, Plant> getPlants() {
        return plants;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getJugleHeight() {
        return jugleHeight;
    }

    public int getJungleWidth() {
        return jungleWidth;
    }

    public Position getJungleLowerLeftCorner() {
        return jungleLowerLeftCorner;
    }

    public Position getJungleUpperRightCorner() {
        return jungleUpperRightCorner;
    }

    public void placeAnimal(Animal animal) {
        animals.put(animal.getPosition(), animal);
    }

    public boolean canMoveTo(Position position) {
        return !this.isOccupied(position);
    }

    public boolean isOccupied(Position position) {
        return animals.containsKey(position);
    }

    public boolean hasPlantAt(Position position) {
        return plants.containsKey(position);
    }

    public void addAnimal(Animal animal) {
        this.animals.put(animal.getPosition(), animal);
    }

    public void addPlant(Plant plant) {
        this.plants.put(plant.getPosition(), plant);
    }

    public Animal getAnimalAt(Position position) {
        return animals.get(position);
    }

    public Plant getPlantAt(Position position) {
        return plants.get(position);
    }
}
