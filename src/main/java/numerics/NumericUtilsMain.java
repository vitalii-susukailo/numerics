package numerics;

import numerics.definitions.ArbitraryNumbers;
import numerics.logics.NumbersFactory;

public class NumericUtilsMain {

    public static void main(String[] args) {
        NumbersFactory arbitraryNumbers = new ArbitraryNumbers();

        String arbitraryNum1 = "500000000000000000000";
        String arbitraryNum2 = "1500000000000000000000";
        String divider = "1000000";

        System.out.println(arbitraryNum1 + " + " + arbitraryNum2 + " = "+arbitraryNumbers.sum(arbitraryNum1,arbitraryNum2));
        System.out.println(arbitraryNum2 + " - " + arbitraryNum1 + " = "+arbitraryNumbers.subtraction(arbitraryNum2,arbitraryNum1));
        System.out.println(arbitraryNum1 + " - " + arbitraryNum2 + " = "+arbitraryNumbers.subtraction(arbitraryNum1,arbitraryNum2));
        System.out.println(arbitraryNum1 + " * " + arbitraryNum2 + " = "+arbitraryNumbers.multiply(arbitraryNum1,arbitraryNum2));
        System.out.println(arbitraryNum1 + " / " + divider + " = "+arbitraryNumbers.divide(arbitraryNum1,divider));
    }
}
