public class BankTest {

    //public static void main(String[] args) throws InterruptedException {
@Test
    public void testingFirefox() throws IOException, InterruptedException {
        ReadDataFromExcel RD1= new ReadDataFromExcel();

        BrowserHelper B1 =new BrowserHelper();
        WebDriver driver =B1.firefox();
        AddCustomerPage a1= new AddCustomerPage(driver);
        a1.AddCustomer(RD1.ReadData(0), RD1.ReadData(1), RD1.ReadData(2));
        a1.AddCustomer(RD1.ReadData(3), RD1.ReadData(4), RD1.ReadData(5));
        a1.AddCustomer(RD1.ReadData(6), RD1.ReadData(7), RD1.ReadData(8));

    List<WebElement> links = driver.findElements(By.tagName("link"));

    System.out.println("Total links are: "+links.size());
    for (WebElement link: links) {
        System.out.println("Links are: "+link.getAttribute("href"));  //how many href in this links
    }

  }
    }

public class ReadDataFromExcel {

    public String ReadData(int k) throws IOException {

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

}
    
