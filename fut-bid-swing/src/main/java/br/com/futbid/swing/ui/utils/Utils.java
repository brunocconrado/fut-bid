package br.com.futbid.swing.ui.utils;

public class Utils {

    private static final double MY_PART_FROM_SELL_PRICE = 0.95D;

    public static boolean isDouble(String text) {
	boolean isNumber = false;
	try {
	    Double.parseDouble(text);
	    isNumber = true;
	} catch (NumberFormatException e) {
	    //no-op
	}
	return isNumber;
    }

    public static Double parseDouble(String text) {
	if (!isDouble(text)) {
	    return null;
	}
	return Double.parseDouble(text);
    }

    public static Double calculateProfit(Double buyPrice, Double sellPrice) {
	return sellPrice * MY_PART_FROM_SELL_PRICE - buyPrice;
    }

    public static Integer parseInt(String text) {
	Integer result = null;
	try {
	    result = Integer.parseInt(text);
	} catch (NumberFormatException e) {
	    //no-op
	}

	return result;
    }

}