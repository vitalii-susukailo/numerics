import numerics.logics.NumbersFactory;
import numerics.utils.NumbersUtils;
import org.junit.Test;
import numerics.NumericUtilsMain;
import numerics.definitions.ArbitraryNumbers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestNumericUtilsMain {

    public NumericUtilsMain numericUtilsMain = new NumericUtilsMain();
    NumbersFactory arbitraryNumbers = new ArbitraryNumbers();

    @Test
    public void testNumericUtilsConstructor(){
        assertNotEquals(numericUtilsMain,arbitraryNumbers);
    }

    @Test
    public void testUsualNumbersFormat(){
        assertEquals(true,NumbersUtils.isNumeric("100"));
        assertEquals(true,NumbersUtils.isNumeric("999"));
        assertEquals(false,NumbersUtils.isNumeric("ABC"));
    }

    @Test
    public void testArbitraryNumbersFormat(){
        assertEquals(true,NumbersUtils.isNumeric("10000000000"));
        assertEquals(false,NumbersUtils.isNumeric("A10000000000"));
    }

    @Test
    public void testSumOfUsualNumbers(){
        assertEquals("100",arbitraryNumbers.sum("50","50"));
        assertEquals("1000",arbitraryNumbers.sum("637","363"));
        assertEquals("10000",arbitraryNumbers.sum("9999","1"));
        assertEquals("10000",arbitraryNumbers.sum("9999","001"));
    }

    @Test
    public void testSumOfArbitraryNumbers(){
        assertEquals("1000000000000000000000",arbitraryNumbers.sum("500000000000000000000","500000000000000000000"));
        assertEquals("1000000000000000000000",arbitraryNumbers.sum("00500000000000000000000","00500000000000000000000"));
        assertEquals("1000000000000000000000",arbitraryNumbers.sum("999999999999999999999","1"));
        assertEquals("1000000000000000000000",arbitraryNumbers.sum("999999999999999999999","0000000000000000000000001"));
    }

    @Test
    public void testSubtractionOfUsualNumbers(){
        assertEquals("100",arbitraryNumbers.subtraction("150","050"));
        assertEquals("-50",arbitraryNumbers.subtraction("50","100"));
        assertEquals("0",arbitraryNumbers.subtraction("50","50"));
        assertNotEquals("00",arbitraryNumbers.subtraction("50","50"));
        assertEquals("637",arbitraryNumbers.subtraction("1000","363"));
        assertEquals("-637",arbitraryNumbers.subtraction("363","1000"));
    }

    @Test
    public void testSubtractionOfArbitraryNumbers(){
        assertEquals("0",arbitraryNumbers.subtraction("500000000000000000000","500000000000000000000"));
        assertNotEquals("000000000000000000000",arbitraryNumbers.subtraction("500000000000000000000","500000000000000000000"));
        assertEquals("1000000000000000000000",arbitraryNumbers.subtraction("1500000000000000000000","500000000000000000000"));
        assertEquals("-1",arbitraryNumbers.subtraction("999999999999999999999","1000000000000000000000"));
    }

    @Test
    public void testDivideOfUsualNumbers(){
        try {
            assertEquals("1",arbitraryNumbers.divide("50","50"));
            assertEquals("2",arbitraryNumbers.divide("100","50"));
            assertEquals("0",arbitraryNumbers.divide("0","50"));
            assertEquals("0",arbitraryNumbers.divide("00","50"));
            assertEquals("32",arbitraryNumbers.divide("1024","32"));
            assertEquals("20",arbitraryNumbers.divide("1000","50"));
            assertEquals("Division By Zero", arbitraryNumbers.divide("10", "0"));
            assertEquals("Division By Zero", arbitraryNumbers.divide("0", "0"));
            assertEquals("Division By Zero", arbitraryNumbers.divide("000", "0"));
        }
        catch (ArithmeticException exp){
            assertEquals("Division By Zero", exp.getMessage());
        }
    }

    @Test
    public void testDivideOfArbitraryNumbers(){
        try {
            assertEquals("50000000000000000000", arbitraryNumbers.divide("50000000000000000000", "1"));
            assertEquals("25000000000000000000", arbitraryNumbers.divide("50000000000000000000", "2"));
            assertEquals("250000000000000000000", arbitraryNumbers.divide("750000000000000000000", "3"));
            assertEquals("Division By Zero", arbitraryNumbers.divide("75000000000000000000", "0"));
        }
        catch (ArithmeticException exp){
            assertEquals("Division By Zero", exp.getMessage());
        }
    }

    @Test
    public void testMultiplyOfUsualNumbers(){
        assertEquals("2500",arbitraryNumbers.multiply("50","50"));
        assertEquals("50",arbitraryNumbers.multiply("50","1"));
        assertEquals("0",arbitraryNumbers.multiply("50","0"));
        assertEquals("0",arbitraryNumbers.multiply("0","0"));
        assertEquals("231231",arbitraryNumbers.multiply("637","363"));
        assertEquals("231231",arbitraryNumbers.multiply("637","0363"));
        assertEquals("231231",arbitraryNumbers.multiply("0637","363"));
        assertEquals("231231",arbitraryNumbers.multiply("0637","0363"));
    }

    @Test
    public void testMultiplyOfArbitraryNumbers(){
        assertEquals("0",arbitraryNumbers.multiply("50000000000000000000000","0"));
        assertEquals("50000000000000000000000",arbitraryNumbers.multiply("50000000000000000000000","1"));
        assertEquals("10000000000000000000000",arbitraryNumbers.multiply("50000000000","200000000000"));
        assertEquals("670592745",arbitraryNumbers.multiply("12345","54321"));
        assertEquals("12345554321000",arbitraryNumbers.multiply("11111000","1111111"));
    }

    @Test
    public void integrationTest(){
        testNumericUtilsConstructor();
        testUsualNumbersFormat();
        testArbitraryNumbersFormat();
        testSumOfUsualNumbers();
        testSumOfArbitraryNumbers();
        testSubtractionOfUsualNumbers();
        testSubtractionOfArbitraryNumbers();
        testDivideOfUsualNumbers();
        testDivideOfArbitraryNumbers();
        testMultiplyOfUsualNumbers();
        testMultiplyOfArbitraryNumbers();
    }
}
