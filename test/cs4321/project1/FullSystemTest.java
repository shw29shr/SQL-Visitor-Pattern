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

public class FullSystemTest {

	private static final double DELTA = 1e-15;

	// Sample test provided
	@Test
	public void testSingleNumber() {
		Parser p1 = new Parser("1.0");
		TreeNode parseResult1 = p1.parse();

		EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		parseResult1.accept(v1);
		double treeEvaluationResult = v1.getResult();

		BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		parseResult1.accept(v2);
		ListNode prefixRepresentation = v2.getResult();
		EvaluatePrefixListVisitor v3 = new EvaluatePrefixListVisitor();
		prefixRepresentation.accept(v3);
		double prefixEvaluationResult = v3.getResult();

		BuildPostfixExpressionTreeVisitor v4 = new BuildPostfixExpressionTreeVisitor();
		parseResult1.accept(v4);
		ListNode postfixRepresentation = v4.getResult();
		EvaluatePostfixListVisitor v5 = new EvaluatePostfixListVisitor();
		postfixRepresentation.accept(v5);
		double postfixEvaluationResult = v5.getResult();

		assertEquals(1.0, treeEvaluationResult, DELTA);
		assertEquals(1.0, prefixEvaluationResult, DELTA);
		assertEquals(1.0, postfixEvaluationResult, DELTA);

	}

	// Sample test provided
	@Test
	public void testAdditionSimple() {
		Parser p1 = new Parser("1.0 + 3.0");
		TreeNode parseResult1 = p1.parse();

		EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		parseResult1.accept(v1);
		double treeEvaluationResult = v1.getResult();

		BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		parseResult1.accept(v2);
		ListNode prefixRepresentation = v2.getResult();
		EvaluatePrefixListVisitor v3 = new EvaluatePrefixListVisitor();
		prefixRepresentation.accept(v3);
		double prefixEvaluationResult = v3.getResult();

		BuildPostfixExpressionTreeVisitor v4 = new BuildPostfixExpressionTreeVisitor();
		parseResult1.accept(v4);
		ListNode postfixRepresentation = v4.getResult();
		EvaluatePostfixListVisitor v5 = new EvaluatePostfixListVisitor();
		postfixRepresentation.accept(v5);
		double postfixEvaluationResult = v5.getResult();
		assertEquals(4.0, treeEvaluationResult, DELTA);
		assertEquals(4.0, prefixEvaluationResult, DELTA);
		assertEquals(4.0, postfixEvaluationResult, DELTA);

	}
	
	/**
	 * New Test 
	 * 
	 * Testing the expression : - 1.0. 
	 * We test EvaluateTreeVisitor.java , prefix and postfix tree visitors as well 
	 * We should get the right evaluation using any of the methods.
	 */
	@Test
	public void testSingleNegativeNumber() {
		Parser p1 = new Parser("- 1.0");
		TreeNode parseResult1 = p1.parse();

		EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		parseResult1.accept(v1);
		double treeEvaluationResult = v1.getResult();

		BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		parseResult1.accept(v2);
		ListNode prefixRepresentation = v2.getResult();
		EvaluatePrefixListVisitor v3 = new EvaluatePrefixListVisitor();
		prefixRepresentation.accept(v3);
		double prefixEvaluationResult = v3.getResult();

		BuildPostfixExpressionTreeVisitor v4 = new BuildPostfixExpressionTreeVisitor();
		parseResult1.accept(v4);
		ListNode postfixRepresentation = v4.getResult();
		EvaluatePostfixListVisitor v5 = new EvaluatePostfixListVisitor();
		postfixRepresentation.accept(v5);
		double postfixEvaluationResult = v5.getResult();

		assertEquals(-1.0, treeEvaluationResult, DELTA);
		assertEquals(-1.0, prefixEvaluationResult, DELTA);
		assertEquals(-1.0, postfixEvaluationResult, DELTA);

	}

	/**
	 * New Test 
	 * 
	 * Testing the expression 4.0 * 2.0 + 3.0 . We test
	 * EvaluateTreeVisitor.java , prefix and postfix tree visitors as well We
	 * should get the right evaluation using any of the methods.
	 */
	@Test
	public void testComplexExpression1() {
		Parser p1 = new Parser("4.0 * 2.0 + 3.0");
		TreeNode parseResult1 = p1.parse();

		EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		parseResult1.accept(v1);
		double treeEvaluationResult = v1.getResult();

		BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		parseResult1.accept(v2);
		ListNode prefixRepresentation = v2.getResult();
		EvaluatePrefixListVisitor v3 = new EvaluatePrefixListVisitor();
		prefixRepresentation.accept(v3);
		double prefixEvaluationResult = v3.getResult();

		BuildPostfixExpressionTreeVisitor v4 = new BuildPostfixExpressionTreeVisitor();
		parseResult1.accept(v4);
		ListNode postfixRepresentation = v4.getResult();
		EvaluatePostfixListVisitor v5 = new EvaluatePostfixListVisitor();
		postfixRepresentation.accept(v5);
		double postfixEvaluationResult = v5.getResult();

		assertEquals(11.0, treeEvaluationResult, DELTA);
		assertEquals(11.0, prefixEvaluationResult, DELTA);
		assertEquals(11.0, postfixEvaluationResult, DELTA);

	}

	/**
	 * New Test Testing the expression 40 / 4.0 * ( 2.0 + 3.0 ) 
	 * 
	 * This expression has a mix of /,*,+ as well as parentheses. 
	 * We test EvaluateTreeVisitor.java , prefix and postfix tree visitors as well. We
	 * should get the right evaluation using any of the methods.
	 */
	@Test
	public void testComplexExpression2() {
		Parser p1 = new Parser("40 / 4.0 * ( 2.0 + 3.0 )");
		TreeNode parseResult1 = p1.parse();

		EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		parseResult1.accept(v1);
		double treeEvaluationResult = v1.getResult();

		BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		parseResult1.accept(v2);
		ListNode prefixRepresentation = v2.getResult();
		EvaluatePrefixListVisitor v3 = new EvaluatePrefixListVisitor();
		prefixRepresentation.accept(v3);
		double prefixEvaluationResult = v3.getResult();

		BuildPostfixExpressionTreeVisitor v4 = new BuildPostfixExpressionTreeVisitor();
		parseResult1.accept(v4);
		ListNode postfixRepresentation = v4.getResult();
		EvaluatePostfixListVisitor v5 = new EvaluatePostfixListVisitor();
		postfixRepresentation.accept(v5);
		double postfixEvaluationResult = v5.getResult();

		assertEquals(50.0, treeEvaluationResult, DELTA);
		assertEquals(50.0, prefixEvaluationResult, DELTA);
		assertEquals(50.0, postfixEvaluationResult, DELTA);

	}

	/**
	 * New Test 
	 * 
	 * Testing the expression ( ( ( ( ( - 14 - - 5 ) / ( 3 * ( 2 + 1 ) ) ) ) ) ) .
	 * This expression has multiple level of braces as well. We test
	 * EvaluateTreeVisitor.java , prefix and postfix tree visitors as well.
	 *  We should get the right evaluation using any of the methods.
	 */
	@Test
	public void testComplexExpression3() {
		Parser p1 = new Parser("( ( ( ( ( - 14 - - 5 ) / ( 3 * ( 2 + 1 ) ) ) ) ) )");
		TreeNode parseResult1 = p1.parse();

		EvaluateTreeVisitor v1 = new EvaluateTreeVisitor();
		parseResult1.accept(v1);
		double treeEvaluationResult = v1.getResult();

		BuildPrefixExpressionTreeVisitor v2 = new BuildPrefixExpressionTreeVisitor();
		parseResult1.accept(v2);
		ListNode prefixRepresentation = v2.getResult();
		EvaluatePrefixListVisitor v3 = new EvaluatePrefixListVisitor();
		prefixRepresentation.accept(v3);
		double prefixEvaluationResult = v3.getResult();

		BuildPostfixExpressionTreeVisitor v4 = new BuildPostfixExpressionTreeVisitor();
		parseResult1.accept(v4);
		ListNode postfixRepresentation = v4.getResult();
		EvaluatePostfixListVisitor v5 = new EvaluatePostfixListVisitor();
		postfixRepresentation.accept(v5);
		double postfixEvaluationResult = v5.getResult();

		assertEquals(-1.0, treeEvaluationResult, DELTA);
		assertEquals(-1.0, prefixEvaluationResult, DELTA);
		assertEquals(-1.0, postfixEvaluationResult, DELTA);

	}
}
