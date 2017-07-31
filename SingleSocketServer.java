//package basicNetworkOperation;


import java.net.*;
import java.io.*;
import java.util.*;

/**
 * SingleSocketServer class processes an socket at a time.
 * @author dushantha
 *
 */
public class SingleSocketServer {

	/* the server socket class has been used to set up a new server.
	 * The server socket can be created to listen to a particular port
	 * thus accept and handle incoming sockets.
	 */
	private static ServerSocket socket1;
	// on which port the program is running
	protected final static int port = 19999;
	private static Socket connection;

	
	  public static void main(String[] args) {
	    try{
	      socket1 = new ServerSocket(port);
	      System.out.println("SingleSocketServer Initialized");	
	      Scanner sc =null;
	      
	    // while loop lets the server continue listening to the port continuously
	     	 while(true){  
	     		 
	     		/*
		          * Accept the incoming connection to this socket,
		          * till then the program floor is suspended,i.e. the method
		          * is blocked till the connection is established.
		          * It's achieve via the accept() of ServerSocket class.
		          */
		        connection = socket1.accept();
		        
		        /*Instantiate the scanner instance that's bound to the input stream 
		         * object which reads the data sent in by the client.  
		         */
		        sc = new Scanner(connection.getInputStream()); 
		        
		        System.out.println("--- Reading from the client :  ");
		        
		        int number = sc.nextInt(); // the accepted number is doubled.
		        int temp = number*2;
		        
		        PrintStream p = new PrintStream(connection.getOutputStream());
		        
		        p.println(temp); 
		     // releasing resources.
		        sc.close();
	     		 
	     	 } //-- end of while loop
		        
	        } catch (IOException e){
	        	System.out.println(e.getMessage()); 
	        	try {
	                connection.close();
	              }
	              catch (IOException ioex) {}	        
	        	
	        } catch (NoSuchElementException nchElexp){
	        	System.out.println(nchElexp.getMessage());	        	
	        }	        	
	      }   //-- end of main()
	  
	}

