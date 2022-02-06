package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesTest {
	
	@Test
	public void cumulativePercentageAtZeroShouldBeTenPercent() {
		
		Mockery keyedValuesMock = new Mockery();
		final KeyedValues data = keyedValuesMock.mock(KeyedValues.class);
		
		keyedValuesMock.checking(new Expectations() {{
			atLeast(1).of(data).getItemCount();
			will(returnValue((2)));
			
			atLeast(1).of(data).getValue(0);
			will(returnValue(1));
			
			atLeast(1).of(data).getValue(1);
			will(returnValue(9));
			
			atLeast(1).of(data).getKey(0);
			will(returnValue(11));
			
			atLeast(1).of(data).getKey(1);
			will(returnValue(22));
			
		}});
		
		KeyedValues j = DataUtilities.getCumulativePercentages(data);
		assertEquals("The value at index 0 should be 0.1", 0.1, j.getValue(0).doubleValue(), .000000001d);
	}
	
	@Test
	public void cumulativePercentageAtOneShouldBeOneHundredPercent() {
		
		Mockery keyedValuesMock = new Mockery();
		final KeyedValues data = keyedValuesMock.mock(KeyedValues.class);
		
		keyedValuesMock.checking(new Expectations() {{
			atLeast(1).of(data).getItemCount();
			will(returnValue((2)));
			
			atLeast(1).of(data).getValue(0);
			will(returnValue(1));
			
			atLeast(1).of(data).getValue(1);
			will(returnValue(9));
			
			atLeast(1).of(data).getKey(0);
			will(returnValue(11));
			
			atLeast(1).of(data).getKey(1);
			will(returnValue(22));
			
		}});
		
		KeyedValues j = DataUtilities.getCumulativePercentages(data);
		assertEquals("The value at index 1 should be 1.0", 1, j.getValue(1).doubleValue(), .000000001d);
	}
	
	@Test
	public void keyAtZeroShouldBeEleven() {
		
		Mockery keyedValuesMock = new Mockery();
		final KeyedValues data = keyedValuesMock.mock(KeyedValues.class);
		
		keyedValuesMock.checking(new Expectations() {{
			atLeast(1).of(data).getItemCount();
			will(returnValue((2)));
			
			atLeast(1).of(data).getValue(0);
			will(returnValue(1));
			
			atLeast(1).of(data).getValue(1);
			will(returnValue(9));
			
			atLeast(1).of(data).getKey(0);
			will(returnValue(11));
			
			atLeast(1).of(data).getKey(1);
			will(returnValue(22));
			
		}});
		
		KeyedValues j = DataUtilities.getCumulativePercentages(data);
		assertEquals("The key at index 0 should be 11", 11, j.getKey(0));
	}
	
	@Test
	public void keyAtOneShouldBeTwentyTwo() {
		
		Mockery keyedValuesMock = new Mockery();
		final KeyedValues data = keyedValuesMock.mock(KeyedValues.class);
		
		keyedValuesMock.checking(new Expectations() {{
			atLeast(1).of(data).getItemCount();
			will(returnValue((2)));
			
			atLeast(1).of(data).getValue(0);
			will(returnValue(1));
			
			atLeast(1).of(data).getValue(1);
			will(returnValue(9));
			
			atLeast(1).of(data).getKey(0);
			will(returnValue(11));
			
			atLeast(1).of(data).getKey(1);
			will(returnValue(22));
			
		}});
		
		KeyedValues j = DataUtilities.getCumulativePercentages(data);
		assertEquals("The key at index 1 should be 22", 22, j.getKey(1));
	}
	
	@Test
	public void cumulativePercentageAtZeroShouldBeNegTenPercent() {
		
		Mockery keyedValuesMock = new Mockery();
		final KeyedValues data = keyedValuesMock.mock(KeyedValues.class);
		
		keyedValuesMock.checking(new Expectations() {{
			atLeast(1).of(data).getItemCount();
			will(returnValue((2)));
			
			atLeast(1).of(data).getValue(0);
			will(returnValue(-1));
			
			atLeast(1).of(data).getValue(1);
			will(returnValue(11));
			
			atLeast(1).of(data).getKey(0);
			will(returnValue(11));
			
			atLeast(1).of(data).getKey(1);
			will(returnValue(22));
			
		}});
		
		KeyedValues j = DataUtilities.getCumulativePercentages(data);
		assertEquals("The value at index 0 should be -0.1", -0.1, j.getValue(0).doubleValue(), .000000001d);
	}

	@Test(expected = IllegalArgumentException.class)
	public void nullValuesShouldRaiseIllegalArgumentException() {
		final KeyedValues data = null;
		DataUtilities.getCumulativePercentages(data);
	}
}
