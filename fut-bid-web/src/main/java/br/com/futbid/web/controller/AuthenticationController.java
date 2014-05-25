package br.com.futbid.web.controller;

import java.util.Map;

import static br.com.futbid.commons.environment.FutBidEnvironment.HTTP_USER_SESSION;
import static br.com.futbid.commons.environment.FutBidEnvironment.HTTP_USER_NAME;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.futbid.domain.auth.Credentials;
import br.com.futbid.integration.impl.Session;
import br.com.futbid.service.AuthenticationService;
import br.com.futbid.web.enumeration.PageView;

@Controller
public class AuthenticationController extends BaseController {

    @Autowired
    private AuthenticationService authenticationService;

    public AuthenticationController() {
	super(PageView.AUTHENTICATION.getView());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initView(Model model, HttpServletRequest request, @RequestHeader Map<String, String> headers,
	    HttpServletResponse response) {
	LOG.debug("GET /");

	model.addAttribute("credentials", new Credentials());

	return PageView.AUTHENTICATION.getView();
    }

    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    public String authentication(@ModelAttribute("credentials") @Valid Credentials credentials,
	    BindingResult bindingResult, Model model, HttpServletRequest request) {

	try {

	    credentials.setIpAddress(request.getRemoteAddr());
	    LOG.debug("Post credentials {}", credentials);

	    if (bindingResult.hasErrors()) {
		LOG.debug("Submit binding errors: {}", bindingResult);
		return PageView.AUTHENTICATION.getView();
	    }

	    Session session = authenticationService.login(credentials);
	    request.getSession().setAttribute(HTTP_USER_SESSION, session);
	    request.getSession().setAttribute(HTTP_USER_NAME, session.getAccount().getName());

	    return "redirect:" + PageView.MAIN_CONTROLLER.getView();
	} catch (Exception e) {
	    return rejectException(bindingResult, model, e);
	}

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String authentication(Model model, HttpServletRequest request) {
	Object session = request.getSession().getAttribute(HTTP_USER_SESSION);
	LOG.info("GET logout {}", session);
	if (session != null) {
	    authenticationService.logout((Session) session);
	    request.getSession().removeAttribute(HTTP_USER_SESSION);
	    request.getSession().removeAttribute(HTTP_USER_NAME);
	}

	return "redirect:" + PageView.AUTHENTICATION_CONTROLLER.getView();
    }

}
