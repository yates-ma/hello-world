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
	
	private static void readAndWrite() throws IOExcetion {
		StringBuffer  str       = null;   
		DataInputStream  bi = null;  
		FileInputStream      fi = null;  
		DataOutputStream bo = null;  
		FileOutputStream     fo = null;  
		File[]   file           = new File[5];  
			      file[0]   = new File("E:\\haha\\1.mp3");  
			      file[1]   = new File("E:\\haha\\2.mp3");  
			      file[2]   = new File("E:\\haha\\3.mp3");  
			      file[3]   = new File("E:\\haha\\4.mp3");  
			      file[4]   = new File("E:\\haha\\5.mp3");  

		try {  
		    byte[] byt = null;  
		    for(int i =0;i<file.length;i++){  
			fi = new FileInputStream(file[i]);  
			bi = new DataInputStream(fi);  
			int next = 0;  
			 byt= new byte[bi.available()];  
			while((next=bi.read())!=-1){  
			    bi.read(byt);  

			}  
			fo = new FileOutputStream("E:\\haha\\123.mp3",true);  
			bo = new DataOutputStream(fo);  
			bo.write(byt);  
		    }  

		} catch (FileNotFoundException e) {  
		    // TODO Auto-generated catch block  
		    e.printStackTrace();  
		} catch (IOException e) {  
		    // TODO Auto-generated catch block  
		    e.printStackTrace();  
		}finally{  
		    try {  

			bi.close();  
			bo.flush();  
			bo.close();  
		    } catch (IOException e) {  
			// TODO Auto-generated catch block  
			e.printStackTrace();  
		    }  


		} 
	}	
}
