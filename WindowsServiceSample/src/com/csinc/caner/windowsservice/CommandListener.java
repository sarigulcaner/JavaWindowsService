package com.csinc.caner.windowsservice;

import com.csinc.caner.entities.Product;

public class CommandListener implements Runnable {
	private static boolean stop = false;
	private static String START = "start";
	private static String STOP = "stop";
	private static String GET = "get";
	String args[];
	 public CommandListener(Object parameter) {
	       // store parameter for later user
		 args= (String[])parameter;
		 
	   }
	 
	   // Thread internally to execute it within that new thread
	   public void run() {
		   
		   if (START.equals(args[0])) {
			   System.out.println("started");
	            start(args);
	           
		   }
		   else if(GET.equals(args[0]))
		   {
			   get(args);     
		   }
		   else if (STOP.equals(args[0])) {
	            stop(args);
	        }
	        else
	        	System.out.println("INFO: Unknown command");
	   }
	   
	   // Get Command: Do some operations here
	   public static void get(String[] args) {
	        
	    	if(args.length > 1 && args[1].equals("product"))
	        {
	                Product pro = new Product();
	                pro.ID = 1;
	                pro.Name ="New product";
	                pro.OrderNo = 0;
	                System.out.print(pro.toJson().toJSONString());   
	                args[1] = ""; 
	        }
	        
	        
	    }

		// Listener function
	    public static void start(String[] args) {
	    	
	        while (!stop) {

	        }
	    }
	 
	    // Command Stop function
	    public static void stop(String[] args) {
	        System.out.println("stoped");
	        stop = true;
	    }
}
