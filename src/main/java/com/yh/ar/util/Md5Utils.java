package com.yh.ar.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: Md5Utils
 * @Description: 加密工具类
 * @Author: system
 * @Date: 2024-11-14 15:24
 * @Version: 1.0
 **/
public class Md5Utils {

    private Md5Utils() {
    }

    /**
     * @Author: system
     * @Description: md5加密 ps:32位，小写
     * @Date: 2024-11-14 15:56:11
     * @Param: str
     * @Param: secretKey
     * @return: String
     **/
    public static String encryption(String str, String secretKey) {
        MessageDigest messageDigest = null;
        // 拼接参数密钥
        str = str + secretKey;
        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        //32位，小写
        String md532Lower = md5StrBuff.toString();
        /*//32位，大写
        String md532Upper=md532Lower.toUpperCase();
        //16位，小写
        String md516Lower =md532Lower.substring(8, 24);
        //16位，大写
        String md516Upper=md532Lower.substring(8, 24).toUpperCase();*/
        return md532Lower;
    }

}