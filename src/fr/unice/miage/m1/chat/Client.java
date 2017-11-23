package fr.unice.miage.m1.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) {

		int port = 12000;
		Scanner sc = new Scanner(System.in);
		
		try {
			Socket sock = new Socket("127.0.0.1", port);
	        BufferedOutputStream out = new BufferedOutputStream(sock.getOutputStream());
	        BufferedInputStream in = new BufferedInputStream(sock.getInputStream());

	        
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
