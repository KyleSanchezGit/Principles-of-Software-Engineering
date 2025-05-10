package edu.vanderbilt.cs.generics;

import edu.vanderbilt.cs.generics.exercise1.DataContainer;
import edu.vanderbilt.cs.generics.exercise1.DataContainerTest;
import edu.vanderbilt.cs.generics.exercise2.AttributedDataContainer;
import edu.vanderbilt.cs.generics.exercise3.MappingTest;
import edu.vanderbilt.cs.generics.exercise4.NestedDataContainerTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( { DataContainerTest.class, AttributedDataContainer.class, MappingTest.class, NestedDataContainerTest.class} )
public class AutograderSuite {
}
