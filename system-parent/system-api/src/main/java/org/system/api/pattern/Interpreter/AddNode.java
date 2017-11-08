package org.system.api.pattern.Interpreter;

public class AddNode extends SymbolNode {

	public AddNode(Node left, Node right) {
		super(left, right);
	}

	public int interpret() {
		return super.left.interpret() + super.right.interpret();
	}

}
