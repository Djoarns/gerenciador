package br.com.alura.gerenciador.util;

public class StringUtil {

    public static Boolean isNotNull(String stringToTest) {
        return stringToTest != null && !stringToTest.equals("null");
    }

    public static Boolean isValid(Object stringToTest) {
        if(stringToTest != null){
            return isNotNull(stringToTest.toString()) && !stringToTest.toString().trim().isEmpty();
        }else{
            return false;
        }
    }

    public static Boolean isValid(String stringToTest) {
        return isNotNull(stringToTest) && !stringToTest.trim().isEmpty();
    }

}
