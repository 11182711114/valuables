package valuables.items.comperators;

import java.util.Comparator;

import valuables.items.Valuable;

public class NameComparator implements Comparator<Valuable>{

	@Override
	public int compare(Valuable originalValuable, Valuable otherValuable) {
		return originalValuable.getName().compareToIgnoreCase(otherValuable.getName());
	}

}
