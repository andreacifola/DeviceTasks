package utils;

import java.util.concurrent.ThreadLocalRandom;


public class RandomNumberGenerator {

    public int Generate5Digits() {
        String numberString = "";
        for (int i = 0; i < 5; i++) {
            String s;
            if (i==0){
                s = Integer.toString(generateRandom(1,9));
            }else {
                s = Integer.toString(generateRandom(0,9));
            }

            numberString+=s;
        }
        return Integer.parseInt(numberString);
    }

    public int generateRandom(int start,int end){
        return ThreadLocalRandom.current().nextInt(start, end + 1);
    }
}
