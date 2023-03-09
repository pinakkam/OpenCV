package openCV;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCvTest {

	public static void main(String[] args) {

		System.load("C:\\Selenium\\openCV\\opencv\\build\\java\\x64\\opencv_java470.dll");

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		// Load the Screenshot images using OpenCV

		Mat image = Imgcodecs.imdecode(new MatOfByte(screenshot), Imgcodecs.IMREAD_UNCHANGED);

		// Applying Canny Edge Detection filter on the image

		Mat edges = new Mat();
		Imgproc.Canny(image, edges, 100, 200);

		// Saving the image file.

		Imgcodecs.imwrite("C:\\Selenium\\OpenCV Screenshotz\\Screenshot_1.jpg", edges);

		driver.quit();
	}

}
