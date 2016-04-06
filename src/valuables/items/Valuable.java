package valuables.items;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Valuable{
	private static final double TAX_PERCENTAGE = 1.25;
	
	private String name;
	
	private String fullClassName = this.getClass().getName();//gets the full class path as string
	private String className = fullClassName.substring(fullClassName.lastIndexOf('.')+1);//trims fullClassName to after last '.'(i.e. only the class name)
	
	
	public Valuable(String name){
		this.name = name;
	}
	
	public double getValuePostTax(){
		return getValuePreTax()*TAX_PERCENTAGE;		
	}
	public String getName(){
		return name;
	}
	abstract public double getValuePreTax();
	protected double roundDouble(double d){
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		
		double roundedDouble = Double.parseDouble(df.format(d));
		return roundedDouble;
	}
	public String toPrint(){
		Double value = roundDouble(getValuePostTax());
		String output = className +": "+ getName() +" värde:"+ value +" ";
		for(String s : getSpecialVariables()){
			output+=s+" ";
		}
		return output;	
	}
	abstract public String[] getSpecialVariables();
		
	public String toString(){
		return className +" "+ getName() +" "+ getValuePreTax() +" "+ getValuePostTax();
	}
}
