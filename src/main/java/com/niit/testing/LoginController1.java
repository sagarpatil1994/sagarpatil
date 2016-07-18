package com.niit.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController1
{
	@RequestMapping("/")
	public ModelAndView showMessage()
	 {
		System.out.println("in controller");
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping("/Form")
	public String showAboutUs()
	 {
		System.out.println("in controller");
		return "Form";
	}
	
	@RequestMapping("table")
	public ModelAndView showTable()
	 {
		System.out.println("in Table");
		ModelAndView mv = new ModelAndView("table1");
		return mv;
	}
	
}
