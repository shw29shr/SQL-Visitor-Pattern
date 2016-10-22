package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Traverses a tree to create a list representing the expression in postfix form
 * 
 * @authors 
 * Shweta Shrivastava - ss3646
 * Vikas P Nelamangala - vpn6
 * Saarthak Chandra - sc2776
 */
public class BuildPostfixExpressionTreeVisitor implements TreeVisitor {

	private ListNode head;
	private ListNode result; 
	
	public BuildPostfixExpressionTreeVisitor() {
		head = null;
		result = null;
		
	}
	
	/**
	 * Method to get the head node of the constructed list
	 * 
	 * @return pointer to the first element in the list
	 */
	public ListNode getResult() {
		return head;
	}

	@Override
	/**
	 * Method to handle the LeafTreeNode
	 * Also used to assign head and result with their initial values
	 * Create a new NumberListNode and add it to the constructed list
	 * 
	 * @param node
	 * 			the LeafTreeNode element being visited
	 */
	public void visit(LeafTreeNode node) {
		
		//create the new number node - initialize data and next pointer
		NumberListNode numberNode = new NumberListNode(node.getData());
		numberNode.setNext(null);
		
		//check if this is the first node to be assigned, if yes set head equal to this
		//In postfix evaluation, a number node will always be the first node to be assigned
		//Therefore we do not need to place this check anywhere else
		if(head == null)
			head = numberNode;
		
		//check if this is the first node to be assigned, if yes set result equal to this
		//In postfix evaluation, a number node will always be the first node to be assigned
		//Therefore we do not need to place this check anywhere else
		if(result == null)
		{
			result = numberNode;
		}
		else
		{
			//update result
			result.setNext(numberNode);
			result = result.getNext();
		}
		
	}

	@Override
	/**
	 * Method to handle UnaryMinusTreeNode
	 * Create a new UnaryMinusListNode and add it to the constructed list
	 * 
	 * @param node 
	 * 				the UnaryMinusTreeNode element being visited
	 * @return none
	 */
	public void visit(UnaryMinusTreeNode node) {

		//redirect to child
		node.getChild().accept(this);
		
		//create unary minus node - initialize next pointer to null
		ListNode unaryMinusNode = new UnaryMinusListNode();
		unaryMinusNode.setNext(null);
		
		//update result
		result.setNext(unaryMinusNode);
		result = result.getNext();
	}

	@Override
	/**
	 * Method to handle the AdditionTreeNode
	 * Create a new AdditionListNode and add it to the constructed list
	 * 
	 * @param node 
	 * 				the AdditionTreeNode element being visited
	 */
	public void visit(AdditionTreeNode node) {

		//redirect to left child
		node.getLeftChild().accept(this);
		
		//redirect to right child
		node.getRightChild().accept(this);
				
		//create addition list node - initialize next pointer to null
		ListNode additionNode = new AdditionListNode();
		additionNode.setNext(null);
				
		//update result
		result.setNext(additionNode);
		result = result.getNext();
	}

	@Override
	/**
	 * Method to handle MultiplicationTreeNode
	 * Create a new MultiplicationListNode and add it to the constructed list
	 * 
	 * @param node 
	 * 				the MultiplicationTreeNode element being visited
	 */
	public void visit(MultiplicationTreeNode node) {
		
		//redirect to left child
		node.getLeftChild().accept(this);
				
		//redirect to right child
		node.getRightChild().accept(this);
						
		//create addition list node - initialize next pointer to null
		ListNode multiplicationNode = new MultiplicationListNode();
		multiplicationNode.setNext(null);
						
		//update result
		result.setNext(multiplicationNode);
		result = result.getNext();
	}

	@Override
	/**
	 * Method to handle SubtractionTreeNode
	 * Create a new SubtractionListNode and add it to the constructed list
	 * 
	 * @param node 
	 * 				the SubtractionTreeNode element being visited
	 */
	public void visit(SubtractionTreeNode node) {
		
		//redirect to left child
		node.getLeftChild().accept(this);
				
		//redirect to right child
		node.getRightChild().accept(this);
						
		//create addition list node - initialize next pointer to null
		ListNode subtractionNode = new SubtractionListNode();
		subtractionNode.setNext(null);
						
		//update result
		result.setNext(subtractionNode);
		result = result.getNext();
	}

	@Override
	/**
	 * Method to handle DivisionTreeNode
	 * Create a new DivisionListNode and add it to the constructed list
	 * 
	 * @param node
	 * 			   the DivisionTreeNode element being visited
	 */
	public void visit(DivisionTreeNode node) {

		//redirect to left child
		node.getLeftChild().accept(this);
				
		//redirect to right child
		node.getRightChild().accept(this);
						
		//create addition list node - initialize next pointer to null
		ListNode divisionNode = new DivisionListNode();
		divisionNode.setNext(null);
						
		//update result
		result.setNext(divisionNode);
		result = result.getNext();		
		
	}

}
