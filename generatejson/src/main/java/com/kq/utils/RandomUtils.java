package com.kq.utils;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by huang on 2018/4/21.
 * =============================================
 */
public class RandomUtils {

    private static final Random random = new Random();
    private static final HashMap<Integer, Integer> minMap = new HashMap<Integer, Integer>() {
        {
            put(1, 0);
            put(2, 10);
            put(3, 100);
            put(4, 1000);
            put(5, 10000);
            put(6, 100000);
        }
    };
    private static final HashMap<Integer, Integer> maxMap = new HashMap<Integer, Integer>() {
        {
            put(1, 9);
            put(2, 99);
            put(3, 999);
            put(4, 9999);
            put(5, 99999);
            put(6, 999999);
        }
    };

    public static String getRandomValue(int min, int max, int scale) {
        int resultInt = random.nextInt(max) % (max - min + 1) + min;
        return Integer.toString(resultInt) + appendScale(scale);
    }

    private static String appendScale(int scale) {
        if (scale == 0) {
            return "";
        }
        int min = minMap.get(scale);
        int max = maxMap.get(scale);
        int result = random.nextInt(max) % (max - min + 1) + min;
        return "." + Integer.toString(result);
    }

}
