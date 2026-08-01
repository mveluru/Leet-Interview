package leetcode75.jee.records;

public class Arecord {

  public static  void main(String[] args){
        record player(String last, String first, int level){}
        var jone = new player("smith","Jonh",43);
        var jone1 = new player("smith","Jonh1",20);
        System.out.println(jone1 +" "+jone);
    }
}
