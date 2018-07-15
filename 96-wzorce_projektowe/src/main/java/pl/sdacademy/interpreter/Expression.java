package pl.sdacademy.interpreter;

import java.util.Stack;

public interface Expression {
	public void interpret(Stack<Integer> s);
}
