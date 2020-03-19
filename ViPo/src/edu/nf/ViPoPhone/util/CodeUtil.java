package edu.nf.ViPoPhone.util;

import java.util.Random;

/**
 *  
 *  @date 2019-07-29
 */
public class CodeUtil {

    private static Random r = new Random();

    /**
     * 随机生成固定长度的验证码
     */
    public static String randomCode(int length) {
        double number = (1 + r.nextDouble()) * Math.pow(10, length);
        String str = String.valueOf(number);
        return str.substring(1, length + 1);
    }
}
