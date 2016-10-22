package cs4321.project1;

import static org.junit.Assert.*;
import org.junit.Test;
import cs4321.project1.tree.TreeNode;

/**
* @authors Shweta Shrivastava - ss3646 
* 			Vikas P Nelamangala - vpn6 
* 			Saarthak Chandra - sc2776
*/

public class ParserTest {

	/**
	 * This class depends on the correct functioning of PrintTreeVisitor(),
	 * which is provided for you.
	 * 
	 */

	@Test
	public void testSingleNumber() {
		Parser p1 = new Parser("1.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("1.0", v1.getResult());
	}

	@Test
	public void testUnaryMinusSimple() {
		Parser p1 = new Parser("- 1.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("(-1.0)", v1.getResult());
	}

	@Test
	public void testUnaryMinusComplex() {
		Parser p1 = new Parser("- - 1.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("(-(-1.0))", v1.getResult());

	}

	/**
	 * New Test 
	 * 
	 * Test parsing of an expression : 1 - 2
	 */
	@Test
	public void testSimpleExpression1() {
		Parser p1 = new Parser("1.0 - 2.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("(1.0-2.0)", v1.getResult());
	}

	/**
	 * New Test 
	 * 
	 * Test parsing of an expression : 1 - 2 + 3 
	 * Tests subtraction as well as addition in an expression
	 */
	@Test
	public void testSimpleExpression2() {
		Parser p1 = new Parser("1.0 - 2.0 + 3.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("((1.0-2.0)+3.0)", v1.getResult());
	}

	/**
	 * New Test 
	 * 
	 * Test parsing of an expression : 2.0 * 6.0 / 3.0 
	 * Tests multiplication as well as division in an expression
	 */
	@Test
	public void testSimpleExpression3() {
		Parser p1 = new Parser("2.0 * 6.0 / 3.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("((2.0*6.0)/3.0)", v1.getResult());
	}

	/**
	 * New Test 
	 * 
	 * Test parsing of an expression : 1.0 + 6.0 / 3.0 Tests addition as well as division in an expression
	 */
	@Test
	public void testSimpleExpression4() {
		Parser p1 = new Parser("1.0 + 6.0 / 3.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("(1.0+(6.0/3.0))", v1.getResult());
	}

	/**
	 * New Test 
	 * 
	 * Test parsing of an expression : 1.0 + 6.0 * ( 2.0 + 4.0 ) ) / 3.0 
	 * Tests addition,multiplication as well as division in an expression
	 */
	@Test
	public void testSimpleExpression5() {
		Parser p1 = new Parser("( 1.0 + 6.0 * ( 2.0 + 4.0 ) ) / 3.0");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("((1.0+(6.0*(2.0+4.0)))/3.0)", v1.getResult());
	}

	/**
	 * New Test 
	 * 
	 * Test parsing of an expression : ( 3.0 / ( 1.0 + 6.0 * ( 2.0 +
	 * 4.0 ) ) ) 
	 * Tests addition,multiplication as well as division in an
	 * expression as well as leading and trailin braces
	 */
	@Test
	public void testSimpleExpression6() {
		Parser p1 = new Parser("( 3.0 / ( 1.0 + 6.0 * ( 2.0 + 4.0 ) ) )");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("(3.0/(1.0+(6.0*(2.0+4.0))))", v1.getResult());
	}

	/*
	 * New Test Test parsing of an expression : ( 6.0 / ( ( 2.0 + 3.0 ) * ( 4.0
	 * / 2.0 ) ) ) Tests multiple level of round braces in an expression
	 */
	@Test
	public void testSimpleExpression8() {
		Parser p1 = new Parser("( 6.0 / ( ( 2.0 + 3.0 ) * ( 4.0 / 2.0 ) ) )");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("(6.0/((2.0+3.0)*(4.0/2.0)))", v1.getResult());
	}

	/**
	 * New Test 
	 * 
	 * Test parsing of an expression : ( 6.0 + 3.0 / ( ( 2.0 + 3.0 ) * ( 4.0 / 2.0 ) ) ) 
	 * Tests multiple level of round braces in an expression
	 */
	@Test
	public void testSimpleExpression9() {
		Parser p1 = new Parser("( 6.0 + 3.0 / ( ( 2.0 + 3.0 ) * ( 4.0 / 2.0 ) ) )");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("(6.0+(3.0/((2.0+3.0)*(4.0/2.0))))", v1.getResult());
	}

	/**
	 * New Test 
	 * 
	 * Test parsing of an expression : 40 / 4.0 * ( 2.0 + 3.0 )
	 */
	@Test
	public void testSimpleExpression10() {
		Parser p1 = new Parser("40 / 4.0 * ( 2.0 + 3.0 )");
		TreeNode parseResult1 = p1.parse();
		PrintTreeVisitor v1 = new PrintTreeVisitor();
		parseResult1.accept(v1);

		assertEquals("((40.0/4.0)*(2.0+3.0))", v1.getResult());
	}

}
