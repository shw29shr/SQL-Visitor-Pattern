package cs4321.project1;

import cs4321.project1.tree.DivisionTreeNode;
import cs4321.project1.tree.LeafTreeNode;
import cs4321.project1.tree.MultiplicationTreeNode;
import cs4321.project1.tree.TreeNode;

import cs4321.project1.tree.*;

/**
 * Class for a parser that can parse a string and produce an expression tree. To
 * keep the code simple, this does no input checking whatsoever so it only works
 * on correct input.
 * 
 * An expression is one or more terms separated by + or - signs. A term is one
 * or more factors separated by * or / signs. A factor is an expression in
 * parentheses (), a factor with a unary - before it, or a number.
 * 
 * 
 * @authors Shweta Shrivastava - ss3646 
 * 			Vikas P Nelamangala - vpn6 
 * 			Saarthak Chandra - sc2776
 */
public class Parser {

	private String[] tokens;
	private int currentToken; // pointer to next input token to be processed
	private TreeNode result = null;

	/**
	 * 
	 * A utility method which checks if a string is a number
	 * 
	 * @param operand 
	 * 				the String to test if it's a number or not
	 * 
	 * @return if the operand is a number or not
	 */
	boolean checkIfNumber(String operand) {
		try {
			Double.parseDouble(operand);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	/**
	 * @precondition input represents a valid expression with all tokens
	 *               separated by spaces, e.g. "3.0 - ( 1.0 + 2.0 ) / - 5.0. All
	 *               tokens must be either numbers that parse to Double, or one
	 *               of the symbols +, -, /, *, ( or ), and all parentheses must
	 *               be matched and properly nested.
	 */
	public Parser(String input) {
		this.tokens = input.split("\\s+");
		currentToken = 0;
	}

	/**
	 * Parse the input and build the expression tree
	 * 
	 * @return the (root node of) the resulting tree
	 */
	public TreeNode parse() {
		return expression();
	}

	/**
	 * Parse the remaining input as far as needed to get the next factor
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode factor() {
		String operand = tokens[currentToken];

		// if operand is a number
		if (checkIfNumber(operand)) {
			result = new LeafTreeNode(Double.parseDouble(tokens[currentToken]));
		} else
		// if operand is a unary operator and not a subtraction , like -3.0
		if (operand.equals("-")) {
			currentToken++;
			result = factor();
			return new UnaryMinusTreeNode(result);
		}
		// If its not a unary minus nor an operand , then we treat it as an
		// expression
		else {
			currentToken++;
			result = expression();
		}
		currentToken++;

		return result;
	}

	/**
	 * Parse the remaining input as far as needed to get the next term
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode term() {
		TreeNode result = factor();
		TreeNode result1 = result;

		// Check if the currentToken is valid or not, and if valid, if it is
		// multiplication or division
		while (currentToken < tokens.length && !tokens[currentToken].equalsIgnoreCase("")
				&& (tokens[currentToken].equalsIgnoreCase("*") || tokens[currentToken].equalsIgnoreCase("/"))) {
			if (tokens[currentToken++].equalsIgnoreCase("*")) {
				result = new MultiplicationTreeNode(result1, factor());
				result1 = result;
			} else {
				result = new DivisionTreeNode(result1, factor());
				result1 = result;
			}

		}
		return result;
	}

	/**
	 * Parse the remaining input as far as needed to get the next expression
	 * 
	 * @return the (root node of) the resulting subtree
	 */
	private TreeNode expression() {

		TreeNode result = term();

		// Check if token is within range, not null and whether token is a
		// '+' or '-'
		while (currentToken < tokens.length && !tokens[currentToken].equalsIgnoreCase("")
				&& (tokens[currentToken].equalsIgnoreCase("+") || tokens[currentToken].equalsIgnoreCase("-"))) {
			// Advance the pointer on encountering a '+' or '-'
			if (tokens[currentToken++].equalsIgnoreCase("+")) {
				result = new AdditionTreeNode(result, term());
			} else {
				result = new SubtractionTreeNode(result, term());
			}

		}
		return result;
	}


}
