package edu.vanderbilt.cs.oo;

// Node interface definition
public interface Node {

    // Sets the value stored in the current node
    public void setValue(Double d);

    // Returns the value stored in the current node
    public Double getValue();

    // Sets the parent of the current node
    public void setParent(Node n);

    // Returns the parent of the current node
    public Node getParent();

    // Returns the left child of the current node
    public Node getLeftChild();

    // Returns the right child of the current node
    public Node getRightChild();

    // Replaces one of the children of the current node with a new node
    public void replace(Node child, Node replacement);
}

// CompositeNode class implementation
class CompositeNode implements Node {
    // Member variables for the left and right children, parent, and value
    private Node leftChild;
    private Node rightChild;
    private Node parent;
    private Double value;

    // Constructor initializing the value and setting children to NullNode
    public CompositeNode(Double value) {
        this.leftChild = NodeFactory.newNullNode();
        this.rightChild = NodeFactory.newNullNode();
        this.parent = null;
        this.value = value;
    }

    // Sets the value of the node
    @Override
    public void setValue(Double d) {
        this.value = d;
    }

    // Gets the value of the node
    @Override
    public Double getValue() {
        return this.value;
    }

    // Sets the parent of the node
    @Override
    public void setParent(Node n) {
        this.parent = n;
    }

    // Gets the parent of the node
    @Override
    public Node getParent() {
        return this.parent;
    }

    // Gets the left child of the node
    @Override
    public Node getLeftChild() {
        return this.leftChild;
    }

    // Gets the right child of the node
    @Override
    public Node getRightChild() {
        return this.rightChild;
    }

    // Replaces a specified child node with a new node and updates the parent reference
    @Override
    public void replace(Node child, Node replacement) {
        if (this.leftChild == child) {
            this.leftChild = replacement;
            replacement.setParent(this);
        } else if (this.rightChild == child) {
            this.rightChild = replacement;
            replacement.setParent(this);
        }
    }
}

// NullNode class implementation
class NullNode implements Node {
    // Member variable for the parent
    private Node parent;

    // Throws UnsupportedOperationException as NullNode does not support setting value
    @Override
    public void setValue(Double d) {
        throw new UnsupportedOperationException("NullNode does not support setValue.");
    }

    // Returns a constant value of 0.0 for NullNode
    @Override
    public Double getValue() {
        return 0.0;
    }

    // Sets the parent of the NullNode
    @Override
    public void setParent(Node n) {
        this.parent = n;
    }

    // Gets the parent of the NullNode
    @Override
    public Node getParent() {
        return this.parent;
    }

    // Always returns null for the left child of NullNode
    @Override
    public Node getLeftChild() {
        return null;
    }

    // Always returns null for the right child of NullNode
    @Override
    public Node getRightChild() {
        return null;
    }

    // Does nothing as NullNode does not support replacing children
    @Override
    public void replace(Node child, Node replacement) {
        // Do nothing
    }
}

