//Student Name: Lahiru Rajakaruna Jayasinghe
//Student ID: 20221791
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Class to parse the map from a file
class MapParser {

    // This method parses the map from a file
    // It takes a file name as input and returns a map
        public static Map parseMap(String fileName) {
        try {
            // Create a BufferedReader to read the file
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int height = 0;
            int width = 0;
            List<String> lines = new ArrayList<>();

            // Read lines from the file
            while ((line = br.readLine()) != null) {
                width = Math.max(width, line.length());
                line = line.replace(" ", "");
                lines.add(line);
                height++;
            }
            br.close();

            // Create the map object
            Map map = new Map(width, height);

            // Populate the map grid
            for (int y = 0; y < height; y++) { // Fixing loop bounds
                line = lines.get(y);
                for (int x = 0; x < width; x++) { // Fixing loop bounds
                    // Get the cell type from the line
                    char type = line.charAt(x);
                    // Create a new cell with the coordinates and type
                    Cell cell = new Cell(x, y, type);
                    // Set the cell in the map
                    map.setCell(x, y, cell);
                }
            }

            // Return the populated map
            return map;
        } catch (IOException e) {
            // If an exception is thrown, throw a RuntimeException
            throw new RuntimeException("⛔ Error reading file: " + fileName, e);
        }
    }
}
