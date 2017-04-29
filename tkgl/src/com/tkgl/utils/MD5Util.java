package com.tkgl.utils;

import java.security.MessageDigest;
public class MD5Util {
	public static String getMD5(String str){
		StringBuffer sf=new StringBuffer();
		char[] chars={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		byte[] bytes=str.getBytes();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] targ=md.digest(bytes);
			for(byte b:targ){
				sf.append(chars[(b>>4)&0x0F]);
				sf.append(chars[b & 0x0F]);
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
		return sf.toString();
	}
}
