package br.com.futbid.commons.environment;

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
    
    //AUTH JSON
    public static final String AUTH_DEFAULT_URL = "auth.default.url";
    public static final String AUTH_DEFAULT_VALIDATE_ANSWER_URL = "auth.validate.answer.url";
    public static final String AUTH_HOME_URL = "auth.home.url";
    public static final String AUTH_DEFAULT_STATE_URL = "auth.state.url";
    public static final String AUTH_DEFAULT_LOGOUT = "auth.default.logout";
    public static final String AUTH_HEADER_REFER = "auth.header.refer";
    public static final String AUTH_POST_JSON = "auth.post.json";
    public static final String AUTH_DEFAULT_LOGGED = "auth.default.logged";
    public static final String AUTH_INVALID_ANSWER = "auth.invalid.answer.code";

    public static final String HTTP_USER_AGENT = "http.user.agent";
    public static final String HTTP_USER_SESSION = "user.session";
    public static final String HTTP_USER_NAME = "userName";
    
    

}