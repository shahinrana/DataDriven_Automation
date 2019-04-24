package com.test.automation.UIAutomation.ruffwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.test.automation.UIAutomation.utility.ResourceHelper;

public class SiteInformation {

	public static void copyFileUsingApache() throws IOException {
		File source = new File(ResourceHelper.getResourcePath("\\target\\site\\index.html"));
		File dest = new File(ResourceHelper.getResourcePath("\\Output\\site.html"));
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest); // buffer size 1K
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = is.read(buf)) > 0) {
				os.write(buf, 0, bytesRead);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	//System.out.println("source:"+source.toString());System.out.println("dest:"+dest.toString());FileUtils.copyFile(source,dest);

	

	public static void main(String[] args) throws IOException {

		copyFileUsingApache();
	}

}
