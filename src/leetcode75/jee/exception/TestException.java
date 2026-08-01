package leetcode75.jee.exception;

public class TestException {
    private void throwException(){
        try{
            throw new RuntimeException("SOME THING IS MISSING HEREs");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        TestException testException = new TestException();
        testException.throwException();
    }
}
