package dataForSimulation;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import observerPattern.IObserver;
import simulation.Environnement;

public abstract class Usine{

	protected int id;
	protected String type;
	protected int[] position;
	protected List<Image> images;
	protected Image currentImage;
	
	
	public abstract ProductionItem faitProduit();

	public int[] getPosition() {
		return position;
	}

	public int getId() {
		return id;
	}

	public List<Image> getIcones()
	{
		return images;
	}

	public String getType() {
		return this.type;
	}

	public Image getCurrentImage() {
		return currentImage;
	}

	public void setCurrentImage(Image currentImage) {
		this.currentImage = currentImage;
	}
	// TODO: change icone type to image type
	public Image getImageByType(String type)
	{
		if(type.equals("vide"))
		{
			return this.images.get(0);
		}
		else if(type.equals("un-tiers"))
		{
			return this.images.get(1);
		}
		else if(type.equals("deux-tiers"))
		{
			return this.images.get(2);
		}
		else if(type.equals("plein"))
		{
			return this.images.get(3);
		}
		return null;
	}

	public void updateCurrentImage() {
		if(this.currentImage.equals(this.getImageByType("vide")))
		{
			this.setCurrentImage(this.getImageByType("un-tiers"));
		}
		else if (this.currentImage.equals(this.getImageByType("un-tiers")))
		{
			this.setCurrentImage(this.getImageByType("deux-tiers"));
		}
		else if (this.currentImage.equals(this.getImageByType("deux-tiers")))
		{
			this.setCurrentImage(this.getImageByType("plein"));
		}
		else if (this.currentImage.equals(this.getImageByType("plein")))
		{
			this.setCurrentImage(this.getImageByType("vide"));
		}
	}

	
}
