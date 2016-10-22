package cs4321.project1;

import static org.junit.Assert.*;
import cs4321.project1.list.*;
import org.junit.Test;

/**
 * @authors Shweta Shrivastava - ss3646 
 * 			Vikas P Nelamangala - vpn6 
 * 			Saarthak Chandra - sc2776
 */

public class PrintListVisitorTest {

	/**
	 * 
	 *Print traversal of the list -  1.0
	 * 
	 */
	@Test
	public void testSingleNumberinANode() {
		ListNode node1 = new NumberListNode(1.0);
		PrintListVisitor plv1 = new PrintListVisitor();
		node1.accept(plv1);
		assertEquals("1.0", plv1.getResult());
	}
	
	/**
	 * 
	 *Print traversal of the list -  + 3.0 2.0
	 * 
	 */
	@Test
	public void testPrefixAdditionExpression() {
		ListNode node1 = new NumberListNode(2.0);
		ListNode node2 = new NumberListNode(3.0);
		ListNode node3 = new AdditionListNode();
		node3.setNext(node2);
		node2.setNext(node1);
		PrintListVisitor plv1 = new PrintListVisitor();
		node3.accept(plv1);
		assertEquals("+ 3.0 2.0", plv1.getResult());
	}
	
	/**
	 * 
	 *Print traversal of the list -  4.0 5.0 +
	 * 
	 */
	@Test
	public void testPostfixAdditionExpression() {
		ListNode node1 = new NumberListNode(4.0);
		ListNode node2 = new NumberListNode(5.0);
		ListNode node3 = new AdditionListNode();
		node1.setNext(node2);
		node2.setNext(node3);
		PrintListVisitor plv1 = new PrintListVisitor();
		node1.accept(plv1);
		assertEquals("4.0 5.0 +", plv1.getResult());
	}
	
	
	/**
	 * 
	 *Print traversal of the list -  - 7.0 6.0
	 * 
	 */
	@Test
	public void testPrefixSubtractionExpression() {
		ListNode node1 = new NumberListNode(6.0);
		ListNode node2 = new NumberListNode(7.0);
		ListNode node3 = new SubtractionListNode();
		node3.setNext(node2);
		node2.setNext(node1);
		PrintListVisitor plv1 = new PrintListVisitor();
		node3.accept(plv1);
		assertEquals("- 7.0 6.0", plv1.getResult());
	}
	
	/**
	 * 
	 *Print traversal of the list -  8.0 9.0 -
	 * 
	 */
	@Test
	public void testPostfixSubtractionExpression() {
		ListNode node1 = new NumberListNode(8.0);
		ListNode node2 = new NumberListNode(9.0);
		ListNode node3 = new SubtractionListNode();
		node1.setNext(node2);
		node2.setNext(node3);
		PrintListVisitor plv1 = new PrintListVisitor();
		node1.accept(plv1);
		assertEquals("8.0 9.0 -", plv1.getResult());
	}
	
	/**
	 * 
	 *Print traversal of the list -  * 11.0 10.0
	 * 
	 */
	@Test
	public void testPrefixMultiplicationExpression() {
		ListNode node1 = new NumberListNode(10.0);
		ListNode node2 = new NumberListNode(11.0);
		ListNode node3 = new MultiplicationListNode();
		node3.setNext(node2);
		node2.setNext(node1);
		PrintListVisitor plv1 = new PrintListVisitor();
		node3.accept(plv1);
		assertEquals("* 11.0 10.0", plv1.getResult());
	}

	/**
	 * 
	 *Print traversal of the list -  12.0 13.0 *
	 * 
	 */
	@Test
	public void testPostfixMultiplicationExpression() {
		ListNode node1 = new NumberListNode(12.0);
		ListNode node2 = new NumberListNode(13.0);
		ListNode node3 = new MultiplicationListNode();
		node1.setNext(node2);
		node2.setNext(node3);
		PrintListVisitor plv1 = new PrintListVisitor();
		node1.accept(plv1);
		assertEquals("12.0 13.0 *", plv1.getResult());
	}
	
	/**
	 * 
	 *Print traversal of the list -  / 15.0 14.0
	 * 
	 */

	@Test
	public void testPrefixDivisionExpression() {
		ListNode node1 = new NumberListNode(14.0);
		ListNode node2 = new NumberListNode(15.0);
		ListNode node3 = new DivisionListNode();
		node3.setNext(node2);
		node2.setNext(node1);
		PrintListVisitor plv1 = new PrintListVisitor();
		node3.accept(plv1);
		assertEquals("/ 15.0 14.0", plv1.getResult());
	}
	
	/**
	 * 
	 *Print traversal of the list -  16.0 17.0 /
	 * 
	 */
	@Test
	public void testPostfixDivisionExpression() {
		ListNode node1 = new NumberListNode(16.0);
		ListNode node2 = new NumberListNode(17.0);
		ListNode node3 = new DivisionListNode();
		node1.setNext(node2);
		node2.setNext(node3);
		PrintListVisitor plv1 = new PrintListVisitor();
		node1.accept(plv1);
		assertEquals("16.0 17.0 /", plv1.getResult());
	}

	/**
	 * New Test
	 * 
	 * Print traversal of the list - ~ 18.0
	 * 
	 */
	@Test
	public void testUnaryMinusExpression() {
		ListNode node1 = new NumberListNode(18.0);
        ListNode node2 = new UnaryMinusListNode();
        node2.setNext(node1);
		PrintListVisitor plv1 = new PrintListVisitor();
		node2.accept(plv1);	
		assertEquals("~ 18.0", plv1.getResult());
	}

	/**
	 * New Test
	 * 
	 * Print traversal of the list - * 19.0 + 20.5 21.0 29.92
	 * 
	 */
	@Test
	public void testPrefixExpression1() {
		double operand1 = 19;
		double operand2 = 20.50;
		double operand3 = 21;
		double operand4 = 29.92;
		
		ListNode num1 = new NumberListNode(operand1);
		ListNode num2 = new NumberListNode(operand2);
		ListNode num3 = new NumberListNode(operand3);
		ListNode num4 = new NumberListNode(operand4);
		
       
        ListNode division = new DivisionListNode();
        ListNode multiplication = new MultiplicationListNode();
        ListNode addition = new AdditionListNode();
        
        division.setNext(multiplication);
        multiplication.setNext(num1);
        num1.setNext(addition);
        addition.setNext(num2);
        num2.setNext(num3);
        num3.setNext(num4);
        
        PrintListVisitor plv1 = new PrintListVisitor();
        division.accept(plv1);
        assertEquals("/ * " + operand1 + " + " +operand2 + " "+operand3 + " " + operand4 ,plv1.getResult()); 

	}
}
