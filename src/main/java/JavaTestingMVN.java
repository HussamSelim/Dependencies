import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

public class JavaTestingMVN {

	public static void main(String[] args) throws IOException {
//		FileInputStream is = new FileInputStream("E:\\iti\\Java & UML Programming\\titanic.csv");
//		String content= IOUtils.toString(is, StandardCharsets.UTF_8);
//		List<String> lines= IOUtils.readLines(is, StandardCharsets.UTF_8);
//		System.out.println(content);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		List<Passenger> dataSet= new ArrayList<>();
		Path csvFile= Paths.get("E:\\iti\\Java & UML Programming\\titanic.csv");
		BufferedReader reader = Files.newBufferedReader(csvFile, StandardCharsets.UTF_8);
		CSVFormat csv = CSVFormat.RFC4180.withFirstRecordAsHeader();
		CSVParser parser= csv.parse(reader);
		Iterator<CSVRecord> it=parser.iterator();
		it.forEachRemaining(rec->{
			int passengerid=Integer.parseInt(rec.get("PassengerId"));
			int survived=Integer.parseInt(rec.get("Survived"));
			int pclass=Integer.parseInt(rec.get("Pclass"));
			String name= rec.get("Name");
			String sex= rec.get("Sex");
			double age= ParseDouble(rec.get("Age"));
			Passenger p= new Passenger(passengerid,survived,pclass,name,sex,age);
			dataSet.add(p);
			
		});
		dataSet.stream().map(Passenger::getSex).forEach(y->System.out.println(y));
	}
	public static double ParseDouble(String strNumber) {
		   if (strNumber != null && strNumber.length() > 0) {
		       try {
		          return Double.parseDouble(strNumber);
		       } catch(Exception e) {
		          return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
		       }
		   }
		   else return 0;
		}
}
