//Student Name: Lahiru Rajakaruna Jayasinghe
//Student ID: 20221791
import java.util.*;

// Main class to test the functionality
public class Main {
    public static void main(String[] args) {
        // Parse the map from file
         Map map;
                try {
                    // Try to parse the map from the file
                    map = MapParser.parseMap("src/benchamrks/puzzle_10.txt");
                } catch (RuntimeException e) {
                    // If an exception is thrown, print the error message and terminate the program
                    System.out.println(e.getMessage());
                    return;
                }
        long startTime = System.currentTimeMillis();

        // Find the shortest path using Dijkstra algorithm
        List<Cell> shortestPath = Dijkstra.findShortestPath(map);

        if (shortestPath == null || shortestPath.isEmpty()) {
            System.out.println("No path found 🥲");
            return;
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;


        // Output the shortest path
        int step = 1;
        Cell start = null;
        for (int i = 0; i < shortestPath.size(); i++) {
            Cell current = shortestPath.get(i);
            if (current.type == 'S') {
                start = current;
                System.out.println(step++ + ". Start at🔰 (" + (start.x + 1) + "," + (start.y + 1) + ")");
            } else if (start != null) {
                System.out.println(step++ + ". Move " + getDirection(shortestPath.get(i-1), current) + " to (" + (current.x + 1) + "," + (current.y + 1) + ")");
            }
        }
        System.out.println(step + ". Done✅");
        // Output the runtime
        System.out.println("⏳Runtime: " + elapsedTime + " ms");
    }

    // This is a helper method to get the direction from one cell to another
    // It takes two cells as input and returns a string representing the direction
    private static String getDirection(Cell from, Cell to) {
        // Check if the from and to cells are null and throw an exception if they are
        if (from == null || to == null) {
            throw new IllegalArgumentException("Cells cannot be null");
        }
        int xComparison = Integer.compare(from.x, to.x);
        int yComparison = Integer.compare(from.y, to.y);

        if (xComparison == 0) {
            return yComparison < 0 ? "down⬇️" : "up⬆️";
        } else {
            return xComparison < 0 ? "right➡️" : "left⬅️";
        }
    }

}

