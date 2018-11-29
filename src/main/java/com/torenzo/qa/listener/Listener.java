package com.torenzo.qa.listener;

import org.testng.IExecutionListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.torenzo.qa.util.Capturescreenshot;
import com.torenzo.qa.util.SendAttachmentInEmail;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener, IExecutionListener{
	
	@Override
	// This belongs to ISuiteListener and will execute before the Suite start
	public void onStart(ISuite arg0) {

		Reporter.log("Before executing suite at the begin " + arg0.getName(), true);
		

	}

	// This belongs to ISuiteListener and will execute, once the Suite is finished

	@Override

	public void onFinish(ISuite arg0) {
		
	
		
	}

	// This belongs to ITestListener and will execute before starting of Test set/batch 

	public void onStart(ITestContext arg0) {

		Reporter.log("Before executing test method once only" + arg0.getName(), true);

	}

	// This belongs to ITestListener and will execute, once the Test set/batch is finished

	public void onFinish(ITestContext arg0) {

		Reporter.log("After executing test method once only" + arg0.getName(), true);

	}

	// This belongs to ITestListener and will execute only when the test is pass

	public void onTestSuccess(ITestResult arg0) {

		// This is calling the printTestResults method
	
try{
			
			Capturescreenshot.capture(arg0.getName());
			System.out.println("Screenshot is captured for pass TC");
			
			System.out.println("Printed pass test case name is =>" +arg0);	
			
		}catch(Exception e)
		{
			System.out.println("Screenshot is not captured for pass TC");
		e.printStackTrace();
	    }

	}

	// This belongs to ITestListener and will execute only on the event of fail test

	public void onTestFailure(ITestResult arg0) {

		// This is calling the printTestResults method
	
			
		try{
			
			Capturescreenshot.capture(arg0.getName());
			System.out.println("Screenshot is captured for failure TC");
			
			System.out.println("Printed failure class name is =>" +arg0);	
			
		}catch(Exception e)
		{
			System.out.println("Screenshot is not captured for failure TC");
		e.printStackTrace();
	    }

	

	   }

	// This belongs to ITestListener and will execute before the main test start (@Test)

	public void onTestStart(ITestResult arg0) {

		System.out.println("The execution of the main test starts now(@Test method)");

	}

	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

	public void onTestSkipped(ITestResult arg0) {

		try {
			printTestResults(arg0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{


	}

	private void printTestResults(ITestResult result) throws InterruptedException {
		

 	   Reporter.log("(About@Test Method)Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);

		}

		
	
		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";
			

			break;

		case ITestResult.FAILURE:

			status = "Failed";
		

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

	}

	// This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

		String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

	@Override
	public void onExecutionStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExecutionFinish() {

		try {
			Thread.sleep(5000);
			System.out.println("Now here");
			SendAttachmentInEmail call1 = new SendAttachmentInEmail();
	     	call1.email();
	    	System.out.println("Now here1");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}	
	
	
