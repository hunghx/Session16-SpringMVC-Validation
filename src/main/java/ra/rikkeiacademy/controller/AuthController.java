package ra.rikkeiacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.rikkeiacademy.dto.SignInForm;
import ra.rikkeiacademy.model.User;
import ra.rikkeiacademy.service.UserService;
import ra.rikkeiacademy.validate.LoginValidate;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired
    private UserService  userService;
    @Autowired
    private LoginValidate loginValidate;

    @GetMapping("/login")
    public ModelAndView loginForm(){
        ModelAndView model = new ModelAndView();
        model.setViewName("sign-in");
        model.addObject("loginForm",new SignInForm());
        return model;
    }
    @PostMapping("/sign-in")
    public String doLogin( @ModelAttribute("loginForm") @Valid SignInForm formLogin
            , BindingResult bindingResult, HttpSession session){
        // kiểm tra tính đúng đắn của dữ liệu
        loginValidate.validate(formLogin,bindingResult);
        if (bindingResult.hasErrors()){
            return "sign-in";
        }
        User user = userService.login(formLogin);
        if (user==null){
            bindingResult.rejectValue("message","message.error.login");
            return "sign-in";
        }
        session.setAttribute("user_login",user);
        return "home";
    }
}
