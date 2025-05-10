package edu.vanderbilt.cs.generics.exercise2;

import edu.vanderbilt.cs.generics.exercise1.DataContainer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AttributedDataContainerTest {

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

        AttributedDataContainer<Car> data = new AttributedDataContainer<>();
        data.setData(new Car());
        List<String> attrs = data.getData().getAttributes();
        assertEquals("color", attrs.get(0));
        assertEquals("doors", attrs.get(1));

        AttributedDataContainer<Dimensons> data2 = new AttributedDataContainer<>();
        data2.setData(new Dimensons());
        List<Integer> attrs2 = data2.getData().getAttributes();
        assertEquals(100, attrs2.get(0));
        assertEquals(200, attrs2.get(1));
    }


}
