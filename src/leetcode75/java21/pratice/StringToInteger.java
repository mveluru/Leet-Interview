package leetcode75.java21.pratice;

public class StringToInteger {

    public static void main(String[] args) {
        String stringInteger = "-0009999777cbv888888";
        if (Character.isSpaceChar(stringInteger.charAt(0))) {
            stringInteger = stringInteger.trim();
        }


        int sign =1;
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < stringInteger.length(); i++) {
            if(stringInteger.charAt(i) == '-' && i==0){
                sign = -1;
                continue;
            }
            if(stringInteger.charAt(i) == '+' && i==0){
                sign = 1;
                continue;
            }
            if(Character.isDigit(stringInteger.charAt(i)) && i<stringInteger.length()-1){
                stringBuffer.append(stringInteger.charAt(i));
            }else{
                break;
            }
        }
        stringInteger = stringBuffer.toString();
        long longInteger = Long.parseLong(stringInteger);
        stringInteger = String.valueOf(longInteger*sign);
        System.out.println(stringInteger);
    }

}
