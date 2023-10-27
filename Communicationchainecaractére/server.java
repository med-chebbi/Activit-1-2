package Communicationchainecaractére;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
     public static void main(String[] args) {
    	try {
     ServerSocket socket = new ServerSocket(1250);
     int res =0;
    Socket s = socket.accept();
  int op1 , op2 ; String operation;
    System.out.println("un client est connecté");
	InputStream is = s.getInputStream();
	OutputStream os = s.getOutputStream();
    InputStreamReader isr= new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    op1=Integer.parseInt(br.readLine());
    op2=Integer.parseInt(br.readLine());
    operation=br.readLine();
 switch (operation) {
case "+":
	
	res=op1+op2;
	break;
	case "-":
		res=op1-op2;
		break;
	case "*":
		res=op1*op2;
		break;
	case "/":
		res=op1/op2;
		break;
 }
 PrintWriter pw = new PrintWriter(os,true);

 pw.println(res);
	}catch (Exception e) {
		e.printStackTrace();
		}
     
}
}
    
    