import static org.junit.Assert.*;
import org.junit.*;
import org.jmock.*;
import org.jfree.data.*;

public class MyClass{
    Mockery mockClass=new Mockery();
    final Values2D table=mockClass.mock(Values2D.class);

    // Column test cases
    @Test
    public void calculateColumnTotalNoCols(){
        mockClass.checking(new Expectations(){ {
            one(table).getRowCount();
            will(returnValue(0));
        } });

        assertEquals("calculateColumnTotal should return 0.0", DataUtilities.calculateColumnTotal(table, 0),
                0.0, 0.000000001d);
    }

    @Test
    public void calculateColumnTotalAllPosInt(){
        mockClass.checking(new Expectations(){ {
            one(table).getRowCount();
            will(returnValue(3));

            one(table).getValue(0, 0);
            will(returnValue(1));   // Row 0 column 0 has value 1

            one(table).getValue(1, 0);
            will(returnValue(2));   // Row 1 column 0 has value 2

            one(table).getValue(2, 0);
            will(returnValue(3));   // Row 2 column 0 has value 3
        } });

        assertEquals("calculateColumnTotal should return 6.0", DataUtilities.calculateColumnTotal(table, 0),
                6.0, 0.000000001d);
    }

    @Test
    public void calculateColumnTotalAllNegInt(){
        mockClass.checking(new Expectations(){ {
            one(table).getRowCount();
            will(returnValue(2));

            one(table).getValue(0, 0);
            will(returnValue(-10));   // Row 0 column 0 has value -10

            one(table).getValue(1, 0);
            will(returnValue(-20));   // Row 1 column 0 has value -20
        } });

        assertEquals("calculateColumnTotal should return -30.0", DataUtilities.calculateColumnTotal(table, 0),
                -30.0, 0.000000001d);
    }

    @Test
    public void calculateColumnTotalMixedInt(){
        mockClass.checking(new Expectations(){ {
            one(table).getRowCount();
            will(returnValue(5));

            one(table).getValue(0, 0);
            will(returnValue(-1));   // Row 0 column 0 has value -1

            one(table).getValue(1, 0);
            will(returnValue(-2));   // Row 1 column 0 has value -2

            one(table).getValue(2, 0);
            will(returnValue(3));   // Row 2 column 0 has value 3

            one(table).getValue(3, 0);
            will(returnValue(1));   // Row 3 column 0 has value 1

            one(table).getValue(4, 0);
            will(returnValue(-1));   // Row 4 column 0 has value -1
        } });

        assertEquals("calculateColumnTotal should return 0", DataUtilities.calculateColumnTotal(table, 0),
                0.0, 0.000000001d);
    }

    @Test
    public void calculateColumnTotalAllPosDec(){
        mockClass.checking(new Expectations(){ {
            one(table).getRowCount();
            will(returnValue(4));

            one(table).getValue(0, 0);
            will(returnValue(1.1));   // Row 0 column 0 has value 1.1

            one(table).getValue(1, 0);
            will(returnValue(2.2));   // Row 1 column 0 has value 2.2

            one(table).getValue(2, 0);
            will(returnValue(3.3));   // Row 2 column 0 has value 3.3

            one(table).getValue(3, 0);
            will(returnValue(4.4));   // Row 3 column 0 has value 4.4
        } });

        assertEquals("calculateColumnTotal should return 11.0", DataUtilities.calculateColumnTotal(table, 0),
                11.0, 0.000000001d);
    }

    @Test
    public void calculateColumnTotalAllNegDec(){
        mockClass.checking(new Expectations(){ {
            one(table).getRowCount();
            will(returnValue(3));

            one(table).getValue(0, 0);
            will(returnValue(-1.6));   // Row 0 column 0 has value -1.6

            one(table).getValue(1, 0);
            will(returnValue(-0.5));   // Row 1 column 0 has value -0.5

            one(table).getValue(2, 0);
            will(returnValue(-3.55));   // Row 2 column 0 has value -3.55
        } });

        assertEquals("calculateColumnTotal should return -5.65", DataUtilities.calculateColumnTotal(table, 0),
                -5.65, 0.000000001d);
    }

    @Test
    public void calculateColumnTotalMixedDec(){
        mockClass.checking(new Expectations(){ {
            one(table).getRowCount();
            will(returnValue(4));

            one(table).getValue(0, 0);
            will(returnValue(-0.77));   // Row 0 column 0 has value -1.6

            one(table).getValue(1, 0);
            will(returnValue(2.4));   // Row 1 column 0 has value -0.5

            one(table).getValue(2, 0);
            will(returnValue(8.8));   // Row 2 column 0 has value -3.55

            one(table).getValue(3, 0);
            will(returnValue(-6.4));   // Row 3 column 0 has value -6.4
        } });

        assertEquals("calculateColumnTotal should return 4.03", DataUtilities.calculateColumnTotal(table, 0),
                4.03, 0.000000001d);
    }


    // Row test cases
    @Test
    public void calculateRowTotalNoRows(){
        mockClass.checking(new Expectations(){ {
            one(table).getColumnCount();
            will(returnValue(0));
        } });

        assertEquals("calculateRowTotal should return 0.0", DataUtilities.calculateRowTotal(table, 0),
                0.0, 0.000000001d);
    }

    @Test
    public void calculateRowTotalAllPosInt(){
        mockClass.checking(new Expectations(){ {
            one(table).getColumnCount();
            will(returnValue(2));

            one(table).getValue(0, 0);
            will(returnValue(55));   // Row 0 column 0 has value 55

            one(table).getValue(0, 1);
            will(returnValue(55));   // Row 0 column 1 has value 55
        } });

        assertEquals("calculateRowTotal should return 110", DataUtilities.calculateRowTotal(table, 0),
                110.0, 0.000000001d);
    }

    @Test
    public void calculateRowTotalAllNegInt(){
        mockClass.checking(new Expectations(){ {
            one(table).getColumnCount();
            will(returnValue(3));

            one(table).getValue(0, 0);
            will(returnValue(-3));   // Row 0 column 0 has value -3

            one(table).getValue(0, 1);
            will(returnValue(-6));   // Row 0 column 1 has value -6

            one(table).getValue(0, 2);
            will(returnValue(-9));   // Row 0 column 2 has value -9
        } });

        assertEquals("calculateRowTotal should return -18", DataUtilities.calculateRowTotal(table, 0),
                -18.0, 0.000000001d);
    }

    @Test
    public void calculateRowTotalMixedInt(){
        mockClass.checking(new Expectations(){ {
            one(table).getColumnCount();
            will(returnValue(4));

            one(table).getValue(0, 0);
            will(returnValue(-6));   // Row 0 column 0 has value -6

            one(table).getValue(0, 1);
            will(returnValue(-7));   // Row 0 column 1 has value -7

            one(table).getValue(0, 2);
            will(returnValue(13));   // Row 0 column 2 has value 13

            one(table).getValue(0, 3);
            will(returnValue(2));   // Row 0 column 3 has value 2
        } });

        assertEquals("calculateRowTotal should return 2", DataUtilities.calculateRowTotal(table, 0),
                2.0, 0.000000001d);
    }

    @Test
    public void calculateRowTotalAllPosDec(){
        mockClass.checking(new Expectations(){ {
            one(table).getColumnCount();
            will(returnValue(3));

            one(table).getValue(0, 0);
            will(returnValue(5.5));   // Row 0 column 0 has value 5.5

            one(table).getValue(0, 1);
            will(returnValue(8.8));   // Row 0 column 1 has value 8.8

            one(table).getValue(0, 2);
            will(returnValue(4.3));   // Row 0 column 2 has value 4.3
        } });

        assertEquals("calculateRowTotal should return 18.6", DataUtilities.calculateRowTotal(table, 0),
                18.6, 0.000000001d);
    }

    @Test
    public void calculateRowTotalAllNegDec(){
        mockClass.checking(new Expectations(){ {
            one(table).getColumnCount();
            will(returnValue(4));

            one(table).getValue(0, 0);
            will(returnValue(-0.3));   // Row 0 column 0 has value -0.3

            one(table).getValue(0, 1);
            will(returnValue(-10.6));   // Row 0 column 1 has value -10.6

            one(table).getValue(0, 2);
            will(returnValue(-4.5));   // Row 0 column 2 has value -4.5

            one(table).getValue(0, 3);
            will(returnValue(-0.22));   // Row 0 column 3 has value -0.22
        } });

        assertEquals("calculateRowTotal should return -15.62", DataUtilities.calculateRowTotal(table, 0),
                -15.62, 0.000000001d);
    }

    @Test
    public void calculateRowTotalMixedDec(){
        mockClass.checking(new Expectations(){ {
            one(table).getColumnCount();
            will(returnValue(5));

            one(table).getValue(0, 0);
            will(returnValue(1.5));   // Row 0 column 0 has value 1.5

            one(table).getValue(0, 1);
            will(returnValue(-2.5));   // Row 0 column 1 has value -2.5

            one(table).getValue(0, 2);
            will(returnValue(-3.3));   // Row 0 column 2 has value -3.3

            one(table).getValue(0, 3);
            will(returnValue(0.44));   // Row 0 column 3 has value 0.44

            one(table).getValue(0, 4);
            will(returnValue(-10.7));   // Row 0 column 4 has value -10.7
        } });

        assertEquals("calculateRowTotal should return -14.56", DataUtilities.calculateRowTotal(table, 0),
                -14.56, 0.000000001d);
    }
}
