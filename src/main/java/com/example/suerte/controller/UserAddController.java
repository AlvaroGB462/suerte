package com.example.suerte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.suerte.model.UserAddDTO;
import com.example.suerte.service.UserAddService;

@Controller
public class UserAddController {

	@Autowired
	private UserAddService userAddService;

	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public ModelAndView showAddUserPage() {
		return new ModelAndView("add-user");
	}

	@PostMapping("/add-user")
	public ModelAndView addUser(@ModelAttribute UserAddDTO userAddDTO) {
		ModelAndView modelAndView = new ModelAndView();

		// Validación simple de los datos
		if (userAddDTO.getEmail() == null || userAddDTO.getPasswordUser() == null || userAddDTO.getNick() == null) {
			modelAndView.setViewName("add-user");
			modelAndView.addObject("error", "Por favor complete todos los campos.");
			return modelAndView;
		}

		boolean userAdded = userAddService.addUser(userAddDTO);

		if (userAdded) {
			modelAndView.setViewName("redirect:/welcome");
			modelAndView.addObject("message", "Usuario agregado con éxito.");
		} else {
			modelAndView.setViewName("add-user");
			modelAndView.addObject("error", "Error al agregar el usuario.");
		}

		return modelAndView;
	}

}
