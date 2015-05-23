package pl.lizardproject.qe2015.calc.structure;

public class TreePrinter {

    public static String printThatTree(Tree tree) {
        StringBuilder builder = new StringBuilder();
        Node node = traverseToLeftMost(tree.root);
        builder.append(node.leftVal).append(" ").append(node.operation).append(" ");
        node.visited = true;
        while(hasNextNode(node)) {
            node = findNextNode(node);
            if(node.leftNode == null) {
                builder.append(node.leftVal).append(" ");
            }
            builder.append(node.operation).append(" ");
            if(node.rightNode == null) {
                builder.append(node.rightVal).append(" ");
            }
            node.visited = true;
        }
        return builder.toString();
    }


    private static Node traverseToLeftMost(Node node) {
        Node temp = node;
        while(temp.leftNode != null) {
            temp = temp.leftNode;
        }
        return temp;
    }

    private static boolean hasNextNode(Node node) {
        return findNextNode(node) != null;
    }

    private static Node findNextNode(Node node) {
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
