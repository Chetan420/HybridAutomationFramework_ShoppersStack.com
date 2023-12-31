package com.shoppersstacks.qa.util;

import com.shoppersstacks.qa.base.TestBase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 10;
    public static long IMPLICITLY_WAIT = 10;
    public FileInputStream file;
    public String path;
    public Workbook workbook;
    public Sheet sheet;

    public void switchToFrameIndex(int index){
        driver.switchTo().frame(index);
    }
    public void switchToFrameString(String value){
        driver.switchTo().frame(value);
    }
    public void switchToFrameWebElement(String element){
        driver.switchTo().frame(element);
    }


    public TestUtil(String path){
        this.path=path;
    }

    public int getRowCount(String sheetName) throws IOException, InvalidFormatException {
        file=new FileInputStream(path);
        workbook=WorkbookFactory.create(file);
        sheet=workbook.getSheet(sheetName);
        int rowCount=sheet.getLastRowNum();
        return rowCount;
    }

    public int getCellCount(String sheetName,int rowNum) throws IOException, InvalidFormatException {
        file =new FileInputStream(path);
        workbook=WorkbookFactory.create(file);
        sheet=workbook.getSheet(sheetName);
        int cellCount=sheet.getRow(rowNum).getLastCellNum();
        return cellCount;
    }
    public Object[][] getCellDatas(String sheetName) throws IOException, InvalidFormatException {
        file = new FileInputStream(path);
        workbook = WorkbookFactory.create(file);
        sheet = workbook.getSheet(sheetName);
        int lastRow = sheet.getLastRowNum();
        int lastCell = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[lastRow][lastCell];

        for (int i = 0; i < lastRow; i++) {
            for (int j = 0; j < lastCell; j++) {
                data[i][j]=sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }

    public static void takeScreenShot() throws IOException {
        String dateName=new SimpleDateFormat("yyyy.MM.dd.hh:mm.ss").format(new Date());
        TakesScreenshot ts=(TakesScreenshot) driver;
        File temp = ts.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(temp,new File("./errorShots/ShoppersStack"+dateName+".jpg"));
    }
}
