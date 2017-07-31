package entity;

import java.util.HashMap;

public class Currency {
	private String currencyTag;
	private String currencyName;
	HashMap<String, String> crossMap = new HashMap<String, String>();

	public Currency(String currencyTag, String currencyName, HashMap<String, String> crossMap) {
		this.currencyTag = currencyTag;
		this.currencyName = currencyName;
		this.crossMap = crossMap;
	}

	public String getCurrencyTag() {
		return currencyTag;
	}

	public void setCurrencyTag(String currencyTag) {
		this.currencyTag = currencyTag;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public HashMap<String, String> getCrossMap() {
		return crossMap;
	}

	public void setCrossMap(HashMap<String, String> crossMap) {
		this.crossMap = crossMap;
	}

	public String getBaseCurrency(String currencyTagCcy2) {
		return crossMap.get(currencyTagCcy2);

	}

}
