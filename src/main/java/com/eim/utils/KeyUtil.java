package com.eim.utils;

import java.util.Random;

/**
 * 当前时间戳+6位随机数
 * Created by Administrator on 2018/10/31.
 */
public class KeyUtil {

    public static synchronized String getUniqunceKey(){
        long currentTimeMillis = System.currentTimeMillis();
        Random random = new Random();
        int randomNum = random.nextInt(900000) + 100000;
        return String.valueOf(currentTimeMillis) + randomNum;
    }
}
