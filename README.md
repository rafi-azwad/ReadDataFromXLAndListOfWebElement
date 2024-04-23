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
        System.out.println("Links are: "+link.getAttribute("href"));
    }

  }
    }


    
