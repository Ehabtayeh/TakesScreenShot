package authentication;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot {
	WebDriver driver ;
	
	@Test
	public void takeScreenShotTest() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
        // عمل اسم فريد باستخدام التاريخ والوقت
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotName = "screenshot_" + timestamp + ".png";
		// استدعاء دالة أخذ لقطة الشاشة
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("/.ScreenShot\\image" + screenshotName);

        FileUtils.copyFile(scrFile, dest);

		
	}

}
