package pl.lizardproject.qe2015.calc.structure;

import pl.lizardproject.qe2015.calc.operations.Operation;

public class Tree {

    public Node root;

    public void addOperation(Operation op, double rValue) {
        if(root.operation.getPriority() >= op.getPriority()) {
            final Node newRoot = new Node(op, root, rValue);
            root.parent = newRoot;
            root = newRoot;
        } else {
            if(root.rightNode == null) {
                final Node node = new Node(op, root.rightVal, rValue);
                node.parent = root;
                root.rightNode = node;
            } else {
                final Node node = new Node(op, root.rightNode, rValue);
                root.rightNode.parent = node;
                node.parent = root;
                root.rightNode = node;
            }
        }
    }

    public void addOperation(Operation op, double lValue, double rValue) {
        root = new Node(op, lValue, rValue);
        root.parent = null;
    }

    public void resetVisits() {
        resetVisits(root);
    }

    private void resetVisits(Node node) {
        if(node == null) {
            return;
        }
        node.visited = false;
        if(node.leftNode != null)
            resetVisits(node.leftNode);
        if(node.rightNode != null)
            resetVisits(node.rightNode);
    }

}