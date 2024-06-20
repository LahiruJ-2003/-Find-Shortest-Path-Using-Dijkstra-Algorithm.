//Student Name: Lahiru Rajakaruna Jayasinghe
//Student ID: 20221791
class Cell {
    int x, y; // The x and y coordinates of the cell in the map
    char type; // Type of cell ('.', '0', 'S', 'F')


    // Constructor for the Cell class
    // It initializes the x and y coordinates and the type of the cell
    public Cell(int x, int y, char type) {
        this.x = x;// Set the x-coordinate
        this.y = y;// Set the y-coordinate
        // Check if the type is valid and set it, otherwise throw an exception
        if (type == '.' || type == '0' || type == 'S' || type == 'F') {
            this.type = type;
        } else {
            throw new IllegalArgumentException("Invalid cell type: " + type);
        }
    }
}
