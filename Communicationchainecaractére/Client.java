package Communicationchainecaractére;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	 public static void main(String[] args)  {
		try {
             Socket socket = new Socket("localhost",1250);
             InputStream is = socket.getInputStream();
             Scanner scanner = new Scanner(System.in);
             int op1, op2; String operation;
             
             op1=scanner.nextInt();
             op2=scanner.nextInt();
            scanner.nextLine();             
            do {
            	System.out.println("donner l'operation");
            	operation = scanner.nextLine();
             }while(!operation.equals("+")&& !operation.equals("-") && !operation.equals("*")  && !operation.equals("/"));
        	
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
		    pw.println(op1);
		    pw.println(op2);
		    pw.println(operation);
		    System.out.println((new BufferedReader(new InputStreamReader(is))).readLine());
	 }catch (Exception e) {
		e.printStackTrace();
	}
	 }
}
