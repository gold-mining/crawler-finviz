package com.james.dao;

import java.io.File;

public class FileUtil {
	public static boolean isFileExist(String finalPath) {
		File file = new File(finalPath);
		return file.exists() && file.length() != 0;
	}

	public static void createWirter(String filePath) {
		try {
			new File(filePath).mkdirs();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
