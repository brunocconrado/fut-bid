package br.com.futbid.commons.util;

/**
 * Chaves do environment.properties
 */
@SuppressWarnings("all")
public abstract class FutBidEnvironment {

    public static final String APPLICATION_ACTIVE_PROFILE = "application.active.profile";
    public static final String APPLICATION_CONTEXT = "application.web.context";
    public static final String APPLICATION_VERSION = "application.web.version";
    public static final String APPLICATION_DEPLOYURL = "application.deploy.url";
    public static final String APPLICATION_LOGDIR = "application.logdir";

    public static final String DEV = "dev";
    public static final String QA = "qa";
    public static final String PROD = "prod";
    public static final String LOCAL = "local";

    public static final String APPLICATION_LANGUAGE_UNSET = "pt";
    public static final String APPLICATION_LANGUAGE = "application.language";

    public static final String APPLICATION_COUNTRY_UNSET = "BR";
    public static final String APPLICATION_COUNTRY = "application.country";

    public static final String APPLICATION_ENCODING_DEFAULT_UNSET = "UTF-8";
    public static final String APPLICATION_ENCODING_DEFAULT = "application.encoding.default";

    public static final String APPCODE_DEFAULT = "DLM";
    public static final String BRAZIL_COUNTRY_CODE = "55";

    /* Mongo properties */
    public static final String MONGO_HOST = "mongo.host";
    public static final String MONGO_PORT = "mongo.port";
    public static final String MONGO_DB = "mongo.db";
    public static final String MONGO_TIMEOUT = "mongo.connection.timeout";
    public static final String MONGO_MAX_WAIT_TIME = "mongo.max.wait.time";

}