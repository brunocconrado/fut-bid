package br.com.futbid.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.WebUtils;

public abstract class RequestUtils extends WebUtils {

    private static final Logger LOG = LoggerFactory.getLogger(RequestUtils.class);

    public static final String X_FORWARDED_FOR = "X-Forwarded-For";

    public static String redirectUrl(HttpServletRequest request, HttpServletResponse response, String view) {
	try {
	    String url = response.encodeRedirectURL(request.getContextPath() + view);
	    LOG.debug("redirectUrl -> ", url);
	    response.sendRedirect(url);
	    return url;
	} catch (Exception e) {
	    LOG.error(view + ":" + e.getMessage(), e);
	    return null;
	}
    }

    public static String pathInfo(HttpServletRequest request) {
	try {
	    String pathInfo = request.getPathInfo();
	    if (pathInfo == null) {
		String requestURI = request.getRequestURI();
		if (requestURI == null || requestURI.isEmpty() || !requestURI.startsWith(request.getContextPath())) {
		    return "";
		}
		return requestURI.substring(request.getContextPath().length());
	    }
	    return pathInfo;
	} catch (Exception e) {
	    LOG.error(request + ":" + e.getMessage(), e);
	    return "";
	}
    }

}
