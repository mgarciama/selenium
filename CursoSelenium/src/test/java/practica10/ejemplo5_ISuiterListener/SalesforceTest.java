package practica10.ejemplo5_ISuiterListener;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SalesforceTest {
	 @BeforeSuite
	    public void beforeSuite(){
	        System.out.println("===> Before Suite <===");
	    }

	    @Test
	    public void successTest(){
	        System.out.println("Esto es un test de salesforce");
	    }

	    @Test
	    public void failureTest(){
	        Assert.assertTrue(false);
	    }

	    @Test
	    public void skippedTest(){
	        throw new SkipException("Test skipped!!");
	    }

	    @AfterSuite
	    public void afterSuite(){
	        System.out.println("===> After Suite <====");
	    }
}
