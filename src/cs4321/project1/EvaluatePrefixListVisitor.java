package cs4321.project1;

import cs4321.project1.list.*;
import java.util.Stack;

/**
 * Traverses a list representing an expression in prefix form, 
 * and evaluates the expression to a single number.
 * It is done by maintianing 2 separate stacks, 
 * one for operators and one for operands
 * 
 * @authors 
 * Shweta Shrivastava - ss3646
 * Vikas P Nelamangala - vpn6
 * Saarthak Chandra - sc2776
 */

public class EvaluatePrefixListVisitor implements ListVisitor {

	private Stack<Pair<Character, Integer>> OperatorStack = new Stack<Pair<Character, Integer>>();
	private Stack<Double> OperandStack = new Stack<Double>();
	private Double result;
	
	public EvaluatePrefixListVisitor() {
		// TODO fill me in
		result = new Double("0.0");
	}

	/**
	 * Method to get the final result from the Operand stack
	 * 
	 * @return the evaluated result
	 */
	public double getResult() {
		// TODO fill me in
		return OperandStack.pop(); 
	}

	@Override
	/**
	 * Method to handle the NumberListNode
	 * If an operand is encountered, check the operator stack
	 * If it is not empty, check the top entry
	 * See if enough number of operands are present to perform the operation
	 * If yes, evaluate using the operand stack and push the result back and reiterate
	 * If no, decrease the number of operands needed for the topmost operator
	 * 
	 * @param node 
	 * 			the NumberListNode element being visited
	 */
	public void visit(NumberListNode node) {
		// TODO fill me in
		OperandStack.push(node.getData());
		
		while(!OperatorStack.empty())
		{
			Pair<Character,Integer> currentOperator = OperatorStack.pop();
			Character operator = currentOperator.getKey();
			Integer newReducedValue = currentOperator.getValue() - 1;
			Pair<Character,Integer> newOperatorPair = new Pair<Character,Integer>(operator,newReducedValue);
			
			if((newOperatorPair.getValue()).compareTo(new Integer("0")) == 0){
				switch(currentOperator.getKey()){
					case '+' : {
								Double right = OperandStack.pop();
								Double left = OperandStack.pop();
								result = left + right;
								}
								break;
								
					case '-' : {
								Double right = OperandStack.pop();
								Double left = OperandStack.pop();
								result = left - right;
								}
								break;
								
					case '*' : {
								Double right = OperandStack.pop();
								Double left = OperandStack.pop();
								result = left * right;
								}
								break;

					case '/' : {
								Double right = OperandStack.pop();
								Double left = OperandStack.pop();
								//If division leads to an invalid operation (divide by zero), we set result back to 0 
								if(right.compareTo(new Double("0.0")) == 0)
									result = new Double("0");
								else
									result = left / right;
								}
								break;
								
					case '~' : {
								Double num = OperandStack.pop();
								result = 0 - num;
								}
								break;

					default : System.out.println("This is impossible!");			
				}
				OperandStack.push(result);
			}
			
			else 
			{
				OperatorStack.push(newOperatorPair);
				break;
			}
				
		}
		
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle AdditionListNode
	 * Push (+,2) to the operator stack
	 * 
	 * @param node
	 * 			 the AdditionListNode element being visited
	 */
	public void visit(AdditionListNode node) {
		// TODO fill me in
		Pair<Character, Integer> operatorPair = new Pair<Character, Integer>('+',2);
		OperatorStack.push(operatorPair);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle SubtractionListNode
	 * Push (-,2) to the operator stack
	 * 
	 * @param node
	 * 			 the SubtractionListNode element being visited
	 */
	public void visit(SubtractionListNode node) {
		// TODO fill me in
		Pair<Character, Integer> operatorPair = new Pair<Character, Integer>('-',2);
		OperatorStack.push(operatorPair);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle MultiplicationListNode
	 * Push (*,2) to the operator stack
	 * 
	 * @param node
	 * 			 the MultiplicationListNode element being visited
	 */
	public void visit(MultiplicationListNode node) {
		// TODO fill me in
		Pair<Character, Integer> operatorPair = new Pair<Character, Integer>('*',2);
		OperatorStack.push(operatorPair);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle DivisionListNode
	 * Push (/,2) to the operator stack
	 * 
	 * @param node
	 * 			 the DivisionListNode element being visited
	 */
	public void visit(DivisionListNode node) {
		// TODO fill me in
		Pair<Character, Integer> operatorPair = new Pair<Character, Integer>('/',2);
		OperatorStack.push(operatorPair);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle UnaryMinusListNode
	 * Push (~,1) to the operator stack
	 * 
	 * @param node
	 * 			 the UnaryMinusListNode element being visited
	 */
	public void visit(UnaryMinusListNode node) {
		// TODO fill me in
		Pair<Character, Integer> operatorPair = new Pair<Character, Integer>('~',1);
		OperatorStack.push(operatorPair);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}
}
