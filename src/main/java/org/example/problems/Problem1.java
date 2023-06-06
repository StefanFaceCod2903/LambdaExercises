package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Problem1 {
    //TO DO: Implement the following function to read all the entries from the motorcycle.csv file
    //Hint: https://reflectoring.io/processing-files-using-java-8-streams/
    public static Stream<Motorcycle> readStream() {
        Stream<Motorcycle> readMotorcycles;
        try {
            readMotorcycles = Files.lines(Path.of("motorcycles.csv")).map(Motorcycle::new);
            return readMotorcycles;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
