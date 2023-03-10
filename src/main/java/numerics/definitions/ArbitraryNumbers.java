package numerics.definitions;

import numerics.logics.NumbersFactory;
import numerics.utils.NumbersUtils;

import java.util.stream.IntStream;

public class ArbitraryNumbers implements NumbersFactory {

    /**
     * Calculate Sum of two Large Integer Numbers
     * @param str1
     * @param str2
     * @return
     */
    public String sum(String str1, String str2) {

        Integer nextDiv = 0;

        String[] string1ToArray = new String[str1.length()];
        IntStream.rangeClosed(0, str1.length() - 1).forEachOrdered(i -> string1ToArray[i] = String.valueOf(str1.charAt(i)));

        String[] string2ToArray = new String[str2.length()];
        IntStream.rangeClosed(0, str2.length() - 1).forEachOrdered(i -> string2ToArray[i] = String.valueOf(str2.charAt(i)));

        NumbersUtils numbersUtils;

        if (string1ToArray.length == string2ToArray.length) {
            numbersUtils = NumbersUtils.getSumResult(string1ToArray, string2ToArray, nextDiv);
        } else {
            int digitsDiff = str1.length() > str2.length() ? str1.length() - str2.length() : str2.length() - str1.length();
            if (str1.length() > str2.length()) {
                String[] s2ArrayTemp = new String[str2.length() + digitsDiff];
                IntStream.rangeClosed(0, s2ArrayTemp.length - 1).forEachOrdered(i -> s2ArrayTemp[i] = "0");

                System.arraycopy(string2ToArray, 0, s2ArrayTemp, digitsDiff, string2ToArray.length - 1 + 1);
                numbersUtils = NumbersUtils.getSumResult(string1ToArray, s2ArrayTemp, nextDiv);
            } else {
                String[] s1ArrayTemp = new String[str1.length() + digitsDiff];
                IntStream.rangeClosed(0, s1ArrayTemp.length - 1).forEachOrdered(i -> s1ArrayTemp[i] = "0");

                System.arraycopy(string1ToArray, 0, s1ArrayTemp, digitsDiff, string1ToArray.length - 1 + 1);
                numbersUtils = NumbersUtils.getSumResult(string2ToArray, s1ArrayTemp, nextDiv);
            }
        }
        return convertArrayToString(numbersUtils);

    }

    /**
     * Calculate Difference of two Large Integer Numbers
     * @param str1
     * @param str2
     * @return
     */
    public String subtraction(String str1, String str2){
        // Take an empty string for storing result
        String str = "";
        boolean minus = false;

        // Before proceeding further, make sure str1 is not smaller
        if (NumbersUtils.isEqual(str1,str2))
            return "0";

        if (NumbersUtils.isSmaller(str1, str2)) {
            String tempStr = str1;
            str1 = str2;
            str2 = tempStr;
            minus = true;
        }

        // Calculate lengths of both string
        int n1 = str1.length(), n2 = str2.length();
        int diff = n1 - n2;

        // Initially take carry zero
        int carry = 0;

        // Traverse from end of both strings
        for (int i = n2 - 1; i >= 0; i--) {
            int sub
                    = (((int)str1.charAt(i + diff) - (int)'0')
                    - ((int)str2.charAt(i) - (int)'0')
                    - carry);
            if (sub < 0) {
                sub = sub + 10;
                carry = 1;
            }
            else
                carry = 0;

            str += String.valueOf(sub);
        }

        // subtract remaining digits of str1[]
        for (int i = n1 - n2 - 1; i >= 0; i--) {
            if (str1.charAt(i) == '0' && carry > 0) {
                str += "9";
                continue;
            }
            int sub = (((int)str1.charAt(i) - (int)'0')
                    - carry);
            if (i > 0 || sub > 0) // remove preceding 0's
                str += String.valueOf(sub);
            carry = 0;
        }

        // reverse resultant string
        String result = new StringBuilder(str).reverse().toString();

        // Remove any leading zeros
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                // Return the result
                if(minus)
                    return "-"+result.substring(i);
                else
                    return result;
            }
        }
        return "";
    }

    @Override
    public String divide(String dividendStr, String divisorStr) throws ArithmeticException {

        int divisor = Integer.parseInt(divisorStr);
        boolean dividendStrIsZero = true;

        if (divisor == 0)
            throw new ArithmeticException("Division By Zero");

        for(int i = 0; i< dividendStr.length(); i++){
            if (dividendStr.charAt(i) != '0'){
                dividendStrIsZero = false;
                break;
            }
        }

        if (dividendStrIsZero)
            return "0";

        StringBuilder result = new StringBuilder();

        char[] dividend = dividendStr.toCharArray();

        int carry = 0;

        for (int i = 0; i < dividend.length; i++) {
            int x = carry * 10 + Character.getNumericValue(dividend[i]);

            result.append(x / divisor);

            carry = x % divisor;
        }

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                return result.substring(i);
            }
        }

        return "";
    }


    /**
     * Calculate Multiply of two Large Integer Numbers
     * @param str1
     * @param str2
     * @return
     */
    public String multiply(String str1, String str2){
        // Reverse both of strings
        String firstReversed = NumbersUtils.getReversed(str1);
        String secondReversed = NumbersUtils.getReversed(str2);

        int[] dimension = new int[str1.length() + str2.length()];

        //multiply each digit and sum at the corresponding positions
        for (int i = 0; i < firstReversed.length(); i++) {
            for (int j = 0; j < secondReversed.length(); j++) {
                dimension[i + j] += (firstReversed.charAt(i) - '0') * (secondReversed.charAt(j) - '0');
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        //calculate each digit
        for (int i = 0; i < dimension.length; i++) {
            int mod = dimension[i] % 10;
            int carry = dimension[i] / 10;
            if (i + 1 < dimension.length) {
                dimension[i + 1] += carry;
            }
            stringBuilder.insert(0, mod);
        }

        //remove front 0's
        while (stringBuilder.charAt(0) == '0' && stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(0);
        }

        return stringBuilder.toString();
    }

    private String convertArrayToString(NumbersUtils arbitraryNumber) {
        String strRet = arbitraryNumber.lastDigit != 0 ? String.valueOf(arbitraryNumber.lastDigit) : "";
        if (!arbitraryNumber.isEmptyResult())
            for (int index : arbitraryNumber.getResult())
                strRet += Integer.toString(index);
        else
            return "0";
        //remove leading zeros and return final value
        return strRet.replaceAll("^0+", "");
    }

}
