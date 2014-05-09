package br.com.futbid.commons.util;

import java.util.Arrays;

public abstract class StringUtils {

    private static final String STR_TO_ARG_REGEX = ",\\s";

    public static String parseArgsToString(Object... args) {
        return (args == null || args.length == 0) ? null : Arrays.toString(args);
    }

    public static Object[] parseArgsToArray(String args) {
        // params. no formato [arg1, arg2...] (parseArgsToString() -> [].len == 2)
        if (args == null || args.length() < 2) {
            return null;
        }
        return args.substring(1, args.length() - 1).split(STR_TO_ARG_REGEX);
    }

    public static boolean isEmpty(String message) {
        return message == null || message.isEmpty();
    }

    public static String toString(Object obj) {
        // tratamento para nulos e no formato classe@id
        return obj == null || obj.getClass().isPrimitive() || obj.getClass().getPackage().getName().startsWith("java") ? String
                .valueOf(obj) : String.format("%s@%s", obj.getClass().getName(), Integer.toHexString(obj.hashCode()));
    }

}
