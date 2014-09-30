import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LadyTest1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ladypopular.bg");
		driver.manage().window().maximize();
		WebElement usernamef = driver.findElement(By.xpath(".//*[@id='loginForm3']/input[1]"));
		usernamef.clear();
		usernamef.sendKeys("Magdalena2305");
		WebElement passwordf = driver.findElement(By.xpath(".//*[@id='loginForm3']/input[2]"));
		passwordf.clear();
		passwordf.sendKeys("pavel1");
		WebElement loginBut = driver.findElement(By.xpath(".//*[@id='loginForm3']/input[3]"));
		loginBut.click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		WebElement xbuttonnewad = driver.findElement(By.xpath(".//*[@id='popup']/div[2]/div[2]/a[1]"));
		xbuttonnewad.click();
		WebElement currenergy = driver.findElement(By.xpath(".//*[@id='ladyEnergy']"));
		WebElement maxenergy = driver.findElement(By.xpath(".//*[@id='maxLadyEnergy']"));
		String valueofcurren = currenergy.getText();
		String valueofmaxenergy = maxenergy.getText();
		int energy = Integer.parseInt(valueofcurren);
		Actions action = new Actions(driver);
		if (!currenergy.getText().equals(maxenergy.getText())) {
			WebElement city = driver.findElement(By.xpath(".//*[@id='mainNav']/li[4]/a"));
			action.moveToElement(city).moveToElement(driver.findElement(By.xpath(".//*[@id='mainNav']/li[4]/ul/li[5]/a"))).click().build().perform();
			WebElement workingbutton = driver.findElement(By.xpath(".//*[@id='workingBox']/a/span"));
			String workstatus = workingbutton.getText().toUpperCase();
			System.out.println(workstatus);
			if (workstatus.equals("����")) {
				workingbutton.click();
				WebElement stopWorkOkBut = driver.findElement(By.xpath(".//*[@id='popup']/div[2]/div[3]/a[2]/span"));
				stopWorkOkBut.click();
			}
			WebElement modnaArena = driver.findElement(By.xpath(".//*[@id='mainNav']/li[6]/a"));
			modnaArena.click();

		}
			Select droplist = new Select(driver.findElement(By.xpath(".//*[@id='popularityType']")));
			droplist.selectByIndex(0);
			WebElement searchLadyToFightbut = driver.findElement(By.xpath(".//*[@id='searchForOponent']/span[1]"));
			searchLadyToFightbut.click();
			WebElement challange = driver.findElement(By.xpath(".//*[@id='challengeLady']/span[2]"));
			challange.click();
			try {
				WebElement winstuff = driver.findElement(By.xpath(".//*[@id='popup']/div[2]/div[2]/a[2]/span"));
				winstuff.click();
			}
			catch (Exception ex) {
				System.out.println("Ne pecheli specialen prize v tozi duel!");
			}
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			WebElement Dokladbut = driver.findElement(By.xpath(".//*[@id='content']/div/div[1]/a"));
			Dokladbut.click();
			WebElement searchanotherlady = driver.findElement(By.xpath(".//*[@id='searchAgainButton']/span[1]"));
			searchanotherlady.click();
			for (int i = 0; i < energy-1; i++) {
				WebElement challangeagain = driver.findElement(By.xpath(".//*[@id='challengeLady']/span[2]"));
				challangeagain.click();
				try {
					WebElement winstuff = driver.findElement(By.xpath(".//*[@id='popup']/div[2]/div[2]/a[2]/span"));
					winstuff.click();
				}
				catch (Exception ex) {
					System.out.println("Ne pecheli specialen prize v tozi duel!");
				}
				WebElement findAnotherLady = driver.findElement(By.xpath(".//*[@id='searchAgainButton']/span[1]"));
				findAnotherLady.click();
				
			}
			
		
		
		
		
	}

}
