package cs4321.project1;

import cs4321.project1.list.DivisionListNode;
import cs4321.project1.list.SubtractionListNode;
import cs4321.project1.list.NumberListNode;

import java.util.Stack;

import cs4321.project1.list.AdditionListNode;
import cs4321.project1.list.MultiplicationListNode;
import cs4321.project1.list.UnaryMinusListNode;

/**
 * Traverses a list representing an expression in postfix form, 
 * and evaluates the expression to a single number using a Stack
 * 
 * 
 * @authors 
 * Shweta Shrivastava - ss3646
 * Vikas P Nelamangala - vpn6
 * Saarthak Chandra - sc2776
 */
public class EvaluatePostfixListVisitor implements ListVisitor {

	private Stack<Double> EvaluateTreeStack = new Stack<Double>();  
	private Double result;
	
	public EvaluatePostfixListVisitor() {
		// TODO fill me in
		result = new Double("0");
	}

	/**
	 * Method to get the final result
	 * 
	 * @return the evaluated result
	 */
	public double getResult() {
		// TODO fill me in
		return EvaluateTreeStack.pop(); // so that skeleton code compiles
	}

	@Override
	/**
	 * Method to handle the NumberListNode
	 * Push the value into the stack
	 * 
	 * @param node
	 * 			the NumberListNode element being visited
	 */
	public void visit(NumberListNode node) {
		// TODO fill me in
		EvaluateTreeStack.push(node.getData());
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle the AdditionListNode
	 * Pop twice from the stack, add and push it back
	 * 
	 * @param node
	 * 			the AdditionListNode element being visited
	 */
	public void visit(AdditionListNode node) {
		// TODO fill me in
		Double right = EvaluateTreeStack.pop();
		Double left = EvaluateTreeStack.pop();
		result = left + right;
		EvaluateTreeStack.push(result);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle the SubtractiomListNode
	 * Pop twice from the stack, subtract and push it back
	 * 
	 * @param node
	 * 			the SubtractionListNode element being visited
	 */
	public void visit(SubtractionListNode node) {
		// TODO fill me in
		Double right = EvaluateTreeStack.pop();
		Double left = EvaluateTreeStack.pop();
		result = left - right;
		EvaluateTreeStack.push(result);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle the MultiplicationListNode
	 * Pop twice from the stack, multiply and push it back
	 * 
	 * @param node
	 * 			the MultiplicationListNode element being visited
	 */
	public void visit(MultiplicationListNode node) {
		// TODO fill me in
		Double right = EvaluateTreeStack.pop();
		Double left = EvaluateTreeStack.pop();
		result = left * right;
		EvaluateTreeStack.push(result);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle the DivisionListNode
	 * Pop twice from the stack, divide and push it back
	 * ASSUMPTION - In case of a divide-by-zero situation, 
	 * we reassign the result to zero and proceed with the 
	 * program
	 * (Since the tests will only be against valid inputs, this is actually never encountered)
	 * 
	 * 
	 * @param node
	 * 			the DivisionListNode element being visited
	 */
	public void visit(DivisionListNode node) {
		// TODO fill me in
		Double right = EvaluateTreeStack.pop();
		Double left = EvaluateTreeStack.pop();
		//If division leads to an invalid operation (divide by zero), we set result back to 0 
		if(right.compareTo(new Double("0.0")) == 0)
			result = new Double("0");
		else
			result = left / right;
		EvaluateTreeStack.push(result);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

	@Override
	/**
	 * Method to handle the UnaryMinusListNode
	 * Pop twice from the stack, negate and push it back
	 * 
	 * @param node
	 * 			the UnaryMinusListNode element being visited
	 */
	public void visit(UnaryMinusListNode node) {
		// TODO fill me in
		result = 0 - EvaluateTreeStack.pop();
		EvaluateTreeStack.push(result);
		if(node.getNext() != null)
			node.getNext().accept(this);
	}

}
