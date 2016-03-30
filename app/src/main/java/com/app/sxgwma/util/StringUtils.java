package com.app.sxgwma.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *字符处理类
 */
public class StringUtils {

    public final static String PaymentMethod []={"支付宝","微支付","QQ支付","银行卡支付"};
    private final static Pattern emailer = Pattern
            .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    public static int getSDKVersionNumber() {
        int sdkVersion;
        try {
            sdkVersion = Integer.valueOf(android.os.Build.VERSION.SDK);
        } catch (NumberFormatException e) {
            sdkVersion = 0;
        }
        return sdkVersion;
    }
  //手机号的判断
    public static boolean isMobile(String mobile) {
        if (mobile == null || mobile.trim().equals(""))
            return false;
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobile);
        return m.matches();
    }
    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input) || "null".equals(input))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * null 转String
     *
     * @param str
     * @return
     */
    public static String nullToString(String str) {
        if (str == null || "".equals(str.trim()) || "null".equals(str.trim())) {
            return "";
        }
        return str.trim();
    }

    public static String strToGendar(String str) {
        if (str!=null&&str.equals("1")) {
            return "女";
        }else if(str!=null&&str.equals("0")) {
            return "男";
        }
        return str.trim();
    }
    /**
     * null 转String
     *
     * @param str
     * @return
     */
    public static String nullToWu(String str) {
        if (str == null || "".equals(str.trim()) || "null".equals(str.trim())) {
            return "无";
        }
        return str.trim();
    }


    /**
     * 判断是不是一个合法的电子邮件地址
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        if (email == null || email.trim().length() == 0)
            return false;
        return emailer.matcher(email).matches();
    }

    /**
     * 字符串转整数
     *
     * @param str
     * @param defValue
     * @return
     */
    public static int toInt(String str, int defValue) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
        }
        return defValue;
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static int toInt(Object obj) {
        if (obj == null)
            return 0;
        return toInt(obj.toString(), 0);
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static long toLong(String obj) {
        try {
            return Long.parseLong(obj);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * 字符串转布尔值
     *
     * @param b
     * @return 转换异常返回 false
     */
    public static boolean toBool(String b) {
        try {
            return Boolean.parseBoolean(b);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 字符串转Set<Integer>
     *
     * @param str
     * @param split
     * @return
     */
    public static Set<Integer> splitString(String str, String split) {
        String[] arr = str.split(split);
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (StringUtils.isEmpty(arr[i]))
                set.add(Integer.parseInt(arr[i]));
        }
        return set;
    }

    /**
     * 字符串转ArrayList<String>
     *
     * @param str
     * @param split
     * @return
     */
    public static ArrayList<String> splitStringList(String str, String split) {
        ArrayList<String> list = new ArrayList<String>();
        if (str.trim().equals(""))
            return list;
        String[] arr = str.split(split);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * 字符串转HashSet<String>
     *
     * @param str
     * @param split
     * @return
     */
    public static HashSet<String> splitStringListSet(String str, String split) {
        HashSet<String> list = new HashSet<String>();
        if (str.trim().equals(""))
            return list;
        String[] arr = str.split(split);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    /**
     * Set<Integer>类型集合转成字符串
     *
     * @param set
     * @return
     */
    public static String convertSetToString(Set<Integer> set) {
        StringBuffer str = new StringBuffer();
        if (!set.isEmpty()) {
            int i = 1;
            Iterator<Integer> iterator = (Iterator<Integer>) set.iterator();
            while (iterator.hasNext()) {
                str.append(Integer.toString(iterator.next()));
                if (i < set.size())
                    str.append(",");
                i++;
            }
        }
        return str.toString();
    }

    /**
     * ArrayList<String>转字符串
     *
     * @param arrayList
     * @param split
     * @return
     */
    public static String convertListToString(ArrayList<String> arrayList,
                                             String split) {
        StringBuffer str = new StringBuffer();
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                str.append(arrayList.get(i));
                if (i < arrayList.size() - 1)
                    str.append(split);
            }
        }
        return str.toString();
    }

    /**
     * 指定字符串显示格式如（”这是StringUtil，这里有很多...“）
     *
     * @param str
     * @param limitLength
     * @param suffix
     * @return
     */
    public static String getConvert3gpString(String str, int limitLength,
                                             String suffix) {
        try {
            return getLimitLengthString(str, limitLength, suffix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 指定字符串显示格式的算法
     *
     * @param str
     * @param len
     * @param symbol
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String getLimitLengthString(String str, int len, String symbol) {
        try {
            int counterOfDoubleByte = 0;
            byte b[] = str.getBytes("GBK");
            if (b.length <= len)
                return str;
            for (int i = 0; i < len; i++) {
                if (b[i] < 0)
                    counterOfDoubleByte++;
            }
            if (counterOfDoubleByte % 2 == 0)
                return new String(b, 0, len, "GBK") + symbol;
            else
                return new String(b, 0, len - 1, "GBK") + symbol;
        } catch (Exception exception) {
            return str;
        }
    }

    /**
     * 生成随机指定长度的字符串
     *
     * @param idlen
     * @return
     */
    public static String getIDGenerator(int idlen) {
        String value = Long.toHexString(System.currentTimeMillis());
        String value1 = UUID.randomUUID().toString();
        value1 = value1.replace("-", "");
        value += value1;
        return value.substring(0, idlen);
    }

    public static String convertNumToChineseCase1(String str) {
        StringBuffer result = new StringBuffer();
        int length = str.length();
        char[] chs = new char[] { '零', '一', '二', '三', '四', '五', '六', '七', '八',
                '九' };
        for (int i = 0; i < length; i++) {
            char ch = chs[Integer.parseInt(str.charAt(i) + "")];
            result.append(ch);
        }
        return result.toString();
    }

    public static String convertNumToChineseCase2(String str) {
        StringBuffer result = new StringBuffer();
        int length = str.length();
        boolean bZero = false;
        char[] digits = new char[] { '\u0000', '十', '百', '千', '万', '十', '百',
                '千' };
        char[] chs = new char[] { '零', '一', '二', '三', '四', '五', '六', '七', '八',
                '九' };
        for (int i = 0; i < length; i++) {
            char ch = chs[Integer.parseInt(str.charAt(i) + "")];
            char digit = digits[length - 1 - i];
            // 处理零和连续零的情况
            if (ch == '零') {
                bZero = true;
                if (digit == '万') {
                    result.append('万');
                }
                continue;
            }
            if (bZero) {
                result.append('零');
                bZero = false;
            }
            // 处理一十的情况
            if (digit == '十' && ch == '一') {
                result.append("十");
                continue;
            }
            result.append(ch).append(digit);
        }
        return result.toString();
    }

	/*
	 * 取某个字符串中括号内的部分
	 */

    public static String getStringId(String str) {
        String id = "";
        Pattern pattern1 = Pattern.compile(".*?\\((.*?)\\).*?");
        Matcher matcher1 = pattern1.matcher(str);
        if (matcher1.matches()) {
            id = matcher1.group(1);
        }
        return id;
    }


    /**匹配&或全角状态字符或标点*/
    public static final String PATTERN="&|[\uFE30-\uFFA0]|‘’|“”";

    public static String replaceSpecialtyStr(String str,String pattern,String replace){
        if(isBlankOrNull(pattern))
            pattern="\\s*|\t|\r|\n";//去除字符串中空格、换行、制表
        if(isBlankOrNull(replace))
            replace="";
        return Pattern.compile(pattern).matcher(str).replaceAll(replace);

    }
    public static boolean isBlankOrNull(String str){
        if(null==str)return true;
        //return str.length()==0?true:false;
        return str.length()==0;
    }

    /**清除数字和空格*/
    public static  String cleanBlankOrDigit(String str){
        if(isBlankOrNull(str))return "null";
        return Pattern.compile("\\d|\\s").matcher(str).replaceAll("");
    }

    //is emoji
    private static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA)
                || (codePoint == 0xD)
                || ((codePoint >= 0x20) && (codePoint <= 0xD7FF))
                || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF)));
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param format
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }

    public static String timeStamp2Date(String seconds) {
        if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
            return "";
        }
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }
    /**
     * 日期格式字符串转换成时间戳
     * @param date_str 字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str,String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime()/1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return
     */
    public static String timeStamp(){
        long time = System.currentTimeMillis();
        String t = String.valueOf(time/1000);
        return t;
    }

    //  输出结果：
    //	timeStamp=1417792627
    //	date=2014-12-05 23:17:07
    //	1417792627
    public static void main(String[] args) {
        String timeStamp = timeStamp();
        System.out.println("timeStamp="+timeStamp);

        String date = timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");
        System.out.println("date="+date);

        String timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(timeStamp2);
    }
    /**
     * 大写转化为小写;
     * */
    public static String exChangeUpperCase(String str){
        StringBuffer sb = new StringBuffer();
        if(str!=null){
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(Character.isUpperCase(c)){
                    sb.append(Character.toLowerCase(c));
                }else if(Character.isLowerCase(c)){
                    sb.append(Character.toUpperCase(c));
                }
            }
        }

        return sb.toString();
    }
}
