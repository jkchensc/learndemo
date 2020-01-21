package com.j.chen;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckStrIsNum {
	public static void main(String[] args) {     
        double aa = -192322.1212;    
        String a = "-192322.1212";  
        String b = "-192322a1212";     
        String c = "44002301/";  
        String d = "5";    
        /** 判断是否全为数字 */                     
        System.out.println(checkStrIsNum02(Double.toString(aa)));        
        System.out.println(checkStrIsNum02(a));        
        System.out.println(checkStrIsNum02(b));        
        System.out.println(checkStrIsNum02(c));        
        System.out.println(checkStrIsNum02(d)); 
    }
    
    /**
     * 利用Java的character.isDigit方法进行处理
     */
    public static boolean checkStrIsNum01(String str) {    
        for (int i = 0; i < str.length(); i++) {    
            System.out.println(str.charAt(i)); 
            if (!Character.isDigit(str.charAt(i))) { 
                return false;  
            }
        } 
        return true;
   }
   
   private static Pattern NUMBER_PATTERN = Pattern.compile("-?[0-9]+(\\.[0-9]+)?");
    /** 
     * 利用正则表达式来判断字符串是否为数字 
     */
     public static boolean checkStrIsNum02(String str) { 
        String bigStr; 
        try {      
            /** 先将str转成BigDecimal，然后在转成String */
            bigStr = new BigDecimal(str).toString(); 
        } catch (Exception e) { 
            /** 如果转换数字失败，说明该str并非全部为数字 */
            return false; 
        } 
        Matcher isNum = NUMBER_PATTERN.matcher(str); 
        if (!isNum.matches()) {    
            return false; 
        }  
        return true;
    }
    
    /** 
     * 利用BigDecimal判断是否位数字 
     * 如果是数字，创建new Bigdecimal() 时肯定不会报错，但是有个问题，如果有“-”负号的话也会返回false 
     */
     public static boolean checkStrIsNum03(String str) { 
        String bigStr;  
        try {    
            bigStr = new BigDecimal(str).toString(); 
        } catch (Exception e) {   
            return false; 
        } 
        return true;
    }


}
