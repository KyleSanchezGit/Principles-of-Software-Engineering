package edu.vanderbilt.cs.generics.exercise3;

import edu.vanderbilt.cs.generics.exercise2.Attributed;
import edu.vanderbilt.cs.generics.exercise2.AttributedDataContainer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MappingTest {

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

    private class Name {

    }

    private class Person {

    }

    @Test
    public void testAttributedDataContainerParameterization() {

        Mapping<Car,Dimensons> carDimensions = new Mapping<>();
        carDimensions.setIdentifier(new Car());
        carDimensions.setValue(new Dimensons());
        Car car = carDimensions.getIdentifier();
        Dimensons dims = carDimensions.getValue();

        Mapping<Name,Person> peoplesNames = new Mapping<>();
        peoplesNames.setIdentifier(new Name());
        peoplesNames.setValue(new Person());
        Name name = peoplesNames.getIdentifier();
        Person person = peoplesNames.getValue();
    }


}
