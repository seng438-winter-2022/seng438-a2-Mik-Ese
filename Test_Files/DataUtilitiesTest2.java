package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

import java.lang.Math;

public class DataUtilitiesTest extends DataUtilities {

	 @Test
	 public void calculateColumnTotalForFiveValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(5));
	             one(values).getValue(0, 0);
	             will(returnValue(20.0));
	             one(values).getValue(1, 0);
	             will(returnValue(20.0));
	             one(values).getValue(2, 0);
	             will(returnValue(20.0));
	             one(values).getValue(3, 0);
	             will(returnValue(20.0));
	             one(values).getValue(4, 0);
	             will(returnValue(20.0));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     // verify
	     assertEquals(result, 100.0, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 @Test
	 public void checkTwoArraysEqual() {
		 double array[][] = new double[2][2];
		 array[0][0] = 1d;
		 array[0][1] = 2d;
		 array[1][0] = 3d;
		 array[1][1] = 4d;
		 double doubleArray[][] = {
				 {1d,2d},
				 {3d,4d}
		 };
		 assertTrue(DataUtilities.equal(array, doubleArray));
	 }
	 @Test
	 public void checkTwoArraysEqualNull() {
		 double array[][] = null;
		 assertTrue(DataUtilities.equal(null, array));
	 }
	 @Test
	 public void checkTwoArraysEqualNaN() {
		 double array[][] = {
				 {Math.log(-1), Math.log(-1)}
		 };
		 double array2[][] = {
				 {Math.sqrt(-1), Math.sqrt(-1)}
		 };
		 assertTrue(DataUtilities.equal(array2, array));
	 }
	 @Test
	 public void checkTwoArraysEqualEmpty() {
		 double array[][] = {	 
		 };
		 double array2[][] = {
		 };
		 assertTrue(DataUtilities.equal(array2, array));
	 }
	 @Test
	 public void checkTwoArraysNotEqual() {
		 double array[][] = {	
				 {1,2,3,4,5}
		 };
		 double array2[][] = {
				 {1,2,3,4},
				 {5}
		 };
		 assertFalse(DataUtilities.equal(array2, array));
	 }
	 @Test
	 public void createNumberArrayTest() {
		 Number array[] = new Number[2];
		 double double1 = 1;
		 double double2 = 2;
		 array[0] = double1;
		 array[1] = double2;
		 double doubleArray[] = {1,2};
		 Number[] resultArray = DataUtilities.createNumberArray(doubleArray);
		 assertArrayEquals(array, resultArray);
	 }
	 @Test
	 public void createNumberArraysNotEqual() {
		 Number array[] = new Number[2];
		 int double1 = 1;
		 double double2 = 2;
		 array[0] = double1;
		 array[1] = double2;
		 double doubleArray[] = {1,2};
		 Number[] resultArray = DataUtilities.createNumberArray(doubleArray);
		 assertNotEquals(array[0], resultArray[0]);
	 }
	 @Test
	 public void createNumberArraysEqualBig() {
		 Number array[] = new Number[2];
		 double double1 = 10000000000000000000d;
		 double double2 = 20000000000000000000d;
		 array[0] = double1;
		 array[1] = double2;
		 double doubleArray[] = {10000000000000000000d,20000000000000000000d};
		 Number[] resultArray = DataUtilities.createNumberArray(doubleArray);
		 assertArrayEquals(array, resultArray);
	 }
	 @Test
	 public void createNumberArraysEqualBigNeg() {
		 Number array[] = new Number[2];
		 double double1 = -10000000;
		 double double2 = 20000000;
		 array[0] = double1;
		 array[1] = double2;
		 double doubleArray[] = {-10000000,20000000};
		 Number[] resultArray = DataUtilities.createNumberArray(doubleArray);
		 assertArrayEquals(array, resultArray);
	 }
	 @Test
	 public void createNumberArraysEqualDecimal() {
		 Number array[] = new Number[2];
		 double double1 = -10000000.0987;
		 double double2 = 20000000.8755;
		 array[0] = double1;
		 array[1] = double2;
		 double doubleArray[] = {-10000000.0987,20000000.8755};
		 Number[] resultArray = DataUtilities.createNumberArray(doubleArray);
		 assertArrayEquals(array, resultArray);
	 }
	 @Test
	 public void createBigNumberArrays() {
		 Number array[] = new Number[20000];
		 for(int i = 0; i<20000; i++) {
			 array[i] = 1.1d;
		 }
		 double doubleArray[] = new double[20000];
		 for(int i = 0; i<20000; i++) {
			 doubleArray[i] = 1.1d;
		 }
		 Number[] resultArray = DataUtilities.createNumberArray(doubleArray);
		 assertArrayEquals(array, resultArray);
	 }
	 @Test(expected = IllegalArgumentException.class)
	 public void createNumberArraysNullException() {
		 double doubleArray[] = null;
		 DataUtilities.createNumberArray(doubleArray);
	 }
	 @Test
	 public void createNumberArrayBiggestDoubleValues() {
		 Number array[] = new Number[3];
		 for(int i = 0; i<3; i++) {
			 array[i] = Double.MAX_VALUE;
		 }
		 double doubleArray[] = new double[3];
		 for(int i = 0; i<3; i++) {
			 doubleArray[i] = Double.MAX_VALUE;
		 }
		 Number[] resultArray = DataUtilities.createNumberArray(doubleArray);
		 assertArrayEquals(array, resultArray);
	 }
	 @Test
	 public void createNumberArrayLowestDoubleValues() {
		 Number array[] = new Number[3];
		 for(int i = 0; i<3; i++) {
			 array[i] = Double.MIN_VALUE;
		 }
		 double doubleArray[] = new double[3];
		 for(int i = 0; i<3; i++) {
			 doubleArray[i] = Double.MIN_VALUE;
		 }
		 Number[] resultArray = DataUtilities.createNumberArray(doubleArray);
		 assertArrayEquals(array, resultArray);
	 }
	 
}
