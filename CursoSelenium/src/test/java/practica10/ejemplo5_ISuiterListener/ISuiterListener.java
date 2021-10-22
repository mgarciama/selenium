package practica10.ejemplo5_ISuiterListener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class ISuiterListener implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("se ejecuta la suite: "+ suite.getName());
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("se terminó la suite: "+ suite.getName());
		
	}

}
