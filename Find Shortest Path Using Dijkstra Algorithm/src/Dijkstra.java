//Student Name: Lahiru Rajakaruna Jayasinghe
//Student ID: 20221791
import java.util.*;

// Inner class to represent a state in the Dijkstra algorithm
// It contains a cell and the distance from the start cell to this cell
class Dijkstra {
    static class State {
        Cell cell;// The current cell
        int distance;// The distance from the start cell to this cell


        // Constructor for the State class
        // It initializes the cell and the distance
        public State(Cell cell, int distance) {
            this.cell = cell;// Set the current cell
            this.distance = distance;// Set the distance
        }
    }

    // This method finds the shortest path in the map using Dijkstra algorithm
    // It takes a map as input and returns a list of cells representing the shortest path
    public static List<Cell> findShortestPath(Map map) {
        // Check if the map is null and throw an exception if it is
        if (map == null) {
            throw new IllegalArgumentException("Map cannot be !!!");
        }
        int[][] distances = new int[map.height][map.width];
        boolean[][] visited = new boolean[map.height][map.width];
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.distance));
        Cell[][] prev = new Cell[map.height][map.width];
        Cell start = null, finish = null;

        for (int y = 0; y < map.height; y++) {
            for (int x = 0; x < map.width; x++) {
                distances[y][x] = Integer.MAX_VALUE;
                if (map.grid[y][x].type == 'S') {
                    start = map.grid[y][x];
                    distances[y][x] = 0;
                    pq.add(new State(start, 0));
                } else if (map.grid[y][x].type == 'F') {
                    finish = map.grid[y][x];
                }
            }
        }

// Main loop of Dijkstra's algorithm
        while (!pq.isEmpty()) {

            // Get the state with the smallest distance
            State current = pq.poll();
            // Get the current cell and its coordinates
            Cell currentCell = current.cell;
            int x = currentCell.x;
            int y = currentCell.y;

            if (visited[y][x]) continue;
            visited[y][x] = true;

            // If we've reached the finish cell, we can stop
            if (currentCell == finish) break;

            // Define the possible directions to move
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            // For each direction...
            for (int[] dir : directions) {
                int newX = x, newY = y;
                // Keep moving in the direction until we hit a wall or the finish
                while (true) {
                    int nextX = newX + dir[0];
                    int nextY = newY + dir[1];
                    // If we're out of bounds or hit a wall, stop moving in this direction
                    if (nextX < 0 || nextX >= map.width || nextY < 0 || nextY >= map.height || map.grid[nextY][nextX].type == '0') {
                        break;
                    }
                    newX = nextX;
                    newY = nextY;
                    // If we've reached the finish, stop moving in this direction
                    if (map.grid[newY][newX].type == 'F') {
                        break;
                    }
                }
                // Get the cell we ended up at
                Cell neighbor = map.grid[newY][newX];
                // If the cell is not a wall...
                if (neighbor.type != '0') {
                    // Calculate the new distance to this cell
                    int newDistance = distances[y][x] + 1;
                    // If the new distance is smaller than the current distance...
                    if (newDistance < distances[newY][newX]) {
                        // Update the distance
                        distances[newY][newX] = newDistance;
                        // Add the state to the priority queue
                        pq.add(new State(neighbor, newDistance));
                        // Update the previous cell for this cell
                        prev[newY][newX] = currentCell;
                    }
                }
            }
        }

        // Create a list to store the shortest path
        List<Cell> path = new ArrayList<>();
        Cell current = finish;
        // Build the path by following the prev pointers from the finish to the start
        while (current != null) {
            path.add(current);
            current = prev[current.y][current.x];
        }
        // Reverse the path to get it from start to finish
        Collections.reverse(path);

        // Return the shortest path
        return path;
    }
}
