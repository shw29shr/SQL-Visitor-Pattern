package cs4321.project1;

import static org.junit.Assert.*;

import org.junit.Test;

import cs4321.project1.list.*;

/**
 * @authors Shweta Shrivastava - ss3646 
 * 			Vikas P Nelamangala - vpn6 
 * 			Saarthak Chandra - sc2776
 */

public class EvaluatePrefixListVisitorTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void testSingleNumberNode() {
		ListNode n1 = new NumberListNode(1.0);
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n1.accept(v1);
		assertEquals(1.0, v1.getResult(), DELTA);
	}

	@Test
	public void testAdditionSimple() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new AdditionListNode();
		n3.setNext(n2);
		n2.setNext(n1);
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n3.accept(v1);
		assertEquals(3.0, v1.getResult(), DELTA);
		
		ListNode n4 = new NumberListNode(1.0);
		ListNode n5 = new NumberListNode(2.0);
		ListNode n6 = new AdditionListNode();
		n6.setNext(n5);
		n5.setNext(n4);
		EvaluatePrefixListVisitor v2 = new EvaluatePrefixListVisitor();
		n6.accept(v2);
		assertEquals(3.0, v2.getResult(), DELTA);
	}
	
	@Test
	public void testAdditionMultipleInstances() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(2.0);
		ListNode n3 = new AdditionListNode();
		ListNode n4 = new NumberListNode(3.0);
		ListNode n5 = new AdditionListNode();
		n5.setNext(n4);
		n4.setNext(n3);
		n3.setNext(n2);
		n2.setNext(n1);
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n5.accept(v1);
		assertEquals(6.0, v1.getResult(), DELTA);
	}

	
	/**
	 * New Simple Test
	 * Testing List: (MultiplicationListNode)->(UnaryMinusListNode)->(NumberListNode:2)->
	 * (AdditionListNode)->(NumberListNode:3)->(NumberListNode:1)
	 * Expected result - -8.0
	 */
	@Test
	public void testMultipleOperationInstances() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(3.0);
		ListNode n3 = new AdditionListNode();
		ListNode n4 = new NumberListNode(2.0);
		ListNode n5 = new UnaryMinusListNode();
		ListNode n6 = new MultiplicationListNode();
		n6.setNext(n5);
		n5.setNext(n4);
		n4.setNext(n3);
		n3.setNext(n2);
		n2.setNext(n1); //expression is * ~ 2 + 3 1 
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n6.accept(v1);
		assertEquals(-8.0, v1.getResult(), DELTA);
	}
	
	@Test
	/**
	 * New Complex Test
	 * Testing List: (MultiplicationListNode)->(AdditionListNode)->(MultiplicationListNode)->
	 * (NumberListNode:3)->(NumberListNode:2)->(NumberListNode:6)->
	 * (DivisionListNode)->(UnaryMinusListNode)->(NumberListNode:5)->
	 * (SubtractionListNode)->(NumberListNode:6)->(NumberListNode:1)
	 * Expected result - -12.0
	 */
	public void testMultipleOperationInstancesComplex() {
		ListNode n1 = new NumberListNode(1.0);
		ListNode n2 = new NumberListNode(6.0);
		ListNode n3 = new SubtractionListNode();
		ListNode n4 = new NumberListNode(5.0);
		ListNode n5 = new UnaryMinusListNode();
		ListNode n6 = new DivisionListNode();
		ListNode n7 = new NumberListNode(6.0);
		ListNode n8 = new NumberListNode(2.0);
		ListNode n9 = new NumberListNode(3.0);
		ListNode n10 = new MultiplicationListNode();
		ListNode n11 = new AdditionListNode();
		ListNode n12 = new MultiplicationListNode();
		n12.setNext(n11);
		n11.setNext(n10);
		n10.setNext(n9);
		n9.setNext(n8);
		n8.setNext(n7);
		n7.setNext(n6);
		n6.setNext(n5);
		n5.setNext(n4);
		n4.setNext(n3);
		n3.setNext(n2);
		n2.setNext(n1); //expression is * + * 3 2 6 / ~ 5 - 6 1
		EvaluatePrefixListVisitor v1 = new EvaluatePrefixListVisitor();
		n12.accept(v1);
		assertEquals(-12.0, v1.getResult(), DELTA);
	}
}
