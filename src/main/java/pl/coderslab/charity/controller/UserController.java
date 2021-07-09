package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.stylesheets.LinkStyle;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final DonationService donationService;

    @GetMapping("/profile")
    public String showProfile(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        Boolean isAdmin = customUser.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(a->a.equals("ROLE_ADMIN"));
        if(isAdmin) {
            return "redirect:/admin";
        }
        model.addAttribute("user", entityUser);
        return "user/profile";
    }

    @GetMapping("/donation")
    public String showDonation(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        List<Donation> donationList = donationService.userDonations(currentUser.getUser());
        donationList.sort(Comparator.comparing(Donation::getStatus).reversed()
                .thenComparing(Donation::getPickUpDate)
                .thenComparing(Donation::getCreated));
        model.addAttribute("donations", donationList);
        return "user/donation";
    }

    @GetMapping("/edit")
    public String editProfile(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("user", userService.getUserById(customUser.getUser().getId()));
        return "user/edit";
    }
    @PostMapping("/edit")
    public String updateProfile(@Valid User user, BindingResult result,
                                @RequestParam String password,
                                @RequestParam String repeat,
                                @AuthenticationPrincipal CurrentUser customUser) {
        if(!result.hasErrors()) {
            userService.editUser(user, password, repeat);
            customUser.setUser(user);
            return "redirect:/user/profile";

        }
        return "user/edit";
    }
}
