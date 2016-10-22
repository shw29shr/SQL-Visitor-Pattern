package cs4321.project1;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.tree.*;
import cs4321.project1.list.*;

/**
 * @authors Shweta Shrivastava - ss3646 
 * 			Vikas P Nelamangala - vpn6 
 * 			Saarthak Chandra - sc2776
 */

public class BuildPrefixExpressionTreeVisitorTest {

	private static final double DELTA = 1e-15;

	@Test
	public void testSingleLeafNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n1.accept(v1);
		ListNode result = v1.getResult();
		assertNull(result.getNext());
		assertTrue(result instanceof NumberListNode);
	}
	
	@Test
	public void testAdditionNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new AdditionTreeNode(n1, n2);
		TreeNode n4 = new AdditionTreeNode(n2, n1);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof AdditionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		
		
        BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		n4.accept(v2);
		result = v2.getResult();
		assertTrue(result instanceof AdditionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
	}
	
	@Test
	public void testUnaryMinusNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new UnaryMinusTreeNode(n1);
		
        BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n2.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof UnaryMinusListNode);
		ListNode first = result.getNext();
		assertTrue(first instanceof NumberListNode);
		assertEquals(((NumberListNode) first).getData(), 1.0, DELTA);
	}
	
	
	/**
	 * New Simple Test 
	 * Testing the expression tree below
	 * 		 '/'
	 * 		/	\
	 * 	   1	 2
	 * Expected result - (DivisionListNode)->(NumberListNode:1)->(NumberListNode:2)
	 */
	@Test
	public void testSimpleDivisionNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new DivisionTreeNode(n1, n2);

		BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n3.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof DivisionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		assertNull(result.getNext());

	}
    
    
    /**
	 * New Complex Test 
	 * Testing the expression tree below
	 * 
	 * 		 '*'
	 *		/   \   
	 * 	   '~'   '+'
	 * 		|    / \
	 * 	    2    3	1
	 * Expected result - (MultiplicationListNode)->(UnaryMinusListNode)->(NumberListNode:2)->(AdditionListNode)->
	 * (NumberListNode:3)->(NumberListNode:1)
	 */
	@Test
	public void testAllNodesComplex() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new LeafTreeNode(3.0);
		TreeNode n4 = new UnaryMinusTreeNode(n2);
		TreeNode n5 = new AdditionTreeNode(n3, n1);
		TreeNode n6 = new MultiplicationTreeNode(n4, n5);

		BuildPrefixExpressionTreeVisitor v1 = new BuildPrefixExpressionTreeVisitor();
		n6.accept(v1);
		ListNode result = v1.getResult();
		assertTrue(result instanceof MultiplicationListNode);
		result = result.getNext();
		assertTrue(result instanceof UnaryMinusListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 2.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof AdditionListNode);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 3.0, DELTA);
		result = result.getNext();
		assertTrue(result instanceof NumberListNode);
		assertEquals(((NumberListNode) result).getData(), 1.0, DELTA);
 		assertNull(result.getNext());
	}

}