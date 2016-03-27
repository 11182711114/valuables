package valuables;

import valuables.gui.*;
import valuables.gui.dialogs.NewDevice;
import valuables.items.*;

public class ValuableRegister {

	public static void main(String[] args) {
		ValuableRegister thisValuableRegister = new ValuableRegister();
		thisValuableRegister.run();
	}
	
	private void run(){
		ValuableHandler var = new ValuableHandler();
		var.addValuable(new Stock("LUPE", 5000, 135));
		var.addValuable(new Stock("PULE", 500, 56.3));
		var.addValuable(new Stock("SUPE", 250, 123.32));
		var.addValuable(new Jewelry("halsband", 20, true));
		var.addValuable(new Jewelry("ring", 5, false));
		var.addValuable(new Jewelry("bla", 15, true));
		var.addValuable(new Device("TV", 5000, 8));
		var.addValuable(new Device("Dator", 20000, 7));
		var.addValuable(new Device("iPhone", 5000, 3));
		var.addValuable(new Stock("A", 5000, 234));
		var.addValuable(new Stock("B", 500, 56.3));
		var.addValuable(new Stock("C", 250, 123.32));
		var.addValuable(new Jewelry("D", 20, true));
		var.addValuable(new Jewelry("E", 5, false));
		var.addValuable(new Jewelry("F", 15, true));
		var.addValuable(new Device("G", 5000, 8));
		var.addValuable(new Device("H", 20000, 7));
		var.addValuable(new Device("I", 5000, 3));
		var.addValuable(new Stock("J", 5000, 135));
		var.addValuable(new Stock("K", 500, 56.3));
		var.addValuable(new Stock("L", 250, 123.32));
		var.addValuable(new Jewelry("M", 20, true));
		var.addValuable(new Jewelry("N", 5, false));
		var.addValuable(new Jewelry("T", 15, true));
		var.addValuable(new Device("U", 5000, 8));
		var.addValuable(new Device("V", 20000, 7));
		var.addValuable(new Device("S", 5000, 3));
		
		Frame frame = new Frame(var);
			
	}
}
