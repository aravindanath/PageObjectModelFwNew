package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hwpf.model.FileInformationBlock;

public class JavaUtils {

	public static String getVal(String keys) throws IOException {
		String path = "./config.properties";
		FileInputStream fi = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fi);
		String key = prop.getProperty(keys);
		return key;
	}

}
