package edu.vanderbilt.cs.oo;

// The CompositeNode class represents a node in a binary tree that holds a value and can have left and right children.
// It implements the Node interface and provides specific behavior for composite nodes in the tree.
public class CompositeNode implements Node {
    // The value stored in this node
    private Double value;

    // The left child node
    private Node leftChild;

    // The right child node
    private Node rightChild;

    // The parent node
    private Node parent;

    // Constructor initializes the CompositeNode with a value and its parent node
    public CompositeNode(Double value, Node parent) {
        this.value = value;
        this.parent = parent;

        // Initialize left and right children as NullNodes
        this.leftChild = new NullNode(this);
        this.rightChild = new NullNode(this);
    }

    // Returns the sum of values in the subtree rooted at this node
    @Override
    public Double sum() {
        // Sum of the current node's value and the sum of its left and right subtrees
        return this.value + this.leftChild.sum() + this.rightChild.sum();
    }

    // Returns the average of values in the subtree rooted at this node
    @Override
    public Double average() {
        // Average is the sum of values divided by the number of nodes
        return this.sum() / this.size();
    }

    // Returns the size of the subtree rooted at this node
    @Override
    public int size() {
        // Size is 1 (for the current node) plus the size of its left and right subtrees
        return 1 + this.leftChild.size() + this.rightChild.size();
    }

    // Inserts a new value into the binary tree rooted at this node
    @Override
    public void insert(Double d) {
        // If the value to insert is less than or equal to the current node's value
        if (d <= this.value) {
            // If the left child is a NullNode, replace it with a new CompositeNode
            if (this.leftChild instanceof NullNode) {
                this.leftChild = new CompositeNode(d, this);
            } else {
                // Otherwise, recursively insert into the left subtree
                this.leftChild.insert(d);
            }
        } else {
            // If the value to insert is greater than the current node's value
            // If the right child is a NullNode, replace it with a new CompositeNode
            if (this.rightChild instanceof NullNode) {
                this.rightChild = new CompositeNode(d, this);
            } else {
                // Otherwise, recursively insert into the right subtree
                this.rightChild.insert(d);
            }
        }
    }

    // Checks if the subtree rooted at this node contains the specified value
    @Override
    public boolean contains(Double value) {
        // If the current node's value matches the specified value, return true
        if (this.value.equals(value)) {
            return true;
        }
        // Otherwise, check if the value is in the left or right subtree
        return this.leftChild.contains(value) || this.rightChild.contains(value);
    }

    // Sets the value of this node
    @Override
    public void setValue(Double d) {
        this.value = d;
    }

    // Returns the value of this node
    @Override
    public Double getValue() {
        return this.value;
    }

    // Sets the parent of this node
    @Override
    public void setParent(Node n) {
        this.parent = n;
    }

    // Returns the parent of this node
    @Override
    public Node getParent() {
        return this.parent;
    }

    // Replaces a child node with another node
    @Override
    public void replace(Node child, Node replacement) {
        // If the left child is to be replaced, update the left child
        if (this.leftChild == child) {
            this.leftChild = replacement;
            // If the right child is to be replaced, update the right child
        } else if (this.rightChild == child) {
            this.rightChild = replacement;
        }
        // Set the parent of the replacement node to the current node
        if (replacement != null) {
            replacement.setParent(this);
        }
    }

    // Returns the left child of this node
    @Override
    public Node getLeftChild() {
        return this.leftChild;
    }

    // Returns the right child of this node
    @Override
    public Node getRightChild() {
        return this.rightChild;
    }
}
