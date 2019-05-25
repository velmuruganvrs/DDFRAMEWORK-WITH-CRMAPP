package com.ttsl.crmutils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

public class Reportoptimizer {
	
	@Test
	public static void archiveFile() throws Exception
	{
		
		SimpleDateFormat df = new SimpleDateFormat("YYYY:MM:dd HH:MM:S:mm");
		
		String data=df.format(new Date());
		
		System.out.println(data);
		File src = new  File("D:\\WrokOutSelenium Wrokphase\\CRMDDDFRAMEWORK\\Screen_Shoots");
		
		File Dst = new  File("D:\\WrokOutSelenium Wrokphase\\CRMDDDFRAMEWORK\\ArchiveFiles\\old_");
		
		//FileUtils.copyDirectory(src, Dst);
		
		FileUtils.copyDirectory(src, Dst);
		
		FileUtils.cleanDirectory(src);
	}

}
