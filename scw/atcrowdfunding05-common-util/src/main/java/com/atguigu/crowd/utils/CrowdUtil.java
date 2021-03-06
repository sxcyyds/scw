package com.atguigu.crowd.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

public class CrowdUtil {
	public static boolean judgeRequestType(HttpServletRequest request ) {
		//1、获取头部信息
		String header = request.getHeader("Accept");
		String header2 = request.getHeader("X-Requested-With");
		//2、根据头部信息判断是普通请求还是ajax请求
		if(( header!=null && header.contains("application/json")) || (header2!=null &&  header2.contains("XMLHttpRequest"))) {
			return true;
		}
		return false;
		
		
	}
	//MD5密码加密
	public static String md5(String source){
		//1、判断source是否有效
		if(source == null || source.length()==0) {
			//2、抛出异常
			throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
			
		}
		//3、获取MessageDigest对象
		String algorithm = "md5";
		try {
			MessageDigest instance = MessageDigest.getInstance(algorithm);
			// 4、获取铭文字符串对应的字节数组
			byte[] bytes = source.getBytes();
			// 5、执行加密
			byte[] digest = instance.digest(bytes);
			
			// 6、创建BigInteger对象
			int signum=1;
			BigInteger bigInteger = new BigInteger(signum, digest);
			
			// 7、按照16进制将BigInteger转换为字符串
			int radix=16;
			String string = bigInteger.toString(radix).toUpperCase();
			
			return string;
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return source;
		
		
	}

}
