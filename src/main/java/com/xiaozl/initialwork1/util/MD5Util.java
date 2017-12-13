package com.xiaozl.initialwork1.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5签名获得摘要
 * （并不是真正的加密，且不可逆）
 *
 * @author Daydreamer
 * @date 2017/12/12 20:05
 */
public class MD5Util {

    public String EncoderByMd5(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(password.getBytes("utf-8")));

        return newstr;
    }
}
