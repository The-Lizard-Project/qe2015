package pl.lizardproject.qe2015.calc.structure;

public class TreePrinter {

    public static String printThatTree(Tree tree) {
        StringBuilder builder = new StringBuilder();
        Node node = traverseToLeftMost(tree.root);
        builder.append(node.leftVal).append(" ").append(node.operation).append(" ");
        while(hasNextNode(node)) {
            node = findNextNode(node);
            if(node.leftNode == null) {
                builder.append(node.leftVal).append(" ");
            }
            builder.append(node.operation).append(" ");
            if(node.rightNode == null) {
                builder.append(node.rightVal).append(" ");
            }
        }
        builder.append(node.rightVal);
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

        if(node.leftNode == null) {
            if(node.parent != null && node.parent.rightNode != node) {
                return node.parent;
            } else if(node.parent != null && node.parent.rightNode == node) {
                return traverseToLeftMost(node.parent.parent.rightNode);
            }
            return node.parent;
        } else {

        }
        return null;
    }
}
