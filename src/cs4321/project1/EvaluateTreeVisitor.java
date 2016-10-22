package cs4321.project1;

import cs4321.project1.tree.DivisionTreeNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.SubtractionTreeNode;
import cs4321.project1.tree.AdditionTreeNode;
import cs4321.project1.tree.MultiplicationTreeNode;
import cs4321.project1.tree.UnaryMinusTreeNode;
import java.util.*;

/**
 * We maintain a Stack and perform a post order traversal of the tree
 * for evaluating the given expression to a single number.
 * (Same way as has been described in the project PDF)
 * 
 * @authors 
 * Shweta Shrivastava - ss3646
 * Vikas P Nelamangala - vpn6
 * Saarthak Chandra - sc2776
 */

public class EvaluateTreeVisitor implements TreeVisitor {

	private Stack<Double> EvaluateTreeStack = new Stack<Double>();  
	private Double result;
	
	public EvaluateTreeVisitor() {
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
	 * Method to handle the LeafTreeNode
	 * Push the value into the stack
	 * 
	 * @param node
	 * 			the LeafTreeNode element being visited
	 */
	public void visit(LeafTreeNode node) {
		// TODO fill me in
		EvaluateTreeStack.push(node.getData());
	}

	@Override
	/**
	 * Method to handle the UnaryMinusTreeNode
	 * Pop twice from the stack, negate and push it back
	 * 
	 * @param node
	 * 			the UnaryMinusTreeNode element being visited
	 */
	public void visit(UnaryMinusTreeNode node) {
		// TODO fill me in
		node.getChild().accept(this);
		result = 0 - EvaluateTreeStack.pop();
		EvaluateTreeStack.push(result);
		
	}

	@Override
	/**
	 * Method to handle the AdditionListNode
	 * Pop twice from the stack, add and push it back
	 * 
	 * @param node
	 * 			the AdditionListNode element being visited
	 */
	public void visit(AdditionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		result = EvaluateTreeStack.pop() + EvaluateTreeStack.pop();
		EvaluateTreeStack.push(result);
	}

	@Override
	/**
	 * Method to handle the MultiplicationTreeNode
	 * Pop twice from the stack, multiply and push it back
	 * 
	 * @param node
	 * 			the MultiplicationTreeNode element being visited
	 */
	public void visit(MultiplicationTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		result = EvaluateTreeStack.pop() * EvaluateTreeStack.pop();
		EvaluateTreeStack.push(result);
	}

	@Override
	/**
	 * Method to handle the SubtractionTreeNode
	 * Pop twice from the stack, subtract and push it back
	 * 
	 * @param node
	 * 			the SubtractionTreeNode element being visited
	 */
	public void visit(SubtractionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		Double right = EvaluateTreeStack.pop();
		Double left = EvaluateTreeStack.pop();
		result = left - right;
		EvaluateTreeStack.push(result);
	}

	@Override
	/**
	 * Method to handle the DivisionTreeNode
	 * Pop twice from the stack, divide and push it back
	 * ASSUMPTION - In case of a divide-by-zero situation, 
	 * we reassign the result to zero and proceed with the 
	 * program
	 * (Since the tests will only be against valid inputs, this is actually never encountered)
	 * 
	 * 
	 * @param node
	 * 			the DivisionTreeNode element being visited
	 */
	public void visit(DivisionTreeNode node) {
		// TODO fill me in
		node.getLeftChild().accept(this);
		node.getRightChild().accept(this);
		Double right = EvaluateTreeStack.pop();
		Double left = EvaluateTreeStack.pop();
		
		//If division leads to an invalid operation (divide by zero), we set result back to 0 
		if(right.compareTo(new Double("0.0")) == 0)
			result = new Double("0");
		else
			result = left / right;
		
		EvaluateTreeStack.push(result);
	}
}
