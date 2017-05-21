package com.niit.shoppingcart.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	
	
	
	
	private static final String ABS_PATH="C:\\Users\\Vaio\\Searches\\Desktop\\New folder\\MainNiitProject-master\\src\\main\\webapp\\resources\\images";
	private static String REAL_PATH="";
	
  //"D:\\ShoppingCart\\Images";
	/*public static void upload(String path,MultipartFile file, String fileName) {
		
		if (!file.isEmpty()) {
			
			
		
			
			try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			File dir = new File(path);
			if (!dir.exists())
				dir.mkdirs(); //Make/create directory
			
			// Create the file on server
			//D:\\ShoppingCart\\Images\\fileName.jpg
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator + fileName);
			
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();

			//log.info("Server File Location="
					//+ serverFile.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}}
		
		

	}*/
	
	
	public static void upload(String path, MultipartFile file, String fileName) {
		
		Util.removeComman(fileName);
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				File dir = new File(path);
				if (!dir.exists()) {
					dir.mkdirs(); // Make/create directory
				}
				// Create the file on server
				// D:\\ShoppingCart\\Images\\fileName.jpg
				File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	

	}


	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		//log.debug("Starting of the method upload");
		REAL_PATH=request.getSession().getServletContext().getRealPath("/resources/images/");
		//log.info("REAL_PATH");
		//log.debug("Current Path :" + Paths.get("").toFile()	);
		
		
		if(!new File(ABS_PATH).exists())
		{
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists())
		{
			new File(REAL_PATH).mkdirs();
		}
		
		try{
			file.transferTo(new File("REAL_PATH" + file + ".jpg"));
			file.transferTo(new File("ABS_PATH" + file + ".jpg"));
		}
		catch(IOException ex){
			
		}
		//log.debug("Ending of the method upload");
	}


	//using nio
	public void fileCopy(String src, String dest)
	{
		
	Path sourcePath=	  Paths.get(src);
	Path destinationPath = Paths.get(dest);
	
	
	try {
		Files.copy(sourcePath, destinationPath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
			
	}

}
