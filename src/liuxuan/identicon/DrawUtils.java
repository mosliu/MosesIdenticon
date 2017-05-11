package liuxuan.identicon;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Copyright (c) 2010-2017.  by Liuxuan   All rights reserved. <br/>
 * ***************************************************************************
 * 源文件名:  net.liuxuan.avatar.draw.DrawUtils
 * 功能:
 * 版本:	@version 1.0
 * 编制日期: 2017/5/10 15:28
 * 修改历史: (主要历史变动原因及说明)
 * YYYY-MM-DD |    Author      |	 Change Description
 * 2017/5/10  |    Moses       |     Created
 */
public class DrawUtils {

    /**
     * alias to extractIntValuefrombyteArray
     * @param bs
     * @param start
     * @param length
     * @return
     */
    public static int gotInt(byte[] bs,int start,int length){
        return extractIntValuefrombyteArray(bs,start,length);
    }
    /**
     * 从数组中抽取一部分转化为无符号的int值
     * @param bs
     * @param start
     * @param length
     * @return
     */
    public static int extractIntValuefrombyteArray(byte[] bs,int start,int length){
        int rtn = 0;
        for (int i = start+length-1; i > start-1; i--) {
            rtn= rtn <<8;
            rtn = rtn|(bs[i]&0xff);
        }
        return rtn;
    }

    /**
     * 利用签名辅助类，将字符串字节数组
     *
     * @param str
     * @return
     */
    public static byte[] md5(String str) {
        byte[] digest = null;
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            return digest = md.digest(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static void main(String[] args) {
        byte[] bs= md5("lx0319@gmail.com"); //10 21 152 113 187 10 177 93 14 17 206 223 105 245 61 223
        System.out.println(extractIntValuefrombyteArray(bs,2,5));
    }
}
