package fr.unice.miage.m1.client_server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerSocketConstructor {

   public static void main(String[] args) {

      for(int port = 1; port <= 65535; port++){
         try {
            ServerSocket sSocket = new ServerSocket(port);
         } catch (IOException e) {
            System.err.println("Le port " + port + " est déjà utilisé ! ");
         }
      }
      
	   try {
	         InetAddress address = InetAddress.getLocalHost();
	         showInformations(address, "Hôte local");
	         
	         address = InetAddress.getByAddress(
	               new byte[]{(byte)10, (byte)154, 122, (byte) 251}
	         );
	         showInformations(address, "10.154.122.251");
	         
	         address = InetAddress.getByName("localhost");
	         showInformations(address, "locahost");
	                  
	         address = InetAddress.getByName("127.0.0.1");
	         showInformations(address, "127.0.0.1");
	         
	      } catch (UnknownHostException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void showInformations(InetAddress address, String name){
	      System.out.println("-----------------------------------------------");
	      System.out.println("INFORMATIONS DE " + name);
	      System.out.println("-----------------------------------------------");
	      System.out.println("Nom  : " + address.getHostName());
	      System.out.println("Adresse : " + address.getHostAddress());
	      System.out.println("Nom canonique : " + address.getCanonicalHostName());
	      //Cette méthode nous retourne un tableau de byte
	      byte[] bAddress = address.getAddress();
	      String ip = "";
	      for(byte b : bAddress)
	           ip +=(b & 0xFF) + ".";//L'instruction & 0xFF permet d'avoir la valeur non signée

	      System.out.println("Adresse IP depuis tableau de byte : " + ip);
	   }
}