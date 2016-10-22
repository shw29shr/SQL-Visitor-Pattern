package cs4321.project1;

import cs4321.project1.list.*;
import cs4321.project1.tree.*;

/**
 * Traverses a tree to create a list representing the expression in prefix form
 * 
 * @authors 
 * Shweta Shrivastava - ss3646
 * Vikas P Nelamangala - vpn6
 * Saarthak Chandra - sc2776
 */
public class BuildPrefixExpressionTreeVisitor implements TreeVisitor {

	private ListNode head;
	private ListNode result;
	
	public BuildPrefixExpressionTreeVisitor() {
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
		//In prefix evaluation, the first node could be either a number or operator
		//Therefore we do not need to place this check everywhere
		if(head == null)
			head = numberNode;
		
		//check if this is the first node to be assigned, if yes set result equal to this
		//In prefix evaluation, the first node could be either a number or operator
		//Therefore we do not need to place this check everywhere
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
	 * Method to handle the UnaryMinusTreeNode
	 * Create a new UnaryMinusListNode and add it to the constructed list
	 * 
	 * @param node 
	 * 			the UnaryMinusTreeNode element being visited
	 */
	public void visit(UnaryMinusTreeNode node) {
				
		//create unary minus node - initialize next pointer to null
		ListNode unaryMinusNode = new UnaryMinusListNode();
		unaryMinusNode.setNext(null);
		
		if(head == null)
			head = unaryMinusNode;
		
		if(result == null)
		{
			result = unaryMinusNode;
		}
		else
		{
			//update result
			result.setNext(unaryMinusNode);
			result = result.getNext();
		}
		
		//redirect to child
		node.getChild().accept(this);
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
		
		//create addition list node - initialize next pointer to null
		ListNode additionNode = new AdditionListNode();
		additionNode.setNext(null);
				
		if(head == null)
			head = additionNode;
		
		if(result == null)
		{
			result = additionNode;
		}
		else
		{
			//update result
			result.setNext(additionNode);
			result = result.getNext();
		}
		
		//redirect to left child
		node.getLeftChild().accept(this);
		
		//redirect to right child
		node.getRightChild().accept(this);
	}

	@Override
	/**
	 * Method to handle the MultiplicationTreeNode
	 * Create a new MultiplicationListNode and add it to the constructed list
	 * 
	 * @param node 
	 * 			the MultiplicationTreeNode element being visited
	 */
	public void visit(MultiplicationTreeNode node) {
		
		//create multiplication list node - initialize next pointer to null
		ListNode multiplicationNode = new MultiplicationListNode();
		multiplicationNode.setNext(null);
						
		if(head == null)
			head = multiplicationNode;
		
		if(result == null)
		{
			result = multiplicationNode;
		}
		else
		{
			//update result
			result.setNext(multiplicationNode);
			result = result.getNext();
		}
		
		//redirect to left child
		node.getLeftChild().accept(this);
				
		//redirect to right child
		node.getRightChild().accept(this);
	}

	@Override
	/**
	 * Method to handle the SubtractionTreeNode
	 * Create a new SubtractionListNode and add it to the constructed list
	 * 
	 * @param node 
	 * 			the SubtractionTreeNode element being visited
	 */
	public void visit(SubtractionTreeNode node) {

		//create subtraction list node - initialize next pointer to null
		ListNode subtractionNode = new SubtractionListNode();
		subtractionNode.setNext(null);
						
		if(head == null)
			head = subtractionNode;
		
		if(result == null)
		{
			result = subtractionNode;
		}
		else
		{
			//update result
			result.setNext(subtractionNode);
			result = result.getNext();
		}
		
		//redirect to left child
		node.getLeftChild().accept(this);
				
		//redirect to right child
		node.getRightChild().accept(this);		
	}

	@Override
	/**
	 * Method to handle the DivisionTreeNode
	 * Create a new DivisionListNode and add it to the constructed list
	 * 
	 * @param node
	 * 			the DivisionTreeNode element being visited
	 */
	public void visit(DivisionTreeNode node) {
						
		//create division list node - initialize next pointer to null
		ListNode divisionNode = new DivisionListNode();
		divisionNode.setNext(null);
						
		if(head == null)
			head = divisionNode;
		
		if(result == null)
		{
			result = divisionNode;
		}
		else
		{
			//update result
			result.setNext(divisionNode);
			result = result.getNext();
		}
		
		//redirect to left child
		node.getLeftChild().accept(this);
				
		//redirect to right child
		node.getRightChild().accept(this);		
	}

}
