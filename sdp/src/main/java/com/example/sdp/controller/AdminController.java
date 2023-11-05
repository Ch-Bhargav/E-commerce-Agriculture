package com.example.sdp.controller;

import com.example.sdp.entity.Users;
import com.example.sdp.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminController {
//    @GetMapping("/viewUsers")
//    public String viewUsers() {
//        return "/admin/viewUsers";
//    }

    UserService userService;
    public AdminController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/viewUsers")
    public String viewUsers(Model model) {
        // Replace this with your logic to get user details
        List<Users> user = userService.getAllUsers(); // Assuming you have a method to get user details

        // Add the user object to the model
        model.addAttribute("users", user);

        return "/admin/viewUsers";
    }

    @GetMapping("/allowSellersPage")
    public String allowSellersPage()
    {
        return "/admin/allowSellersPage";
    }
}
