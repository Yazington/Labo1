package simulation;

public class Simulation {

	/**
	 * Cette classe repr�sente l'application dans son ensemble.
	 */
	public static void main(String[] args) {
		Environnement environnement = new Environnement();
		FenetrePrincipale fenetre = new FenetrePrincipale();
		synchronized(fenetre) {};
		synchronized(fenetre.getPanneau()) {};

		environnement.addPropertyChangeListener(fenetre);
		environnement.addPropertyChangeListener(fenetre.getPanneau());
		environnement.execute();
		
	}

}
