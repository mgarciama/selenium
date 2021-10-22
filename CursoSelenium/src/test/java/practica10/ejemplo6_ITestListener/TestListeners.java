package practica10.ejemplo6_ITestListener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("New Test Started : " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test successfully finished: " +  result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED!!:  "+" --- " + result.getName());
        
        ITestContext context = result.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
        String projectPth = System.getProperty("user.dir");
        
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String nameTest = result.getName();
        try {
			FileUtils.copyFile(scrFile, new File(projectPth + "/screenshots/"+nameTest +"_" +System.currentTimeMillis()+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test SKIPPED: " + " --- " + result.getName());
    }

    public void onStart(ITestContext context) {
        System.out.println("Test started : " + context.getOutputDirectory() + "--- " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Test finished : " + context.getOutputDirectory() + "--- " + context.getName());
    }

	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
