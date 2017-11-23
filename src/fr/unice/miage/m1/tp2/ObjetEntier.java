package fr.unice.miage.m1.tp2;

public class ObjetEntier {
    
	private int ma_valeur;
    
    public ObjetEntier()    {
    	ma_valeur=0; 
    	System.out.format("Valeur partagee initialisee a %d\n", ma_valeur); 
    }
    
    public String  toString(){
    	return Integer.toString (ma_valeur);    
	}
    
    public int val(){ 
    	return ma_valeur;
    }
    
    //synchronized pour finir � 0 (synchro les thread)
    public synchronized void add(int i) { 
    	ma_valeur+=i;
    } 

}