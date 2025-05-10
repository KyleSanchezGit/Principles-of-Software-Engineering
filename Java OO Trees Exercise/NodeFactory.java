package edu.vanderbilt.cs.oo;

// The NodeFactory class provides factory methods to create instances of Node, CompositeNode, and NullNode.
// It abstracts the creation process, making it easier to instantiate nodes without knowing the details of their implementation.
public class NodeFactory {

    // Creates a new CompositeNode with the given value.
    // This method serves as a generic node creation method, which currently returns a CompositeNode.
    // @param v The value to be stored in the new node.
    // @return A new instance of CompositeNode initialized with the specified value.
    public Node newNode(Double v) {
        return newCompositeNode(v);
    }

    // Creates a new CompositeNode with the given value and a null parent.
    // This method is specifically used to create instances of CompositeNode.
    // @param v The value to be stored in the new CompositeNode.
    // @return A new instance of CompositeNode initialized with the specified value and no parent.
    public Node newCompositeNode(Double v) {
        return new CompositeNode(v, null);
    }

    // Creates a new NullNode with a null parent.
    // This method is specifically used to create instances of NullNode.
    // @return A new instance of NullNode initialized with no parent.
    public Node newNullNode() {
        return new NullNode(null);
    }
}
