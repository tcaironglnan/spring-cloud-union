package com.cloud.docker.tools;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.UUID;

/**
 * 字符串操作工具类
 *
 * @author FaceFeel
 * @Created 2018-03-05 16:34
 **/
public class ToolStr {

    /**
     * 对base64字节数组字符串进行Base64解码并生成图片
     *
     * @param imgStr      base64字节数组字符串
     * @param imgFilePath 图片存储的路径
     * @return 放入数据库的路径
     */
    public static String decodeBase64(String imgStr, String imgFilePath) {
        if (StringUtils.isEmpty(imgStr)) {
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        String[] arr = imgStr.split("base64,");
        //我是把图片放在D盘了
        File filePath = new File(imgFilePath);
        if (!filePath.exists()) {
            filePath.mkdir();
        }
        //因为图表的图片后缀是png，所以后台生成的图片也是它了
        String substring = arr[0].substring(arr[0].indexOf("/") + 1, arr[0].indexOf(";"));
        String picPath = filePath + "/" + UUID.randomUUID().toString() + "." + substring;
        try {
            byte[] buffer = decoder.decodeBuffer(arr[1]);
            OutputStream os = new FileOutputStream(picPath);
            os.write(buffer);
            os.flush();
            os.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return picPath;
    }

    /**
     * 把字节数组转换成字符串
     *
     * @param bytes 字节数组
     * @return 字符串
     */
    public static String byte2Str(byte[] bytes) {

        if (bytes.length == 0) {
            return "";
        }
        return new String(bytes);
    }

    /**
     * 把字符转换成字节数组
     *
     * @param str        需要转换的字符
     * @param encodeType 转换的编码类型
     * @return 字节数组
     */
    public static byte[] str2Byte(String str, String encodeType) {

        if (isBlank(str) || isBlank(encodeType)) {
            return new byte[0];
        }

        try {
            return str.getBytes(encodeType);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    /**
     * 把字符串转换成字节数组
     *
     * @param str 需要转换的字符
     * @return 字节数组
     */
    public static byte[] str2Byte(String str) {

        if (isBlank(str)) {
            return new byte[0];
        }

        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    /**
     * 不为空判断方法
     *
     * @param str 被判断字符串
     * @return 布尔
     */
    public static boolean notBlank(String str) {

        if (str == null || str.length() <= 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (isChinese(c) || Character.isDigit(c) || Character.isLetter(c)) {
                //只要存在数字/英文/中文就返回true
                return true;
            }
        }
        return false;
    }

    /**
     * 为空判断方法
     *
     * @param str 被判断字符串
     * @return 布尔
     */
    public static boolean isBlank(String str) {

        if (str == null || str.length() <= 0) {
            return true;
        }
        for (char c : str.toCharArray()) {
            if (isChinese(c) || Character.isDigit(c) || Character.isLetter(c)) {
                //只要存在数字/英文/中文就返回true
                return false;
            }
        }
        return true;
    }

    /**
     * 中文判断方法
     *
     * @param c 被判断字节码
     * @return 布尔
     */
    private static boolean isChinese(char c) {
        // 根据字节码判断
        return c >= 0x4E00 && c <= 0x9FA5;
    }
}
