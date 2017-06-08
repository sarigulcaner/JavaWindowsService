package com.csinc.caner.windowsservice;

import org.json.simple.*;
import com.csinc.caner.entities.*;


public class SampleService {

	public static void main(String[] args) {
		
		 Thread t = new Thread(new CommandListener(args));
		 t.start();
		
	}
    
 
}
