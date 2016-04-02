package valuables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.SwingUtilities;

import valuables.gui.GUI;
import valuables.items.Stock;
import valuables.items.Valuable;

/* ##################
 * #      TODO      #
 * ##################
 * 
 * 
 * 
 */

public class ValuableHandler{
	public static final int SORT_BY_NAME = 0;
	public static final int SORT_BY_VALUE = 1;
	private GUI gui;
	private ValuableHandler var = this;
	
	private ArrayList<Valuable> valuables = new ArrayList<>();
	
	public ValuableHandler(){
	}
	public void startGUI(){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				gui = new GUI(var);
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
		case 0:
			Collections.sort(valuables,new NameComparator());
			break;
		case 1:
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
}
