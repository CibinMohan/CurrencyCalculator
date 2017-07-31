package calculator;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

import dao.CurrencyHolder;
import utility.CurrencyValue;

public class FxCalc {

	public static void main(String[] args) {
		calculation();
	}
	
	// Method to print all the output
	private static void calculation() {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter(System.getProperty("line.separator"));
		System.out.println("FX CALCULATOR");
		String ch;
		double finalCash = 0;
		String ccy1 = null, ccy2=null;
		CurrencyValue value = new CurrencyValue();
		CurrencyHolder currencyHolder = new CurrencyHolder();
		do {
			ch = "no";
			try {

				System.out.println("Entet currency to be converted");
				System.out.println("Format <ccy1> <amount1> in <ccy2>");
				String input = scanner.nextLine();
				String[] inputs = input.split(" ");
				// Format checking
				if (inputs.length == 4 && inputs[2].toUpperCase().equals("IN")) {
					ccy1 = inputs[0].toUpperCase();
					ccy2 = inputs[3].toUpperCase();
					double realCash = Double.parseDouble(inputs[1]);
					// transCurrency will get the intermediate currency for transaction
					String transCurrency = currencyHolder.getBaseCurrency(ccy1, ccy2);
					if (!transCurrency.equals("INV") && !transCurrency.equals("D") && !transCurrency.equals(ccy1)) {
						try {
							finalCash = (realCash * (value.getCurrencuValue(ccy1 + transCurrency)))
									* (value.getCurrencuValue(transCurrency + ccy2));
						} catch (NullPointerException e) {
							System.out.println("Transaction mapping not available");
						}
					} else {
						if (transCurrency.equals("D")) {
							try {
								finalCash = realCash * (value.getCurrencuValue(ccy1+ccy2));
							} catch (Exception e) {
								System.out.println("Transaction mapping not available");
							}
						} else if (transCurrency.equals("INV")) {
							try {
								finalCash = realCash * (value.getCurrencuValue(ccy2 + ccy1));
							} catch (Exception e) {
								System.out.println("Transaction mapping not available");
							}
						} else if (transCurrency.equals(ccy1)) {
							finalCash = realCash;
						} else {
							System.out.println("Transaction mapping not available");

						}
					}
					if (finalCash != 0) {
						if (!ccy2.equals("YEN")) {
							DecimalFormat df = new DecimalFormat("#.##");
							finalCash = Double.valueOf(df.format(finalCash));
							System.out.println(ccy1 + " " + realCash + " = " + finalCash + " " + ccy2);
						} else {
							int x = (int) finalCash;
							System.out.println(ccy1 + " " + realCash + " = " + x + " " + ccy2);
						}
						
					}
					else{
						System.out.println("Unable to find rate for " + ccy1 + "/" + ccy1);
						
					}

				} else {
					System.out.println("Wrong Format");
				}
			} catch (Exception e) {

				System.out.println("Unable to find rate for " + ccy1 + "/" + ccy1);
			}
			System.out.println("Type 'Y' to continue 	");
			finalCash = 0.0;
			ch = scanner.nextLine();
		} while (ch.equals("y") || ch.equals("Y"));
		scanner.close();
	}
}
