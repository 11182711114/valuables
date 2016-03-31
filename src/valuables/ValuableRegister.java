package valuables;

import valuables.items.*;

public class ValuableRegister {

	private ValuableHandler valuableHandler;
	
	public static void main(String[] args) {
		ValuableRegister thisValuableRegister = new ValuableRegister();
		thisValuableRegister.start(thisValuableRegister);
	}
	private void start(ValuableRegister r){
		r.init();
		r.run();
	}
	private void run(){
		valuableHandler.addValuable(new Stock("LUPE", 5000, 135));
		valuableHandler.addValuable(new Stock("PULE", 500, 56.3));
		valuableHandler.addValuable(new Stock("SUPE", 250, 123.32));
		valuableHandler.addValuable(new Jewelry("halsband", 20, true));
		valuableHandler.addValuable(new Jewelry("ring", 5, false));
		valuableHandler.addValuable(new Jewelry("bla", 15, true));
		valuableHandler.addValuable(new Device("TV", 5000, 8));
		valuableHandler.addValuable(new Device("Dator", 20000, 7));
		valuableHandler.addValuable(new Device("iPhone", 5000, 3));
		valuableHandler.addValuable(new Stock("A", 5000, 234));
		valuableHandler.addValuable(new Stock("B", 500, 56.3));
		valuableHandler.addValuable(new Stock("C", 250, 123.32));
		valuableHandler.addValuable(new Jewelry("D", 20, true));
		valuableHandler.addValuable(new Jewelry("E", 5, false));
		valuableHandler.addValuable(new Jewelry("F", 15, true));
		valuableHandler.addValuable(new Device("G", 5000, 8));
		valuableHandler.addValuable(new Device("H", 20000, 7));
		valuableHandler.addValuable(new Device("I", 5000, 3));
		valuableHandler.addValuable(new Stock("J", 5000, 135));
		valuableHandler.addValuable(new Stock("K", 500, 56.3));
		valuableHandler.addValuable(new Stock("L", 250, 123.32));
		valuableHandler.addValuable(new Jewelry("M", 20, true));
		valuableHandler.addValuable(new Jewelry("N", 5, false));
		valuableHandler.addValuable(new Jewelry("T", 15, true));
		valuableHandler.addValuable(new Device("U", 5000, 8));
		valuableHandler.addValuable(new Device("V", 20000, 7));
		valuableHandler.addValuable(new Device("S", 5000, 3));
			
	}
	private void init(){
		valuableHandler = new ValuableHandler();
		valuableHandler.startGUI();
	}
}
