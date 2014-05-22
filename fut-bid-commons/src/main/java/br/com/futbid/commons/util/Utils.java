package br.com.futbid.commons.util;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Utils {

    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    
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

    public static String getString(Object obj) {
	if (obj == null) {
	    return "";
	}

	if (obj instanceof Double) {
	    return ((Double) obj).toString();
	}

	return String.valueOf(obj);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getFromJSON(JSONObject jsonObject, String key, Class<T> clazz) {
        
        if(!jsonObject.has(key)) {
            LOG.info("JsonObject dosen`t has key {}", key);
            return null;
        }
        
        T result = null;
        if(clazz.equals(String.class)) {
            result = (T) jsonObject.getString(key);
        } else if(clazz.equals(Integer.class)) {
            result = (T) Integer.valueOf(jsonObject.getInt(key));
        } else if(clazz.equals(Double.class)) {
            result = (T) Double.valueOf(jsonObject.getDouble(key));
        }
        
        LOG.info("Value found for key: {}-{}", key, result);
        
        return result;
    }

}
