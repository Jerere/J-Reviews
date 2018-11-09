package HarjoitusTyo.JReviews.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import HarjoitusTyo.JReviews.Model.SignupForm;
import HarjoitusTyo.JReviews.Model.User;
import HarjoitusTyo.JReviews.Model.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// SIGN UP PAGE
	@RequestMapping(value = "signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	// SAVE NEW USER
	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupform, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			if (signupform.getPassword().equals(signupform.getPasswordCheck())) {
				String pwd = signupform.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);

				User newUser = new User();
				newUser.setPasswordHash(hashPwd);
				newUser.setUsername(signupform.getUsername());
				newUser.setRole("USER");

				if (userRepository.findByUsername(signupform.getUsername()) == null) {
					userRepository.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords does not match");
				return "signup";
			}
		} else {
			return "signup";
		}
		return "redirect:/login";
	}
}
