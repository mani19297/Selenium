package selenium;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class PrintingSelectedMobiles {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "E:\\files\\Webdriver.driver\\.chromedriver\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.in/");
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("asus zenfonemax m1");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		List<WebElement> grid = driver.findElements(By.cssSelector("div.s-latency-cf-section"));
		for (WebElement mobile : grid) {
			String price = mobile.findElement(By.cssSelector("span.a-price-whole")).getText();
			String mobileName = mobile.findElement(By.cssSelector("span.a-text-normal")).getText();
			String price2=price.replace(",", "");
			int price3=Integer.parseInt(price2);
			if(price3<8000 && mobileName.contains("Asus")) {
				System.out.println("Mobile Name = "+ mobileName);
				System.out.println("Price = "+price+"(INR)");
				System.out.println("******************************************************************************************************"+"\n");
			}
		}		
	}
}
