package cn.yates.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IoTest {

	public static void main(String[] args) {
		String dir = "E:\\yates\\about_spring_springMVC"+"\\a.txt";
		File a = createFile(dir);
		try {
			//writeWord2File(a);
			//readWordFromFile(a);
			//readWordOneByOne(a);
			fileWriterMethod(a);
			fileReaderMethod(a); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static File createFile(String dir) {
		File f = new File(dir);
		return f;
	}
	
	private static void writeWord2File(File file) throws IOException {
		OutputStream out = new FileOutputStream(file,true);
		String str = "\r\nthis is the first file of write ttt";
		byte[] bytes = str.getBytes();
		out.write(bytes);
		out.close();
	}
	
	private static void readWordFromFile(File file) throws IOException {
		InputStream in = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		int len = in.read(bytes);
		
		in.close();
		String getStr = new String(bytes, 0, len);
		System.out.println(getStr);
	}
	
	private static void readWordOneByOne(File file) throws IOException {
		InputStream in = new FileInputStream(file);
		byte[] bytes = new byte[1024];
		int len = 0, flag = 0;
		while((flag = in.read())!=-1) {
			bytes[len] = (byte) flag;
			len++;
		}
		in.close();
		String getStr = new String(bytes, 0, len);
		System.out.println(getStr);
	}
	
	private static void fileWriterMethod(File file) throws IOException {
		Writer out = new FileWriter(file, true);
		String str = "\r\nthis this the words wrote by FileWriter";
		out.write(str);
		out.close();
	}
	
	private static void fileReaderMethod(File file) throws IOException {
		Reader in = new FileReader(file);
		byte[] bytes = new byte[(int) file.length()];
		int temp = 0, len = 0;
		while((temp = in.read())!=-1) {
			bytes[len] = (byte) temp;
			len++;
		}
		in.close();
		String getStr = new String(bytes, 0, len);
		System.out.println(getStr);
	}
}
