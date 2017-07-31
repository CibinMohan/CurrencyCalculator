package utility;

import java.util.HashMap;

public class CurrencyValue {
	
	private HashMap<String, Double> map = new HashMap<String, Double>();

	// Initializing all given currency value
	public CurrencyValue() {
		setValue("AUDUSD",0.8371);
		setValue("CADUSD",0.8711);
		setValue("USDCNY",6.1715);		
		setValue("EURUSD",1.2315);
		setValue("GBPUSD",1.5683);
		setValue("NZDUSD",0.7750);
		setValue("USDJPY",119.95);
		setValue("EURCZK",27.6028);
		setValue("EURDKK",7.4405);
		setValue("EURNOK",8.6651);
	}
	// To add new currency value
	public void setValue(String currencyTagCombo, Double currencyTransferValue)
	{
		map.put(currencyTagCombo, currencyTransferValue);
	}
	public HashMap<String, Double> getMap() {
		return map;
	}
	public void setMap(HashMap<String, Double> map) {
		this.map = map;
	}
	// To remove a currency value
	public void removeElement(String currencyTagCombo)
	{
		map.remove(currencyTagCombo);
	}
	
	// To get currency value
	public Double getCurrencuValue(String baseXTerms)
	{
		try{
		double val =map.get(baseXTerms);
		return val;
		}catch (NullPointerException e) {
			return null;
		}
	}

}
