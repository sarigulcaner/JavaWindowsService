package com.csinc.caner.windowsservice;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.csinc.caner.entities.Product;

import junit.framework.TestCase;

public class SampleServiceTest extends TestCase {

	String [] parameter;
	
	public void testcase1_IsServiceStarted() {
		// Define Stream Buffer for retrieving output stream of service
		  final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		  // Init parameter and allocate memory for array
		  parameter = new String[1];
			parameter[0] = "start";
			// init print stream for capturing outputs
	        System.setOut(new PrintStream(outContent));
	        // Call service with "start" parameter
	        SampleService.main(parameter);
	        // Async request wait for a second for aync service response 
	       try {
			Thread.sleep(1000);
	       	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	       // Retrieve content of output
	        String output =outContent.toString();
	        // Check service is started
		   assertEquals("started".trim(), output.trim());
	}
	public void testcase4_UnkownCommandRequest() {
		// Define Stream Buffer for retrieving output stream of service
		  final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		  // Init parameter and allocate memory for array
		  parameter = new String[1];
			parameter[0] = "xxxx";
			// init print stream for capturing outputs
	        System.setOut(new PrintStream(outContent));
	        // Call service with "start" parameter
	        SampleService.main(parameter);
	        // Async request wait for a second for aync service response 
	       try {
			Thread.sleep(1000);
	       	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	       // Retrieve content of output
	        String output =outContent.toString();
	        // Check service is started
		   assertEquals("INFO: Unknown command".trim(), output.trim());
	}
	public void testcase2_StartService_StopService() {
		// Define Stream Buffer for retrieving output stream of service
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		// Init parameter and allocate memory for array
		 parameter = new String[1];
		
		parameter[0] = "start";
        SampleService.main(parameter);	
        	try {
			Thread.sleep(1000);
	       	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
        	  // Call service with "stop" parameter
			parameter[0] = "stop";
			// init print stream for capturing outputs
	        System.setOut(new PrintStream(outContent));
	        SampleService.main(parameter);	
	        try {
				Thread.sleep(1000);
		       	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	       String output =outContent.toString();
		   assertEquals("stoped".trim(), output.trim());
	}
	
	public void testcase3_StartService_GetProducts() {
		
		  Product pro = new Product();
          pro.ID = 1;
          pro.Name ="New product";
          pro.OrderNo = 0;
          
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		  parameter = new String[2];
			parameter[0] = "start";
	       
	        SampleService.main(parameter);	
	        try {
				Thread.sleep(1000);
				
		       	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	       
	        parameter[0] = "get";
	        parameter[1] = "product";
	        System.setOut(new PrintStream(outContent));
	        SampleService.main(parameter);
	        try {
				Thread.sleep(1000);
		       	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	        String output =outContent.toString();
	        outContent.reset();
	     // Check service : Product is returned from service
	        assertEquals(output.trim(), pro.toJson().toJSONString());
	       // Attempt close service with parameter
	        parameter[0] = "stop";
	        SampleService.main(parameter);	
	        // wait for a sec
	        try {
				Thread.sleep(1000);
		       	} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	        output =outContent.toString();
	        // Check service was stoped
		   assertEquals(output.trim(), "stoped");
	}
}
