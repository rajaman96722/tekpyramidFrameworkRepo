package practiseDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	
		public static void main(String[] args) throws IOException {
			FileInputStream  fis = new FileInputStream("C:\\Users\\AMAN RAJ\\Desktop\\Data\\commondata.properties");
			Properties pObj = new Properties();
			pObj.load(fis);
			

			//pObj.getProperty("browswer");
			System.out.println(pObj.getProperty("url"));

	}

}
