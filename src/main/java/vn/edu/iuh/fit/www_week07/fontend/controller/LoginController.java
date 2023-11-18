package vn.edu.iuh.fit.www_week07.fontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
    public  String login(String user, String pass, Model model)
    {
        if(user.equals("admin")&&pass.equals("admin"))
            return "admin/admin-page.html";
        else return "client/Homepage";
    }
}
