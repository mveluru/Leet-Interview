package other;

public class TestFinally {

    public static boolean testFinally(){
        try{
            throw new RuntimeException();
        }catch(Exception e){
            System.out.println("Exception caught");
            return false;
        }finally {
            System.out.println("Finally block executed");
            return true;
        }

    }

    public static void main(String[] args) {
        System.out.println(testFinally());
        /*
        Exception caught
        Finally block executed
        true
         */
    }
}
