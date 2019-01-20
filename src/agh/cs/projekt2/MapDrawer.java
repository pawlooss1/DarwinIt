package agh.cs.projekt2;

public class MapDrawer {
    private WorldMap map;

    public MapDrawer(WorldMap map) {
        this.map = map;
    }

    public void drawMap(int dayNo) {
        System.out.print("DAY: " + dayNo + " Population: " + map.getAnimals().size() + "\n");
        for (int i = 0; i < map.getWidth() + 2; i++)
            System.out.print("-");
        System.out.print("\n");
        for (int row = map.getHeight() - 1; row >= 0; row--) {
            System.out.print("|");
            for (int column = 0; column < map.getWidth(); column++) {
                Position currentPosition = new Position(column, row);
                if (map.isOccupied(currentPosition))
                    System.out.print(map.getAnimalAt(currentPosition).toString());
                else if (map.hasPlantAt(currentPosition))
                    System.out.print(map.getPlantAt(currentPosition).toString());
                else
                    System.out.print(" ");
            }
            System.out.print("|\n");
        }
        for (int i = 0; i < map.getWidth() + 2; i++)
            System.out.print("-");
        System.out.print("\n");
    }
}
