package valuables;

import java.util.ArrayList;

import valuables.items.Valuable;

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
}
