package softserve.edu.com.taqc493;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class REad {

	
		public static void main(String[] args) throws IOException
		{
		 InputStream inStream = new FileInputStream("D:\\122.txt");
		 OutputStream outStream = new FileOutputStream("D:\\111.txt");

		 while (inStream.available() > 0)
		 {
		  int data = inStream.read(); //читаем один байт из потока для чтения
		  outStream.write(data); //записываем прочитанный байт в другой поток.
		 }

		 inStream.close(); //закрываем потоки
		 outStream.close();
		}

	}


