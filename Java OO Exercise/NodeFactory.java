package edu.vanderbilt.cs.oo;
// NodeFactory class for creating instances of CompositeNode and NullNode
public class NodeFactory {

    /**
     * @ToDo
     *
     * Update this to return an instance of your CompositeNode
     *
     * @return
     */


    // Creates and returns a new CompositeNode with the specified value
    public Node newCompositeNode(Double value) {
        return new CompositeNode(value);
    }

    /**
     * @ToDo
     *
     * Update this to return an instance of your NullNode
     *
     * @return
     */
    // Creates and returns a new NullNode
    public static Node newNullNode() {
        return new NullNode();
    }

}
