package com.fstg.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.fstg.bean.TypeDiplome;
import com.fstg.bean.User;
import com.fstg.dao.UserDao;
import com.fstg.service.facade.UserService;
import com.fstg.service.util.HashUtil;
import com.fstg.service.util.PasswordRandomUtil;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private JavaMailSender javaMailSender;

	void sendEmailWithAttachment(String to, String subject, String message) throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo(to);

		helper.setSubject(subject);

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText("<h1>" + message + "</h1>", true);

		// hard coded a file path
		// FileSystemResource file = new FileSystemResource(new
		// File("path/android.png"));

//		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

		javaMailSender.send(msg);

	}

	public int register(User user) {
		if (findByLogin(user.getLogin()) != null) {
			return -1;
		} else {
			user.setPassword(PasswordRandomUtil.generateRandomString(8));

			try {
				sendEmailWithAttachment(user.getEmail(), "Création de votre compte FSTG Concours", "Bonjour/Bonsoir "
						+ user.getNom() + " " + user.getPrenom()
						+ ". <br> Votre compte FSTG Concours a été créé avec succès. <br> Pour effectuer votre préinscription, "
						+ "veuillez vous connecter. <br> Voici vos coordonnées :" + "<br> Votre login (CNE) : "
						+ user.getLogin() + "<br> Votre mot de passe : " + user.getPassword() + ".");
			} catch (MessagingException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ("ha login " + user.getLogin() + " o ha pass " + user.getPassword());
			user.setPassword(HashUtil.hash(user.getPassword()));
			user.setNbrTentativeRestant(5);
			userDao.save(user);
			return 1;
		}
	}

	@Override
	public int seConnecter(User user) {
		User loadedUser = findByLogin(user.getLogin());
		if (loadedUser == null) {
			return -1;
		} else if (!loadedUser.getPassword().equalsIgnoreCase(HashUtil.hash(user.getPassword()))) {
			loadedUser.setNbrTentativeRestant(loadedUser.getNbrTentativeRestant() - 1);
			if (loadedUser.getNbrTentativeRestant() == 0) {
				loadedUser.setBloqued(true);
				loadedUser.setDateBloquage(new Date());
				userDao.save(loadedUser);
				return -2;
			} else {
				userDao.save(loadedUser);
				return -3;
			}
		} else {
			return 1;
		}
	}

	@Override
	public User findByLogin(String login) {
		return userDao.findByLogin(login);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User update(Long id, String login, String nom, String prenom, String email, String password) {
		User foundedUser = findById(id);
		foundedUser.setLogin(login);
		foundedUser.setNom(nom);
		foundedUser.setPrenom(prenom);
		foundedUser.setEmail(email);
		foundedUser.setPassword(password);
		User updatedUser = userDao.save(foundedUser);
		try {
			sendEmailWithAttachment(foundedUser.getEmail(), "Modification de votre compte FSTG Concours",
					"Bonjour/Bonsoir " + foundedUser.getNom() + " " + foundedUser.getPrenom()
							+ ". <br> Votre compte FSTG Concours a été modifié avec succès. <br> Voici vos nouveaux coordonnées :"
							+ "<br> Votre login (CNE) : " + foundedUser.getLogin() + "<br> Votre mot de passe : "
							+ foundedUser.getPassword() + ".");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updatedUser;
	}

	public User findById(Long id) {
		return userDao.getOne(id);
	}

}
