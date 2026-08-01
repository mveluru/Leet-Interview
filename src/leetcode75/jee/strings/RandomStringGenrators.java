package leetcode75.jee.strings;

import java.util.Random;

public class RandomStringGenrators {
    int targetlength;

    public RandomStringGenrators(int targetlength) {
        this.targetlength = targetlength;
    }

    protected String stringgenator() {
        int lowerlimit = 90;
        int upperlimit = 122;
        //StringBuilder sb = new StringBuilder(this.targetlength);
        StringBuffer sb = new StringBuffer(targetlength);
        Random random = new Random();
        for (int i = 0; i < targetlength; i++) {
            int randomNumber=   lowerlimit+ (int) (random.nextFloat()*(upperlimit-lowerlimit+1));
            sb.append((char) randomNumber);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        RandomStringGenrators randomStringGenrator = new RandomStringGenrators(50);
        System.out.println(randomStringGenrator.stringgenator());
    }
}
