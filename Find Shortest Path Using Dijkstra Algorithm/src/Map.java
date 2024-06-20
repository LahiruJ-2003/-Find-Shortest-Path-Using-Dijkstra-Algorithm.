//Student Name: Lahiru Rajakaruna Jayasinghe
//Student ID: 20221791
class Map {
    int width, height; // Width and height of the map
    Cell[][] grid; // 2D array to store the cells

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Cell[height][width]; // Fixing the order of height and width
    }

    public void printMap() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x].type);
            }
            System.out.println();
        }
    }

    // Method to get a cell at given position
    public Cell getCell(int x, int y) {
        return grid[y][x]; // Fixing the order of x and y
    }

    // Method to set a cell at given position
    public void setCell(int x, int y, Cell cell) {
        grid[y][x] = cell; // Fixing the order of x and y
    }
}
