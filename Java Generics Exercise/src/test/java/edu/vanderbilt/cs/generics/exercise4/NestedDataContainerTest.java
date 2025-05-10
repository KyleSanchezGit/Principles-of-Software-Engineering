package edu.vanderbilt.cs.generics.exercise4;

import edu.vanderbilt.cs.generics.exercise2.Attributed;
import edu.vanderbilt.cs.generics.exercise2.AttributedDataContainer;
import edu.vanderbilt.cs.generics.exercise3.Mapping;
import edu.vanderbilt.cs.generics.exercise3.MappingTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class NestedDataContainerTest {

    /**
     * @ToDo
     *
     * AFTER completing the prior exercises, uncomment all of the lines below
     *
     */

    private class Car implements Attributed<String> {

        @Override
        public List<String> getAttributes() {
            return Arrays.asList("color", "doors");
        }
    }

    private class Dimensons implements Attributed<Integer> {

        @Override
        public List<Integer> getAttributes() {
            return Arrays.asList(100, 200);
        }
    }

    @Test
    public void testAttributedDataContainerParameterization() {

        NestedDataContainer<String, Car> container = new NestedDataContainer<>();
        container.setNestedData(new Car());
        List<String> attrs = container.getData().getData().getAttributes();

        NestedDataContainer<Integer, Dimensons> container2 = new NestedDataContainer<>();
        container2.setNestedData(new Dimensons());
        List<Integer> attrs2 = container2.getData().getData().getAttributes();
    }
}
