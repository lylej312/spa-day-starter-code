package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {

        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        String error = "Error, passwords must match!";

        if (verify.equals(user.getPassword()) && !verify.equals("")) {
            UserData.add(user);
            user.setDate(new Date());
            model.addAttribute("users", UserData.getAll());
            model.addAttribute("user", user);
            return "user/index";
        }
        model.addAttribute("error", error);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());

        return "user/add";
    }

    @GetMapping("info/{userId}")
    public String displayUserInfo(Model model, @PathVariable int userId) {
        User user = UserData.getById(userId);
        model.addAttribute("user", user);
        return "user/info";
    }
}
