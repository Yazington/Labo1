package simulation;

import javax.swing.SwingWorker;

import observerPattern.IObservable;
import observerPattern.IObserver;

public class Environnement extends SwingWorker<Object, String>{
	private boolean actif = true;
	private static final int DELAI = 100;
	
	@Override
	protected Object doInBackground() throws Exception {
		while(actif) {
			Thread.sleep(DELAI);
			/**
			 * C'est ici que vous aurez a faire la gestion de la notion de tour.
			 */
			firePropertyChange("Create products", null, "Products created");
		}
		return null;
	}
}