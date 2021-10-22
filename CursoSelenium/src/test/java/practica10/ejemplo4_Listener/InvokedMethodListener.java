package practica10.ejemplo4_Listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
//implementamos un interface de testNg
public class InvokedMethodListener implements IInvokedMethodListener{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		//dice cuanto test se ha ejecutado
		System.out.println("Antes de invocar" + method.getTestMethod().getMethodName());
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("Después de invocar" + method.getTestMethod().getMethodName());
		
	}

}
