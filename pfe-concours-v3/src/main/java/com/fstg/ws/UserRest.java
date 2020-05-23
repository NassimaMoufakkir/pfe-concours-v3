package com.fstg.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fstg.bean.Filiere;
import com.fstg.bean.TypeDiplome;
import com.fstg.bean.User;
import com.fstg.service.facade.TypeDiplomeService;
import com.fstg.service.facade.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("pfe-concours-v3-api/user")
public class UserRest {

	@Autowired
	private UserService userService;

	@PutMapping("/seconnecter")
	public int seConnecter(@RequestBody User user) {
		return userService.seConnecter(user);
	}

	@PostMapping("/registrer")
	public int register(@RequestBody User user) {
		return userService.register(user);
	}

	@GetMapping("/")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PutMapping("/id/{id}/login/{login}/nom/{nom}/prenom/{prenom}/email/{email}/password/{password}")
	public User update(@PathVariable Long id, @PathVariable String login, @PathVariable String nom,
			@PathVariable String prenom, @PathVariable String email, @PathVariable String password) {
		return userService.update(id, login, nom, prenom, email, password);
	}

}