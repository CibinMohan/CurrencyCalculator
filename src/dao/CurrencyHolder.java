package dao;

import java.util.HashMap;

import entity.Currency;
import utility.UtilityFunctions;

public class CurrencyHolder {
	HashMap<String, String> map = new HashMap<String, String>();
	HashMap<String, Currency> currencyList = new HashMap<String, Currency>();

	// The constructor will initialize all the given currency and attributes
	public CurrencyHolder() {
		map = new UtilityFunctions().setBaseTerm("AUD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "D");
		Currency aud = new Currency("AUD", "Australian Dollar", map);
		currencyList.put("AUD", aud);
		map = new UtilityFunctions().setBaseTerm("USD", "CAD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "D");
		Currency cad = new Currency("CAD", "Canadian Dollar", map);
		currencyList.put("CAD", cad);
		map = new UtilityFunctions().setBaseTerm("USD", "USD", "CNY", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "D");
		Currency cny = new Currency("CNY", "Chinese Yuan", map);
		currencyList.put("CNY", cny);
		map = new UtilityFunctions().setBaseTerm("USD", "USD", "USD", "CZK", "EUR", "INV", "USD", "USD", "EUR", "USD", "EUR");
		Currency czk = new Currency("CZK", "Czech Koruna", map);
		currencyList.put("CZK", czk);
		map = new UtilityFunctions().setBaseTerm("USD", "USD", "USD", "EUR", "DKK", "INV", "USD", "USD", "EUR", "USD", "EUR");
		Currency dkk = new Currency("DKK", "Danish Krone", map);
		currencyList.put("DKK", dkk);
		map = new UtilityFunctions().setBaseTerm("USD", "USD", "USD", "D", "D", "EUR", "USD", "USD", "D", "USD", "USD");
		Currency eur = new Currency("EUR", "Euro", map);
		currencyList.put("EUR", eur);
		map = new UtilityFunctions().setBaseTerm("USD", "USD", "USD", "USD", "USD", "USD", "GBP", "USD", "USD", "USD", "D");
		Currency gbp = new Currency("GBP", " British Pound", map);
		currencyList.put("GBP", gbp);
		map = new UtilityFunctions().setBaseTerm("USD", "USD", "USD", "USD", "USD", "USD", "USD", "JPY", "USD", "USD", "INV");
		Currency jpy = new Currency("JPY", "Japanese Yen", map);
		currencyList.put("JPY", jpy);
		map = new UtilityFunctions().setBaseTerm("USD", "USD", "USD", "EUR", "EUR", "INV", "USD", "USD", "NOK", "USD", "EUR");
		Currency nok = new Currency("NOK", "Norway Krone", map);
		currencyList.put("NOK", nok);
		map = new UtilityFunctions().setBaseTerm("USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "NZD", "D");
		Currency nzd = new Currency("NZD", "New Zealand Dollar ", map);
		currencyList.put("NZD", nzd);
		map = new UtilityFunctions().setBaseTerm("INV", "INV", "INV", "EUR", "EUR", "INV", "INV", "D", "EUR", "INV", "INV");
		Currency usd = new Currency("USD", "US Dollar", map);
		currencyList.put("USD", usd);
		Currency inv = new Currency("INV", "INV", map);
		currencyList.put("INV", inv);
		Currency d = new Currency("D", "D", map);
		currencyList.put("D", d);
	}

	// Method to add new currency
	public void addNewCurrency(Currency currency) {
		currencyList.put(currency.getCurrencyTag(), currency);
	}

	// To get all currency in the list
	public HashMap<String, Currency> getAllCurrencies() {
		return currencyList;
	}

	// To get the base currency
	public String getBaseCurrency(String currencyTagCcy1, String currencyTagCcy2)
	{
		try {
			
		Currency c = currencyList.get(currencyTagCcy1);
		HashMap<String, String> crossMap = c.getCrossMap();
		String interTag =crossMap.get(currencyTagCcy2);
		return interTag;
	}catch(

	NullPointerException e)
	{
		return null;
	}}

}
