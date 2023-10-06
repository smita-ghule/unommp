package org.iitworkforce.healthcare.mmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class AppLibrary {

	public static String getfutureDate(int noofDays, String format )
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,noofDays);
		Date d  = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String expected = sdf.format(d);
		return expected;
		//String dateArr[] = expected.split("/");
		//System.out.println(dateArr);
		//System.out.println(dateArr[0]);
		//System.out.println(dateArr[1]);
		//System.out.println(dateArr[2]);
		//return dateArr.toString();
	}
//	public static void main(String[] args) {
	//	System.out.println(AppLibrary.getfutureDate(5,"MM/d/yyyy"));
		
	//}
	
	public static void main(String[] args) throws IOException {
		 String result[][] = readXLSX("config//data.xlsx");
	}
	public static String randomString()
	{
			String str="";
			Random rand=new Random();
			int value = 65+rand.nextInt(26);//uppercase
			char upperCaseCh = (char)value;
			value = 97+rand.nextInt(26);//lowercase
			char lowerCaseCh = (char)value;
			return str +upperCaseCh+lowerCaseCh+"";
	}
	
	
	
	public static String[][] readXLSX(String fileName) throws IOException
	{
		File f = new File(fileName);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("data");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of rows" + rows);
		System.out.println("number of cols" + cols);
		String inputData[][] = new String[rows][cols];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				 XSSFCell cell = sheet.getRow(i).getCell(j);
				 inputData[i][j]= cell.getStringCellValue();
				 System.out.print(inputData[i][j]);
			}
			 System.out.println();
		}
		return inputData;
		
	}
}
