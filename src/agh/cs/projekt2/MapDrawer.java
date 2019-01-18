package agh.cs.projekt2;

public class MapDrawer {
    private WorldMap map;

    public MapDrawer(WorldMap map) {
        this.map = map;
    }

    public void draw() {
        for (int row = map.getHeight() - 1; row >= 0; row--) {
            for (int column = 0; column < map.getWidth(); column++) {
                Position currentPosition = new Position(column, row);
                if (map.isOccupied(currentPosition))
                    System.out.print(map.getAnimalAt(currentPosition).toString());
                else if (map.hasPlantAt(currentPosition))
                    System.out.print(map.getPlantAt(currentPosition).toString());
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
