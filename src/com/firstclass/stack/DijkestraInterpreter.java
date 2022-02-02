package com.firstclass.stack;

public class DijkestraInterpreter {

	private java.util.Stack<String> operationStack;
	private java.util.Stack<Double> valueStack;

	public DijkestraInterpreter() {
		this.operationStack = new java.util.Stack<>();
		this.valueStack = new java.util.Stack<>();
	}

	public void interpretExpression(String expression) {

		String[] expressionArray = expression.split(" ");

		for (String s : expressionArray) {

			if (s.equals("(")) {
				// do nothing !!!
			} else if (s.equals("+")) {
				this.operationStack.push(s);
			} else if (s.equals("*")) {
				this.operationStack.push(s);
			} else if (s.equals(")")) {

				String operation = this.operationStack.pop();

				if (operation.equals("+")) {
					this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
				} else if (operation.equals("*")) {
					this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
				}
			} else {
				this.valueStack.push(Double.parseDouble(s));
			}
		}
	}

	public void result() {
		System.out.println(this.valueStack.pop());
	}

	public static void main(String[] args) {
		DijkestraInterpreter algorithm = new DijkestraInterpreter();

		algorithm.interpretExpression("( ( 1 + 2 ) * ( 2 + 1 ) )");

		algorithm.result();

	}

}
