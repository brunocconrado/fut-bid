package br.com.futbid.web.config;

import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_ENCODING_DEFAULT;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_ENCODING_DEFAULT_UNSET;
import static br.com.futbid.commons.environment.FutBidEnvironment.DEV;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_CONTEXT;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_DEPLOYURL;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_ACTIVE_PROFILE;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_LOGDIR;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_VERSION;
import static br.com.futbid.commons.environment.FutBidEnvironment.LOCAL;
import static br.com.futbid.commons.environment.FutBidEnvironment.PROD;
import static br.com.futbid.commons.environment.FutBidEnvironment.QA;

import java.util.Objects;

import br.com.futbid.commons.message.EnvironmentProperties;

public class WebProperties {

    private final EnvironmentProperties env;

    public final String profile;
    public final String context;
    public final String version;
    public final String deployurl;
    public final String logdir;

    WebProperties(EnvironmentProperties environmentProperties) {
	Objects.requireNonNull(environmentProperties);
	this.env = environmentProperties;
	// contexto web
	this.profile = env.getProperty(APPLICATION_ACTIVE_PROFILE);
	this.context = env.getProperty(APPLICATION_CONTEXT);
	this.version = env.getProperty(APPLICATION_VERSION);
	this.deployurl = env.getProperty(APPLICATION_DEPLOYURL);
	this.logdir = env.getProperty(APPLICATION_LOGDIR);
    }

    public EnvironmentProperties get() {
	return env;
    }

    public boolean isDebug() {
	return isDebug(profile);
    }

    public static final boolean isDev(EnvironmentProperties env) {
	return isActive(DEV, env);
    }

    public static final boolean isProd(EnvironmentProperties env) {
	return isActive(PROD, env);
    }

    public static final boolean isLocal(EnvironmentProperties env) {
	return isActive(LOCAL, env);
    }

    public static final boolean isQA(EnvironmentProperties env) {
	return isActive(QA, env);
    }

    public final boolean isProd() {
	return isActive(PROD, env);
    }

    public static final boolean isDebug(String currentEnvironment) {
	return isActive(LOCAL, currentEnvironment) || isActive(DEV, currentEnvironment);
    }

    protected static final boolean isActive(String profile, EnvironmentProperties env) {
	if (env == null || profile == null) {
	    return false;
	}
	return isActive(env.getProperty(APPLICATION_ACTIVE_PROFILE), profile);
    }

    private static boolean isActive(String activeProfile, String configuration) {
	return activeProfile.equals(configuration);
    }

    @Override
    public String toString() {
	/* gerar pelo eclipse */
	return "WebProperties [env=" + env + ", environment=" + profile + ", context=" + context + ", version="
		+ version + ", deployurl=" + deployurl + ", logdir=" + logdir + "]";
    }

    public String getEncoding() {
	return env.getProperty(APPLICATION_ENCODING_DEFAULT, APPLICATION_ENCODING_DEFAULT_UNSET);
    }

}
