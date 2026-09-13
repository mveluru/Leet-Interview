package leetcode75.medium;

public class ReverseNumberString {

    public static void reverseNumberString(Integer num){
        StringBuilder reversed = new StringBuilder();
        while (num>0){
            reversed.append(num % 10);
            num /= 10;

        }
        System.out.print("\n"+reversed);
    }

    public static void reverseNumber(Integer num){
        int reversed = 0;
        while (num>0){
            reversed = reversed*10 + num % 10;
            num /= 10;
        }
        System.out.print("Reversed Number "+reversed);
    }

   public static void main(String[] args) {
       Integer intNumber = 1234567890;
       reverseNumberString(intNumber);
       System.out.println("\n");
       reverseNumber(intNumber);
   }
}
