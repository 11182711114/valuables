package valuables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.UUID;

import javax.swing.SwingUtilities;

import valuables.gui.GUI;
import valuables.items.Device;
import valuables.items.Jewelry;
import valuables.items.Stock;
import valuables.items.Valuable;

public class ValuableHandler{
	public static final int SORT_BY_NAME = 0;
	public static final int SORT_BY_VALUE = 1;
	
	private GUI gui;
	
	private ArrayList<Valuable> valuables; 
	
	public ValuableHandler(){
		valuables = new ArrayList<>();
	}
	public void startGUI(){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				gui = new GUI(ValuableHandler.this);
				gui.run();
			}
		});
	}

	public ArrayList<Valuable> getValuables() {
		return valuables;
	}
	public void addValuable(Valuable valuable){
		valuables.add(valuable);
	}
	private void printValuables(){
		for(Valuable v : valuables){
			System.out.println(v.toPrint());
		}
	}
	public void addMultipleValuables(ArrayList<Valuable> valuables){
		this.valuables.addAll(valuables);
	}
	public void marketCrash(){
		for(Valuable valuable : valuables){
			if(valuable instanceof Stock){
				((Stock) valuable).setExchangeRate(0);
			}
		}
	}
	public void sortValuables(int method){
		switch(method){
		case SORT_BY_NAME:
			Collections.sort(valuables,new NameComparator());
			break;
		case SORT_BY_VALUE:
			Collections.sort(valuables, new ValueComparator());
			break;
		}
	}
	private class NameComparator implements Comparator<Valuable>{
		@Override
		public int compare(Valuable originalValuable, Valuable otherValuable) {
			return originalValuable.getName().compareToIgnoreCase(otherValuable.getName());
		}
	}
	private class ValueComparator implements Comparator<Valuable>{
		@Override
		public int compare(Valuable originalValuable, Valuable otherValuable) {
			int output = 0;
			double d = otherValuable.getValuePostTax()-originalValuable.getValuePostTax();
			if(d<0)
				output = -1;
			else if(d>0)
				output = 1;
			
			return output;
		}
	}
	public void test(){
		Random rand = new Random();
		for(int i = 0; i<=1000; i++){
			int rands = rand.nextInt(3);
			switch(rands){
			case 0:
				addValuable(new Device(UUID.randomUUID().toString().replaceAll("-", ""),rand.nextInt(100),rand.nextInt(10)));
				break;
			case 1:
				addValuable(new Jewelry(UUID.randomUUID().toString().replaceAll("-", ""),rand.nextInt(100),rand.nextBoolean()));
				break;
			case 2:
				addValuable(new Stock(UUID.randomUUID().toString().replaceAll("-", ""),rand.nextInt(1000),rand.nextDouble()*100));
				break;
			}
		}
	}
}
