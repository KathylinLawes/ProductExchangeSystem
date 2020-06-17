package com.nwpu.img;

/**
 * Copyright (c) 2020,大佬求带飞组
  * 文件名称：IMGControl.java
  * 文件标识：详见校园二手交易系统设计说明书
  * 摘         要：本文件完成的主要功能是实现图片的存储
 * 
  * 当前版本：1.2
  * 作者：杨之正
  * 完成时间：2020.6.11
 * 
  * 取代版本：1.1
  * 原作者：杨之正
  * 完成日期：2020.6.4
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.http.Part;

public class IMGControl {
	public static String getImg(Collection<Part>parts,String servicepath) throws IOException {
		String picturepath="";
		for(Part p:parts) {
			if(p!=null) {
			String filename=String.valueOf(System.currentTimeMillis()); //以提交图片时间作为文件名
			String submitfile=p.getSubmittedFileName();  //文件名
			/*System.out.println(submitfile);*/
			if(submitfile==null) {
				continue;
			}
			String k=submitfile.substring(submitfile.indexOf("."));  //取后缀
			String newfile=servicepath+"\\"+filename+k;
			Outputfile(p,newfile);
			String localpath="F:\\workspace\\NWPUshop\\WebContent\\upload";
			//String localpath="/usr/tomcat/apache-tomcat-7.0.96/webapps/NWPUshop/upload";
			//String localfile=localpath+"/"+filename+k;
			String localfile=localpath+"\\"+filename+k;
			System.out.println(localfile);
			Outputfile(p,localfile);
			picturepath=filename+k;
			}		
		}
		return picturepath;
	}
	/**
	  * 函数介绍：从数据库中取得相应的数据并进行展示
	  * 输入参数：HttpServletRequest request, HttpServletResponse response
	  * 输出参数：无
	  * 返回值：在网页上可以看到相关的信息
	 */
	public static void Outputfile(Part p,String newfile) throws IOException {
		InputStream filecont=p.getInputStream();
		File file=new File(newfile);
		FileOutputStream fos=new FileOutputStream(file);
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		BufferedInputStream bis=new BufferedInputStream(filecont);
		//System.out.println(length);
		byte b[]=new byte[1024];
		int len=0;
		while((len=bis.read(b))!=-1) {
			bos.write(b,0,len);
		}
		bos.flush();
		bos.close();
		fos.close();
		bis.close();
		}
		
	}

