package Core;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


import static java.sql.Types.BOOLEAN;
import static java.sql.Types.NUMERIC;
import static org.codehaus.groovy.syntax.Types.STRING;

public class ReadDataFromExcel {

    public String ReadData(int k) throws IOException {
     //Create an object of File class to open xlsx file
/*        //Create an object of FileInputStream class to read excel file
           File file =    new File("C:\\Users\\USER\\Desktop\\TestData.xlsx");

     //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(file);

        //creating workbook instance that refers to .xls file
        XSSFWorkbook wb=new  XSSFWorkbook(inputStream);

        //creating a Sheet object
        XSSFSheet sheet=wb.getSheetAt(0);

        //get all rows in the sheet
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

        //iterate over all the row to print the data present in each cell.
        for(int i=0;i<=rowCount;i++){

            //get cell count in a row
            int cellcount=sheet.getRow(i).getLastCellNum();

            //iterate over each cell to print its value
            System.out.println("Row"+ i+" data is :");

            for(int j=0;j<cellcount;j++){
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
            }
            System.out.println();
        }
*/

        HashMap<Integer, String>  Values = new HashMap<Integer, String>();
        int p=0;
        String path = System.getProperty("user.dir");
        String xlFile = path + "\\src\\main\\File\\TestData.xlsx";
        File file = new File(xlFile);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);

            int cellCount = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cellCount; j++) {
                XSSFCell cell = row.getCell(j);
                //String cellValues= getCellValue(cell);
                String cellValues= cell.getStringCellValue();
                Values.put(p,cellValues);
                //System.out.println(Values.get(p));
                p++;
            }
            System.out.println();

        }

        fis.close();
        return  Values.get(k);
    }

    /*public String getCellValue(XSSFCell cell) {

       switch (cell.getCellType()) {
           case NUMERIC:
               return String.valueOf(cell.getNumericCellValue());
           case BOOLEAN:
               return String.valueOf(cell.getBooleanCellValue());
           default:
               return cell.getStringCellValue();
       }
    }*/
}
