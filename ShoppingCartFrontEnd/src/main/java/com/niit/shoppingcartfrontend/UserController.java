package com.niit.shoppingcartfrontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {
	//UserDAO - backend project
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	HttpSession httpSession;

	@PostMapping("validate")
	public ModelAndView validate(@RequestParam("uname") String name,@RequestParam("psw") String password)
	{
		ModelAndView mv = new ModelAndView("home");
		  user = userDAO.validate(name, password); 
			
		if(user ==null)
		{
			mv.addObject("error Message", "Invalid credentials,please try again...!");
		}
		else
		{
			//mv.addObject("error message", "Welcome Mr/Ms." + name);
			httpSession.setAttribute("welcomeMessage", "Welcome Mr./Ms " + user.getName());
			httpSession.setAttribute("loggedInUserId", user.getEmailId());
			if(user.getRole()=='A')
			{
				httpSession.setAttribute("isAdmin", true);
			}
		}
			return mv;
		
	}
}
