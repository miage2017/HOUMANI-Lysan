package fr.unice.miage.m1.tp3;

import java.io.IOException;
import java.net.ServerSocket;

public class Repartiteur extends ServerSocket {

	private static int port = 12001;
	private String host = "127.0.0.1";

	public Repartiteur() throws IOException {
		super(port);
	}
}
