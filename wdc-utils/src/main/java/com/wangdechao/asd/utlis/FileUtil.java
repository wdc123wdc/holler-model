package com.wangdechao.asd.utlis;

import java.io.File;

public class FileUtil {

	
	public static String getExtendName(String name){
	File file=new File("F:\\aaa.txt"); 
	String fileName=file.getName();    
	String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length()); 
	System.out.println(fileTyle);
	return null;
	}
}
