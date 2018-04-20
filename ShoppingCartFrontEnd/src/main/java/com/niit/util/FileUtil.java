package com.niit.util;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component   //will create singleton instance and the instance name is fileUtil
public class FileUtil {

	
	@Autowired
	static	HttpSession httpSession;
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/*private static final String imageDirectory = "ShoppingCartImages";*/
	//private static String rootPath = System.getProperty("catalina.home");
	private static String rootPath ="C:\\Users\\acer\\workspace\\ShoppingCartFrontEnd\\src\\main\\webapp\\resources\\images";
	public static boolean fileCopyNIO(MultipartFile file, String fileName) {

		File dest = new File (httpSession.getAttribute("imageDirectory") + File.separator  + fileName)	;

		if (!dest.exists()) {
			dest.mkdir();
		}

		try {
			file.transferTo(dest);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

}