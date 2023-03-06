package numerics.logics;

public interface NumbersFactory {

    /**
     * Calculate Sum of two Large Integer Numbers
     * @param str1
     * @param str2
     * @return
     */
    String sum(String str1, String str2);

    /**
     * Calculate Difference of two Large Integer Numbers
     * @param str1
     * @param str2
     * @return
     */
    String subtraction(String str1, String str2);

    /**
     * Calculate the Division of a Large Integer Number
     * @param dividendStr
     * @param divisorStr
     * @return
     */
    String divide(String dividendStr, String divisorStr) throws ArithmeticException;

    /**
     * Calculate Multiply of two Large Integer Numbers
     * @param str1
     * @param str2
     * @return
     */
    String multiply(String str1, String str2);

}
