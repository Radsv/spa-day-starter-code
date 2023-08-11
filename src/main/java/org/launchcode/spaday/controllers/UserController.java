package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {

        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors,  Model model ) {
       // model.addAttribute("verify", verify);
//    if (errors.hasErrors()) || !user.getPassword().equals(verify)) {
////            if(!user.getPassword().equals(verify))
////
////            model.addAttribute("errorMsg", "Passwords do not match!");
//            return "user/add";
//    } else {
//        return "user/index";
//    }


//
       model.addAttribute("verify", user.getVerifyPassword());
//
        if(errors.hasErrors() || !user.getPassword().equals(user.getVerifyPassword())) {
            if(!user.getPassword().equals(user.getVerifyPassword()))

            model.addAttribute("errorMsg", "Passwords do not match!");

            return "user/add";
        } else {

            return "user/index";
        }

       // if (user.getPassword().equals(verify)) {
        //   return "user/index";
       // }
       // else {
       //     model.addAttribute("error", "Passwords do not match");
       //     return "user/add";
      //  }

    }


}