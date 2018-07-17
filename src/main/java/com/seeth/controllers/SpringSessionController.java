package com.seeth.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringSessionController {
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getPage(Model model, HttpSession session) {
		List<String> favoriteColors = getFavColors(session);
        model.addAttribute("favoriteColors", favoriteColors);
		model.addAttribute("sessionId", session.getId());
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String postPage(HttpServletRequest request, @RequestParam("color") String color) {
		List<String> favColors = getFavColors(request.getSession());
		
		if(color!=null) {
			favColors.add(color);
			request.getSession().setAttribute("favoriteColors", favColors);
		}
		
		return "redirect:/";
	}

	private List<String> getFavColors(HttpSession session) {
		List<String> favoriteColors = (List<String>) session.getAttribute("favoriteColors");
			if(favoriteColors==null) {
				favoriteColors = new ArrayList<>();
			}
		
		return favoriteColors;
	}
	
}
