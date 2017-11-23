package fr.unice.miage.m1.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class Serveur {

	public static void main(String[] args) {

		int port = 12000;
		Socket sockDuServeur;
		Scanner sc = new Scanner(System.in);
		
		try {
			ServerSocket servSock = new ServerSocket(port);
			sockDuServeur = servSock.accept();
			PrintWriter out = new PrintWriter(sockDuServeur.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(sockDuServeur.getInputStream()));
			
			String s = sc.next();
			out.println(s);
			out.flush();
			
			String msg_client = in.readLine();
			System.out.println("Client : " + msg_client);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
