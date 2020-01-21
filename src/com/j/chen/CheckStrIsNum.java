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
        /** �ж��Ƿ�ȫΪ���� */                     
        System.out.println(checkStrIsNum02(Double.toString(aa)));        
        System.out.println(checkStrIsNum02(a));        
        System.out.println(checkStrIsNum02(b));        
        System.out.println(checkStrIsNum02(c));        
        System.out.println(checkStrIsNum02(d)); 
    }
    
    /**
     * ����Java��character.isDigit�������д���
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
     * ����������ʽ���ж��ַ����Ƿ�Ϊ���� 
     */
     public static boolean checkStrIsNum02(String str) { 
        String bigStr; 
        try {      
            /** �Ƚ�strת��BigDecimal��Ȼ����ת��String */
            bigStr = new BigDecimal(str).toString(); 
        } catch (Exception e) { 
            /** ���ת������ʧ�ܣ�˵����str����ȫ��Ϊ���� */
            return false; 
        } 
        Matcher isNum = NUMBER_PATTERN.matcher(str); 
        if (!isNum.matches()) {    
            return false; 
        }  
        return true;
    }
    
    /** 
     * ����BigDecimal�ж��Ƿ�λ���� 
     * ��������֣�����new Bigdecimal() ʱ�϶����ᱨ�������и����⣬����С�-�����ŵĻ�Ҳ�᷵��false 
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
