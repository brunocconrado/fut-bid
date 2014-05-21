package br.com.futbid.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.futbid.web.enumeration.PageView;

@Controller
@RequestMapping(value = "/api")
public class MainController extends BaseController {

    public MainController() {
	super(PageView.MAIN.getView());
    }

    @RequestMapping(value = "/internal", method = RequestMethod.GET)
    public String initView(Model model, HttpServletRequest request, @RequestHeader Map<String, String> headers,
	    HttpServletResponse response) {

	LOG.debug("GET /api/internal");

	return PageView.MAIN.getView();
    }

}
