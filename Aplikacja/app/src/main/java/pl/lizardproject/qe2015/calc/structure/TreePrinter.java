package pl.lizardproject.qe2015.calc.structure;

import java.text.DecimalFormat;

public class TreePrinter {

    public static final DecimalFormat df = new DecimalFormat("#.##");

    public static String printThatTree(Tree tree) {
        if(tree.root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Node node = traverseToLeftMost(tree.root);
        do {
            if(node.leftNode == null) {
                builder.append(df.format(node.leftVal)).append(" ");
            }
            builder.append(node.operation).append(" ");
            if(node.operation.requiresBothArguments()) {
                if(node.rightNode == null) {
                    builder.append(df.format(node.rightVal)).append(" ");
                }
            }
            node.visited = true;
            node = findNextNode(node);
        } while(node != null);
        return builder.toString();
    }

    private static Node traverseToLeftMost(Node node) {
        Node temp = node;
        while(temp.leftNode != null) {
            temp = temp.leftNode;
        }
        return temp;
    }

    private static Node findNextNode(Node node) {
        if(node == null) {
            return null;
        }
        if(node.rightNode != null) {
            return traverseToLeftMost(node.rightNode);
        }
        return findUnvisitedParent(node);
    }

    private static Node findUnvisitedParent(Node node) {
        Node temp = node.parent;
        while(temp != null && temp.visited) {
            temp = temp.parent;
        }
        return temp;
    }
}
