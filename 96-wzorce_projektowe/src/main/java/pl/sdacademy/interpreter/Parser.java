package pl.sdacademy.interpreter;

import java.util.*;

public class Parser {
	private List<Expression> parseTree = new ArrayList<Expression>();

	public Parser(String s){
	for (String token : s.split(" ")){
		if(token.equals("+")) parseTree.add(new TerminalExpression_Plus());
		else if(token.equals("-")) parseTree.add(new TerminalExpression_Minus());

		else parseTree.add(new TerminalExpression_Number(Integer.parseInt(token)));
		}
	}
	public int evaluate(){
		Stack<Integer> context = new Stack<Integer>();
		// To:
		Iterator<Expression> parseTreeIterator = parseTree.iterator();
		while (parseTreeIterator.hasNext()){
			parseTreeIterator.next().interpret(context);
		}
		// Lub to:
		// for (Expression e : parseTree) e.interpret(context);
		return context.pop();
	}
}