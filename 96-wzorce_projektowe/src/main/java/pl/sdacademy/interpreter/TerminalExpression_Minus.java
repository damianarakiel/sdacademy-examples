package pl.sdacademy.interpreter;

import java.util.Stack;

public class TerminalExpression_Minus implements Expression {
	@Override
	public void interpret(Stack<Integer> s) {
		s.push(- s.pop() + s.pop());
	}
}
