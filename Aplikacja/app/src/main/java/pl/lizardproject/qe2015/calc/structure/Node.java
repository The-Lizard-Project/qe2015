package pl.lizardproject.qe2015.calc.structure;

import pl.lizardproject.qe2015.calc.operations.Operation;

public class Node {

	Operation operation;
	Node parent;
	Node leftNode;
	Node rightNode;
	Double leftVal;
	Double rightVal;
	boolean visited;

	public Node(Operation operation, Node leftNode, double rightVal) {
		this.operation = operation;
		this.leftNode = leftNode;
		this.rightVal = rightVal;
	}

	public Node(Operation operation, double leftVal, double rightVal) {
		this.operation = operation;
		this.rightVal = rightVal;
		this.leftVal = leftVal;
	}

	public double calculate() {
		if (leftNode != null) {
			leftVal = leftNode.calculate();
		}
		if (rightNode != null) {
			rightVal = rightNode.calculate();
		}
		return operation.execute(leftVal, rightVal);
	}
}
