package edu.vanderbilt.cs.generics.exercise1;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class DataContainerTest {

    @Test
    public void testDataContainerParameterization() {

        DataContainer<String> data = new DataContainer<>();
        data.setData("test");
        String str = data.getData();
        assertEquals("test", str);

        DataContainer<Integer> data2 = new DataContainer<>();
        data2.setData(1);
        int i = data2.getData();
        assertEquals(1, i);

        DataContainer<BiFunction> data3 = new DataContainer();
        data3.setData((a,b) -> b);
        assertEquals(2, data3.getData().apply(1,2));
    }

}
