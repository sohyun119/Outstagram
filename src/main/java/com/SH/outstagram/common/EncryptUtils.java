package com.SH.outstagram.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	
	// 암호화 메소드 
	public static String md5(String message) {
		
		String encData = null;
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			
			byte[] bytes = message.getBytes();
			md.update(bytes);
			
			byte[] digest = md.digest();
			
			for(int i=0; i<digest.length; i++) {
				encData += Integer.toHexString(digest[i] & 0xff);
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null; // 정상적으로 만들어지지 못했을때
		}
		
		return encData;
		
		
	}
	
	

}
