package org.baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void launchBrowser() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void windowMaximize() {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
	}
	
	public static void pageTitle() {
		// TODO Auto-generated method stub
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
	
	}
	
	public static void passText(String txt, WebElement ele) {
		// TODO Auto-generated method stub
		ele.sendKeys(txt);
	}
	
	public static void pageUrl() {
		// TODO Auto-generated method stub
		String pageUrl = driver.getCurrentUrl();
		System.out.println(pageUrl);
	}
	
	public static void closeEntireBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	public static void clickBtn(WebElement ele) {
		// TODO Auto-generated method stub
		ele.click();
	}
	public static void clear(WebElement ele) {
		// TODO Auto-generated method stub
		ele.clear();
	}
	
	public static void screenShot(String imgName) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot)driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+ imgName.png");
		FileUtils.copyFile(screenshotAs, f);
	}
	
	public static Actions a;
	
	public static void movethecursor(WebElement targetWebElement) {
		// TODO Auto-generated method stub
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();
	}
	
	public static void draganddrop(WebElement dragElement , WebElement dropElement) {
		// TODO Auto-generated method stub
		a = new Actions(driver);
		a.dragAndDrop(dragElement, dropElement).perform();
	}
	
	public static JavascriptExecutor js;
	
	public static void scrollpagetrue(WebElement targettrue) {
		// TODO Auto-generated method stub
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", targettrue);
	}
	
	public static void scrollpagefalse(WebElement targetfalse) {
		// TODO Auto-generated method stub
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView", targetfalse);
	}
	
	public static void javaclick(WebElement targetClick) {
		// TODO Auto-generated method stub
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", targetClick);
	}
	
	public static void javasendkeys(String javasend , WebElement sendkeys) {
		// TODO Auto-generated method stub
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value',javasend)", sendkeys);
	}
	
	public static void excelread(String sheetName, int rowNum, int cellNum) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet(sheetName);
		Row r = mySheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		
		String value = " ";
		if (cellType == 1) {
			String stringCellValue = c.getStringCellValue();
			System.out.println(stringCellValue);
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat(value);
			String datefor = sdf.format(dateCellValue);
			System.out.println(datefor);
		}
		else {
			double numericCellValue = c.getNumericCellValue();
			long l = (long) numericCellValue;
			String numvalue = String.valueOf(l);
			System.out.println(numvalue);
		}
	}
	
	public static void createNewExcelFile(int rownum, int cellnum, String WriteData) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Prabakar\\eclipse-workspace\\MavenBaseClass\\Excel\\datawrite.xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet newSheet = wb.createSheet("Data");
		Row newRow = newSheet.createRow(rownum);
		Cell newCell = newRow.createCell(cellnum);
		newCell.setCellValue(WriteData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	
	public static void createCell(int getrow, int crecell, String newData ) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Prabakar\\eclipse-workspace\\MavenBaseClass\\Excel\\datawrite.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("Data");
		Row r = sh.getRow(getrow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	
	public static void createRow(int creRow, int crecell, String newData ) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Prabakar\\eclipse-workspace\\MavenBaseClass\\Excel\\datawrite.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet("Data");
		Row r = sh.createRow(creRow);
		Cell c = r.createCell(crecell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	
	public static void updateDataToParticularCell(int gettheRow, int gettheCell, String existingData, String writeNewData) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Prabakar\\eclipse-workspace\\MavenBaseClass\\Excel\\datawrite.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet excelSheet = wb.getSheet("Data");
		Row r = excelSheet.getRow(gettheRow);
		Cell c = r.getCell(gettheCell);
		String str = c.getStringCellValue();
		if (str.equals(existingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
