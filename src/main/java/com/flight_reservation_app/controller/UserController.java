package com.flight_reservation_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entities.User;
import com.flight_reservation_app.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
		
	}
	@RequestMapping(value = "/saveReg", method = RequestMethod.POST)
	public String saveReg(@ModelAttribute User user, ModelMap modelmap) {
		userRepo.save(user);
		modelmap.addAttribute("msg", "Record saved");
		return "login/showReg";
	}
	@RequestMapping("/showLogin")
	public String showLogin() {
		return "login/login";
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelmap) {
	try {
		User user = userRepo.findByEmail(email);
		
		if(user.getEmail().equals(email)&& user.getPassword().equals(password)) {
			return "searchFlight";
		}else {
			modelmap.addAttribute("msg", "Invalid user name/Password");
			return "login/login";
		}
		
	}catch(Exception e) {
		modelmap.addAttribute("msg", "Invalid user name/Password");
		return "login/login";	
		}
		
	}

}
