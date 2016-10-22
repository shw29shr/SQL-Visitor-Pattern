package cs4321.project1;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.tree.*;

/**
 * @authors Shweta Shrivastava - ss3646 
 * 			Vikas P Nelamangala - vpn6 
 * 			Saarthak Chandra - sc2776
 */

public class EvaluateTreeVisitorTest {

	private static final double DELTA = 1e-15;

	@Test
	public void testSingleLeafNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
        EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		n1.accept(v1);
		assertEquals(1.0, v1.getResult(), DELTA);
	}
	
	@Test
	public void testAdditionNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new AdditionTreeNode(n1, n2);
		TreeNode n4 = new AdditionTreeNode(n2, n1);
        EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		n3.accept(v1);
		assertEquals(3.0, v1.getResult(), DELTA);
        EvaluateTreeVisitor v2 = new EvaluateTreeVisitor();
		n4.accept(v2);
		assertEquals(3.0, v2.getResult(), DELTA);
	}
	
	@Test
	public void testMultiplicationNode() {
		TreeNode n1 = new LeafTreeNode(1.0);
		TreeNode n2 = new LeafTreeNode(2.0);
		TreeNode n3 = new MultiplicationTreeNode(n1, n2);
		TreeNode n4 = new MultiplicationTreeNode(n2, n1);
        EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		n3.accept(v1);
		assertEquals(2.0, v1.getResult(), DELTA);
        EvaluateTreeVisitor v2 = new EvaluateTreeVisitor();
		n4.accept(v2);
		assertEquals(2.0, v2.getResult(), DELTA);
	}
	
	@Test
    /**
	 * New Simple Test 
	 * Testing the expression trees below
	 * 				'~'
	 *				 |
	 * 	   '~'   	'~'
	 * 		|    	 |
	 * 	    5   	10
	 * Expected result - (NumberListNode:2)->(UnaryMinusListNode)->(NumberListNode:3)->
	 * (NumberListNode:1)->(AdditionListNode)->(MultiplicationListNode)
	 */
	public void testUnaryMinusNode() {
		TreeNode n1 = new LeafTreeNode(5.0);
		TreeNode n2 = new UnaryMinusTreeNode(n1);
		TreeNode n3 = new LeafTreeNode(10.0);
		TreeNode n4 = new UnaryMinusTreeNode(n3);
		TreeNode n5 = new UnaryMinusTreeNode(n4);
        EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		n2.accept(v1);
		assertEquals(-5.0, v1.getResult(), DELTA);
        EvaluateTreeVisitor v2 = new EvaluateTreeVisitor();
		n4.accept(v2);
		assertEquals(-10.0, v2.getResult(), DELTA);
		EvaluateTreeVisitor v3 = new EvaluateTreeVisitor();
		n5.accept(v3);
		assertEquals(10.0, v3.getResult(), DELTA);
	}

    /**
	 * New Complex Test 
	 * Testing the expression tree below
	 * 				  '/'
	 * 				 /   \
	 * 			   '*'	  2
	 * 			  /   \
	 *			'+'    8
	 *		   /   \	 
	 * 		 '-'	6
	 *		/   \   
	 * 	   '~'   3		
	 * 		|		    
	 * 	    5    		
	 * Expected result - -8.0
	 */
	@Test
	public void testAllNodes() {
		TreeNode n1 = new LeafTreeNode(5.0);
		TreeNode n2 = new UnaryMinusTreeNode(n1);
		TreeNode n3 = new LeafTreeNode(3.0);
		TreeNode n4 = new SubtractionTreeNode(n2,n3);
		TreeNode n5 = new LeafTreeNode(6.0);
		TreeNode n6 = new AdditionTreeNode(n4,n5);
		TreeNode n7 = new LeafTreeNode(8.0);
		TreeNode n8 = new MultiplicationTreeNode(n6,n7);
		TreeNode n9 = new LeafTreeNode(2.0);
		TreeNode n10 = new DivisionTreeNode(n8,n9);
        EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		n10.accept(v1);
		assertEquals(-8.0, v1.getResult(), DELTA);
	}

}
