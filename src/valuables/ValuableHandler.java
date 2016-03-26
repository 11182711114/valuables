package valuables;

import java.util.ArrayList;
import java.util.Collections;

import valuables.items.Stock;
import valuables.items.Valuable;
import valuables.items.comperators.NameComparator;
import valuables.items.comperators.ValueComparator;

public class ValuableHandler {
	
	private ArrayList<Valuable> valuables = new ArrayList<>();
	
	public ValuableHandler(){
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
	public void sortArray(int method){
		switch(method){
		case 0:
			Collections.sort(valuables,new NameComparator());
			break;
		case 1:
			Collections.sort(valuables, new ValueComparator());
			break;
		}
	}
}
