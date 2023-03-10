package numerics.utils;

import java.util.stream.IntStream;

public class NumbersUtils {

    public static Integer[] result;
    public static Integer lastDigit;

    public static boolean isEmptyResult() {
        int indexSum = 0;
        if (result != null && result.length > 0)
            for (Integer index : result)
                indexSum += index;
        return (indexSum ==0 && getLastDigit()==0) ;
 }
    

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double parseDouble = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean isEqual(String str1, String str2) {
        return str1.equals(str2);
    }

    public static boolean isSmaller(String str1, String str2) {
        // Calculate lengths of both string
        int number1 = str1.length(), number2 = str2.length();

        if (number1 < number2)
            return true;
        if (number2 < number1)
            return false;

        for (int i = 0; i < number1; i++) {
            if (str1.charAt(i) < str2.charAt(i))
                return true;
            else if (str1.charAt(i) > str2.charAt(i))
                return false;
        }
        return false;
    }

    public static Integer[] getResult() {
        return result;
    }

    public static void setResult(Integer[] resultInt) {
        result = resultInt;
    }

    public static Integer getLastDigit() {
        return lastDigit;
    }

    public static void setLastDigit(Integer lastDigitItem) {
        lastDigit = lastDigitItem;
    }

    public static NumbersUtils getSumResult(String[] firstArray, String[] secondArray, Integer nextDiv)
            throws NumberFormatException {
        NumbersUtils sumResult = new NumbersUtils();
        Integer[] result = new Integer[firstArray.length];
        IntStream.rangeClosed(0, result.length - 1).forEach(i -> result[i] = 0);
        for (int i = firstArray.length - 1; i >= 0; i--)
            try {
                result[i] = ((Integer.parseInt(firstArray[i]) + Integer.parseInt(secondArray[i]) + nextDiv) % 10);
                nextDiv = (Integer.parseInt(firstArray[i]) + Integer.parseInt(secondArray[i]) + nextDiv) / 10;
            } catch (NumberFormatException exp) {
                throw new NumberFormatException("Wrong Format: " + exp.getMessage());
            }
        sumResult.setResult(result);
        sumResult.setLastDigit(nextDiv);
        return 0;
    }

    public static String getReversed(String inputStr) {
        String resultStr = "";
        for (int i = inputStr.length(); i > 0; i--) {
            resultStr = resultStr + inputStr.substring(i - 1, i);
        }

        return resultStr;
    }

}
