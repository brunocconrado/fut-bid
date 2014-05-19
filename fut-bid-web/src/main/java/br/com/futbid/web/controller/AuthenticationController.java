package br.com.futbid.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initView(Model model, HttpServletRequest request, @RequestHeader Map<String, String> headers,
	    HttpServletResponse response) {
	LOG.debug("GET /");
	return "/html/authentication/index";
    }
    
    @RequestMapping(value = "/interna", method = RequestMethod.GET)
    public String internaView(Model model, HttpServletRequest request, @RequestHeader Map<String, String> headers,
            HttpServletResponse response) {
        LOG.debug("GET /");
        return "/html/interna/interna-app";
    }

}
