package br.com.futbid.swing.ui.utils;

import br.com.futbid.swing.config.Config;

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
	if (buyPrice == null || sellPrice == null) {
	    return 0D;
	}
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

    public static <T> T getBean(Class<T> clazz) {
	return Config.getBean(clazz);
    }

    public static String getString(Object obj) {
	if (obj == null) {
	    return "";
	}

	if (obj instanceof Double) {
	    return ((Double) obj).toString();
	}

	return String.valueOf(obj);
    }

}
