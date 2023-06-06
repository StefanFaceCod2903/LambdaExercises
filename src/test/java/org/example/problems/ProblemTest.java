package org.example.problems;

import org.example.Motorcycle;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ProblemTest {

    private Stream<Motorcycle> solution1() {
        Stream<Motorcycle> readMotorcycles;
        try {
            readMotorcycles = Files.lines(Path.of("motorcycles.csv")).map(Motorcycle::new);
            return readMotorcycles;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String[] solution2() {
        //TO DO: Use java streams to write a function that returns the list of all model names from the brand "Ducati"
        //Hint: For this problem and the following you can make use of the readMotorcycles function
        String[] ducatiModels;

        ducatiModels = solution1().filter(e -> e.getBrandName().equals("Ducati")).map(e -> e.getModelName()).toArray(String[]::new);
        return ducatiModels;
    }

    private String solution3() {
        return solution1().max(Comparator.comparingInt(Motorcycle::getTopSpeed)).get().getModelName();
    }

    public Map<String, Double> solution4() {
        return solution1().collect(Collectors.groupingBy(Motorcycle::getBrandName, Collectors.averagingInt(Motorcycle::getTopSpeed)));
    }

    private Stream<Motorcycle> solution5() {
        return solution1().peek(e -> e.setTopSpeed((int) Math.floor(e.getTopSpeed() * 0.621)));
    }
    @Test
    void testReadMotorcycles() {
        assertEquals(Problem1.readStream().collect(Collectors.toList()), solution1().collect(Collectors.toList()));
    }

    @Test
    void testGetDucatiMotorcycles() {
        assertTrue(Arrays.equals(solution2(), Problem2.getDucatiMotorcycles(), String::compareTo));
    }

    @Test
    void testGetFastestMotorcycle() {
        assertEquals(solution3(), Problem3.fastestMotorcycle());
    }
    @Test
    void testGetAverageTopSpeedForBrand() {
        assertEquals(solution4(), Problem4.getAverageTopSpeedForBrand());
    }

    @Test
    void testCovertUnits() {
        Iterator<?> iter1 = solution5().iterator(), iter2 = Problem5.convertUnits().iterator();
        while(iter1.hasNext() && iter2.hasNext())
            assertEquals(iter1.next(), iter2.next());
        assert !iter1.hasNext() && !iter2.hasNext();
    }
}