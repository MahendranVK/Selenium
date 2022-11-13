package week2.day1;

		import org.openqa.selenium.By;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import io.github.bonigarcia.wdm.WebDriverManager;

		public class Login {

			public static void main(String[] args) throws InterruptedException {
				
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://leaftaps.com/opentaps/control/main");
				driver.manage().window().maximize();
				
				WebElement eleUserName = driver.findElement(By.id("username"));
				eleUserName.sendKeys("DemoSalesManager");
				
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				
				driver.findElement(By.className("decorativeSubmit")).sendKeys(Keys.ENTER);
				
				driver.findElement(By.linkText("CRM/SFA")).click();
				
				driver.findElement(By.linkText("Leads")).click();
				
				driver.findElement(By.linkText("Create Lead")).click();
				
				driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
				
				driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Mahendran");
				
				driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumares");
				
				driver.findElement(By.name("submitButton")).click();
				
				String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
				if(text.equals("Mahendran")) {
					System.out.println("First name is correct");
				} else {
					System.out.println("First name is incorrect");
				}
				
				Thread.sleep(2000);
				driver.close();
				
				WebElement ele = driver.findElement(By.id("viewLead_firstName_sp"));
				ele.clear();
				ele.sendKeys("test");
				ele.sendKeys(Keys.TAB);
			}

		}


