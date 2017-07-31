package utility;

import java.util.HashMap;

public class UtilityFunctions {

	HashMap<String, String> map = new HashMap<String, String>();

	public HashMap<String, String> setBaseTerm(String AUDTag, String CADTag, String CNYTag, String CZKTag,
			String DKKTag, String EURTag, String GBPTag, String JPYTag, String NOKTag, String NZDTag, String USDTag) {
		try {
			map.clear();
			map.put("AUD", AUDTag);
			map.put("CAD", CADTag);
			map.put("CNY", CNYTag);
			map.put("CZK", CZKTag);
			map.put("DKK", DKKTag);
			map.put("EUR", EURTag);
			map.put("GBP", GBPTag);
			map.put("JPY", JPYTag);
			map.put("NOK", NOKTag);
			map.put("NZD", NZDTag);
			map.put("USD", USDTag);
			return map;

		} catch (NullPointerException e) {
			// TODO: handle exception
			return null;
		}
	}

}
