package br.com.futbid.web.config;

import static br.com.futbid.commons.util.FutBidEnvironment.APPLICATION_ENCODING_DEFAULT;
import static br.com.futbid.commons.util.FutBidEnvironment.APPLICATION_ENCODING_DEFAULT_UNSET;
import static br.com.futbid.commons.util.FutBidEnvironment.DEV;
import static br.com.futbid.commons.util.FutBidEnvironment.FLUXOAV_CONTEXT;
import static br.com.futbid.commons.util.FutBidEnvironment.FLUXOAV_DEPLOYURL;
import static br.com.futbid.commons.util.FutBidEnvironment.FLUXOAV_ENV;
import static br.com.futbid.commons.util.FutBidEnvironment.FLUXOAV_LOGDIR;
import static br.com.futbid.commons.util.FutBidEnvironment.FLUXOAV_VERSION;
import static br.com.futbid.commons.util.FutBidEnvironment.LOCAL;
import static br.com.futbid.commons.util.FutBidEnvironment.PROD;
import static br.com.futbid.commons.util.FutBidEnvironment.QA;

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
        this.profile = env.getProperty(FLUXOAV_ENV);
        this.context = env.getProperty(FLUXOAV_CONTEXT);
        this.version = env.getProperty(FLUXOAV_VERSION);
        this.deployurl = env.getProperty(FLUXOAV_DEPLOYURL);
        this.logdir = env.getProperty(FLUXOAV_LOGDIR);
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
        return isActive(env.getProperty(FLUXOAV_ENV), profile);
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
        return env.getProperty(
                APPLICATION_ENCODING_DEFAULT,
                APPLICATION_ENCODING_DEFAULT_UNSET);
    }

}
