package valuables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import valuables.gui.GUI;
import valuables.items.Stock;
import valuables.items.Valuable;

public class ValuableHandler{
	private GUI gui;
	
	private ArrayList<Valuable> valuables = new ArrayList<>();
	
	public ValuableHandler(){
	}
	public void startGUI(){
		gui = new GUI(this);
		gui.run();
	}

	public ArrayList<Valuable> getValuables() {
		return valuables;
	}
	public void addValuable(Valuable valuable){
		valuables.add(valuable);
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
		//FIXME
		//This is not accurate if the value is different after the . i.e. 100.1 == 100.5
		@Override
		public int compare(Valuable originalValuable, Valuable otherValuable) {
			return (int) (otherValuable.getValuePostTax()-originalValuable.getValuePostTax());
		}

	}
}
