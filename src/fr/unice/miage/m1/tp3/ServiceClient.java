package fr.unice.miage.m1.tp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServiceClient implements Runnable{

	
	private static final CharSequence Finish = null;
	Socket socket;
	int port = 12001;
	
	public ServiceClient(Socket socket) {
		this.socket=socket;
	}
	
	private Boolean Service_Client(Socket la_connection) throws IOException {
		/* On Associe une file d'entrée a la connection */
		InputStreamReader isr = new InputStreamReader(la_connection.getInputStream());
		/* On transforme cette file en file avec tampon */
		BufferedReader flux_entrant = new BufferedReader(isr);
		System.out.println("Tampon entree attache ");
		// On récupère la file de sortie
		PrintWriter ma_sortie = new PrintWriter(la_connection.getOutputStream(), true);
		System.out.println("Sortie attachée");

		String clientName = la_connection.getRemoteSocketAddress().toString();
		System.out.format("Prêt à servir le Client %s\n", clientName);

		String message_lu = new String();
		int line_num = 0;
		/*
		 * On lit le flux_entrant ligne à ligne ATTENTION : La fonction readline est
		 * Bloquante readline retourne null si il y a souci avec la connexion On s
		 * arrete aussisi connexion_non_terminee est vraie
		 */
		ma_sortie.format("Bonjour %s j attends tes données  \n", clientName);
		while ((message_lu = flux_entrant.readLine()) != null) {
			System.out.format("%d: ->  [%s]\n", line_num, message_lu);
			line_num++;
			/* si on recoit Finish on clot et annonce cette terminaison */
			if (message_lu.contains(Finish)) {
				System.out.println("Reception de  " + Finish + " -> Transmission finie");
				// On ferme la connection
				System.out.format("Je clos la connection  %s :\n", clientName);
				terminer(la_connection);
				return (true);
			}
		}
		return false;

	}
	
	private void terminer(Socket ma_connection) {
		if (ma_connection != null) {
			try {
				ma_connection.close();
				System.out.format("Socket fermee \n");
			} catch (IOException e) {
				System.out.println("weird, nawak .... \n ");
			} // do nothing }
		}
	}
	
	@Override
	public void run() {
		
		
	}

}
