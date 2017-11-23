package fr.unice.miage.m1.tp2;

public class DumbClass  implements Runnable{
    static String nom="Toto";
    static int maxIter= 1000 ;
    public DumbClass(String  nom)    {
	this.nom=nom;
    }

    public void run()    {
	System.out.format("Ici le  thread %s, je debute!\n", nom);
	for (int i = 0; i < maxIter; i++) {
	    System.out.format("[%s] dit  je suis Ici %d\n",nom,i); 	}
		System.out.format("Ici le  thread %s, je  Termine!\n", nom);
    }
    

    public static void main(String[] args)  throws  Exception {

	String jobName= String.format("Job_%d", 0);
	DumbClass   objetExec  = new DumbClass( jobName);
	Thread job = new Thread(objetExec);
	System.out.format("Creating thread %s\n", jobName);
	job.start();
	System.out.format("Thread principal terminé  !\n");
	
	Thread t = new Thread(
			new Runnable() {
			public void run() {
			System.out.format("Ici le  thread %s, je debute!\n", nom);
				for (int i = 0; i < maxIter; i++) {
					System.out.format("[%s] dit  je suis Ici %d\n",nom,i); 	}
				System.out.format("Ici le  thread %s, je  Termine!\n", nom);
				}
			}
	);
	t.start();
	t.join();
	
	Thread t1 = new Thread(
			new Runnable() {
			public void run() {
			System.out.format("Ici le  thread %s, je debute!\n", nom);
				for (int i = maxIter; i > 0; i--) {
					System.out.format("[%s] dit  je suis Ici %d\n",nom,i); 	}
				System.out.format("Ici le  thread %s, je  Termine!\n", nom);
				}
			}
	);
	t1.start();
	t1.join();
	
    }

}
