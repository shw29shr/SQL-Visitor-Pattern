package cs4321.project1;

import cs4321.project1.list.*;

/**
 * In this class, we implement the interface ListVisitor, so that we override the method called visit
 * The visit method is implemented, and in each method, we append the node's data to the String result .
 * 
 *  So if a '*' node calls it, we append the '*' sign to the overall result string, and continue appending till we reach the end
 *  The main purpose of this class is to return a result string , which is exposed via getResults() function
 * 
 * @authors 
 * Shweta Shrivastava - ss3646
 * Vikas P Nelamangala - vpn6
 * Saarthak Chandra - sc2776
 */

public class PrintListVisitor implements ListVisitor {

	private String result = "";

	public PrintListVisitor() {
		result = "";
	}

	/**
	 * Method to get the finished string representation when visitor is done
	 * 
	 * @return string representation of the visited List
	 */
	public String getResult() {
		return result;
	}

	/**
	 * Visit method for Number node based on Singly-linked List traversal
	 * @param node
	 * 			  the NumberList node object to visit
	 * 
	 *  @return Add the node data value to the String result, which is exposed by the class via getResult() function
	 */
	@Override
	public void visit(NumberListNode node) {
		
		if (node.getNext() != null) {
			// As soon as you realize there is a node ahead, insert space.
			result += node.getData() + " ";
			node.getNext().accept(this);
		}
		else {
			result += node.getData();
		}
	}

	/**
	 * Visit method for Addition node based on Singly-linked List traversal
	 * @param node
	 * 			  the AdditionListNode node object to visit
	 * 
	 *  @return Add the node data value to the String result, which is exposed by the class via getResult() function
	 */
	@Override
	public void visit(AdditionListNode node) {
		if (node.getNext() != null) {
			result += "+ ";
			node.getNext().accept(this);
		}
		else {
			result += "+";
		}
	}

	/**
	 * Visit method for Subtraction node based on Singly-linked List traversal
	 * @param node
	 * 			  the SubtractionListNode node object to visit
	 * 
	 *  @return Add the node data value to the String result, which is exposed by the class via getResult() function
	 */
	@Override
	public void visit(SubtractionListNode node) {
		if (node.getNext() != null) {
			result += "- ";
			node.getNext().accept(this);
		}
		else {
			result += "-";
		}
	}

	/**
	 * Visit method for Multiplication node based on Singly-linked List traversal
	 * @param node
	 * 			  the MultiplicationListNode node object to visit
	 * 
	 *  @return Add the node data value to the String result, which is exposed by the class via getResult() function
	 */
	@Override
	public void visit(MultiplicationListNode node) {
		if (node.getNext() != null) {
			result += "* ";
			node.getNext().accept(this);
		}
		else {
			result += "*";
		}
	}

	/**
	 * Visit method for Division node based on Singly-linked List traversal
	 * @param node
	 * 			  the DivisionListNode node object to visit
	 * 
	 *  @return Add the node data value to the String result, which is exposed by the class via getResult() function
	 */
	@Override
	public void visit(DivisionListNode node) {
		if (node.getNext() != null) {
			result += "/ ";
			node.getNext().accept(this);
		}
		else {
			result += "/";
		}
	}

	/**
	 * Visit method for Unary Minus node based on Singly-linked List traversal
	 * @param node
	 * 			  the UnaryMinusListNode node object to visit
	 * 
	 *  @return Add the node data value to the String result, which is exposed by the class via getResult() function
	 */
	@Override
	public void visit(UnaryMinusListNode node) {
		if (node.getNext() != null) {
			result += "~ ";
			node.getNext().accept(this);
		}
		else {
			result += "~";
		}
	}

}
