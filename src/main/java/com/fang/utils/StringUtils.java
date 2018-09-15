package com.fang.utils;

public class StringUtils {
    public static boolean isNotBlank(String str){
        if(str.trim().length()>0)return true ;
        else return false ;
    }
}
