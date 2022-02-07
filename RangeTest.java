package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range exampleRange5;
    private Range exampleRange6;
    private Range exampleRange7;
    
//    @BeforeClass public static void setUpBeforeClass() throws Exception {
//    }

    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);	// 0 central value
    	exampleRange2 = new Range(1, 2);	// 1.5 central value
    	exampleRange3 = new Range(-2, -1);	// -1.5 central value
    	exampleRange4 = new Range(-1000000000, 2000000000);	// 500000000 central value
    	exampleRange5 = new Range(Double.NaN, 1);
    	exampleRange6 = new Range(-1, Double.NaN);
    	exampleRange7 = new Range(Double.NaN, Double.NaN);
    }

    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldBeOnePointFive() {
        assertEquals("The central value of 1 and 2 should be 1.5",
        1.5, exampleRange2.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldBeNegOnePointFive() {
        assertEquals("The central value of -2 and -1 should be -1.5",
        -1.5, exampleRange3.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldNotBeAboveZero() {
        assertNotEquals("The central value of -1 and 1 should not be above 0",
        0.000001, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldNotBeBelowZero() {
        assertNotEquals("The central value of -1 and 1 should not be below 0",
        -0.000001, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void centralValueShouldBeFiveHundMil() {
        assertEquals("The central value of -1000000000 and 2000000000 should be 500000000",
        500000000, exampleRange4.getCentralValue(), .000000001d);
    }
    
    @Test
    public void upperBoundShouldBeOne() {
    	assertEquals("The upper bound value of -1 and 1 should be 1",
    	1, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundShouldNotBeAboveOne() {
    	assertNotEquals("The upper bound value of -1 and 1 should not be above 1",
    	1.000001, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void upperBoundShouldNotBeBelowOne() {
    	assertNotEquals("The upper bound value of -1 and 1 should not be below 1",
    	0.999999, exampleRange.getUpperBound(), .000000001d);
    }

    @Test
    public void upperBoundShouldBeTwoBil() {
        assertEquals("The upper bound value of -1000000000 and 2000000000 should be 2000000000",
        2000000000, exampleRange4.getUpperBound(), .000000001d);
    }
    
    @Test
    public void lowerBoundShouldBeNegOne() {
    	assertEquals("The lower bound value of -1 and 1 should be -1",
    	-1, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void lowerBoundShouldNotBeAboveNegOne() {
    	assertNotEquals("The lower bound value of -1 and 1 should be above -1",
    	-0.999999, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void lowerBoundShouldNotBeBelowNegOne() {
    	assertNotEquals("The lower bound value of -1 and 1 should be below -1",
    	-1.000001, exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void lowerBoundShouldBeNegOneBil() {
        assertEquals("The lower bound value of -1000000000 and 2000000000 should be -1000000000",
        -1000000000, exampleRange4.getLowerBound(), .000000001d);
    }
    
    @Test
    public void rangeShouldContainZeroPointNine() {
        assertTrue("The range of -1 and 1 should contain 0.9",
        exampleRange.contains(0.9));
    }
    
    @Test
    public void rangeShouldContainNegZeroPointNine() {
        assertTrue("The range of -1 and 1 should contain -0.9",
        exampleRange.contains(-0.9));
    }
    
    @Test
    public void rangeShouldNotContainValHigherThanOne() {
        assertFalse("The range of -1 and 1 should not contain 1.000001",
        exampleRange.contains(1.000001));
    }
    
    @Test
    public void rangeShouldNotContainValLowerThanNegOne() {
        assertFalse("The range of -1 and 1 should not contain -1.000001",
        exampleRange.contains(-1.000001));
    }
    
    @Test
    public void neitherBoudryIsNaN() {
        assertFalse("The range of -1 and 1 should should not be NaN",
        exampleRange.isNaNRange());
    }
    
    @Test
    public void lowerBoundryIsNotNaNUpperBoudryIsNaN() {
        assertFalse("The range of Double.NaN and 1 should should not be NaN",
        exampleRange5.isNaNRange());
    }
    
    @Test
    public void lowerBoundryIsNaNUpperBoudryIsNotNaN() {
        assertFalse("The range of -1 and Double.NaN should should not be NaN",
        exampleRange6.isNaNRange());
    }
    
    @Test
    public void rangeBoundriesAreNaN() {
        assertTrue("The range of Double.NaN and Double.NaN should should be NaN",
        exampleRange7.isNaNRange());
    }
    
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @AfterClass
//    public static void tearDownAfterClass() throws Exception {
//    }
}