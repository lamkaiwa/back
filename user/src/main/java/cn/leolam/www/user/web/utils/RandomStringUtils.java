package cn.leolam.www.user.web.utils;

import java.util.Random;

/**
 * 随机字符串工具
 */
public class RandomStringUtils {
    public static String getRandomString(int length){

        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random random=new Random();

        StringBuffer sb=new StringBuffer();

        for(int i=0;i<length;i++){

            int number=random.nextInt(str.length()-1);    //从62个字符中随机取其中一个

            sb.append(str.charAt(number));  //用取到的数当索引取字符加到length个数的字符串

        }

        return sb.toString();  //返回字符串

    }
}
