package agh.cs.projekt2;

public class Simulation {
    private static final int defaultWidth = 60;
    private static final int defaultHeight = 20;

    public static void main(String[] args) {
        WorldMap eden = new WorldMap(defaultWidth, defaultHeight);
        Position initialPosition = new Position(21, 8);
        Animal adam = new Animal(initialPosition, Gender.MALE);
        eden.addAnimal(adam);
        initialPosition = new Position(24, 7);
        Animal eva = new Animal(initialPosition, Gender.FEMALE);
        eden.addAnimal(eva);
        initialPosition = new Position(25, 9);
        adam = new Animal(initialPosition, Gender.MALE);
        eden.addAnimal(adam);
        initialPosition = new Position(27, 10);
        eva = new Animal(initialPosition, Gender.FEMALE);
        eden.addAnimal(eva);
        initialPosition = new Position(30, 12);
        adam = new Animal(initialPosition, Gender.MALE);
        eden.addAnimal(adam);
        initialPosition = new Position(33, 10);
        eva = new Animal(initialPosition, Gender.FEMALE);
        eden.addAnimal(eva);
        MapDrawer drawer = new MapDrawer(eden);
        DayShifter shifter = new DayShifter(eden);
        int dayCounter = 1;
        while (true) {
            try {
                drawer.drawMap(dayCounter);
                Thread.sleep(80);
                shifter.shiftDay(dayCounter);
                Process process = Runtime.getRuntime().exec("clear");
            } catch (Exception e) {
                e.printStackTrace();
            }
            dayCounter++;
        }
    }
}
