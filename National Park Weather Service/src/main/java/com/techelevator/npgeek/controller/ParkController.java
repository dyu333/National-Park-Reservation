package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.techelevator.npgeek.Models.ParkDao;
import com.techelevator.npgeek.Models.Survey;
import com.techelevator.npgeek.Models.SurveyDao;
import com.techelevator.npgeek.Models.WeatherDao;


@Controller
@SessionAttributes
public class ParkController {

	@Autowired
	private ParkDao parkDao;
	
	@Autowired
	private SurveyDao surveyDao;
	
	@Autowired
	private WeatherDao weatherDao;
	
	
	@RequestMapping(path="/homepage", method=RequestMethod.GET)
	public String displayHomepage(HttpServletRequest request) {
		
		request.setAttribute("Park", parkDao.getAllParks());
		
		return "homepage";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String displaySurveyPage(Model model) {
		if(!model.containsAttribute("survey")) {
			model.addAttribute("survey", new Survey());
		}
		model.addAttribute("parksList", parkDao.getAllParks());
		
		return "survey";
	}
	
	@RequestMapping(path={"/parkDetails"}, method=RequestMethod.GET)
	public String showParkDetails(Model model, String parkcode) {
		
		model.addAttribute("park", parkDao.getParkByParkCode(parkcode));
		model.addAttribute("weatherList", weatherDao.getWeatherByParkCode(parkcode));
		
		return "parkDetails";
	}
	
	@RequestMapping(path={"/parkDetails"}, method=RequestMethod.POST)
	public String chooseTempScale(HttpSession session, @RequestParam Boolean isCelsius, String parkcode) {
		
		session.setAttribute("isCelsius", isCelsius);
		
		return "redirect:/parkDetails?parkcode=" + parkcode;
	}
	
	@RequestMapping(path="/addSurveyWithPostWithModelMap", method=RequestMethod.POST)
	public String addSurveyWithPostWithModelMap(@Valid @ModelAttribute("survey") Survey survey, 
								BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "survey";
		}
		
		surveyDao.save(survey);
		
		return "redirect:/surveyResults";
	}

	
	@RequestMapping(path="surveyResults", method=RequestMethod.GET)
	public String displaySurveyResults(Model model) {
		
		model.addAttribute("surveyResults", surveyDao.getTopParks());
		
		return "surveyResults";
	}
	

}
