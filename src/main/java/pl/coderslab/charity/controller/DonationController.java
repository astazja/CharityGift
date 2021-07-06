package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Status;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.StatusService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final StatusService statusService;

    @GetMapping("/add")
    public String addDonation(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("institutions", institutionService.allInstitutions());
        model.addAttribute("donation", new Donation());
        User entityUser = customUser.getUser();
        model.addAttribute("user", entityUser);
        return "form";
    }
    @PostMapping("/add")
    public String saveDonation(@Valid Donation donation, BindingResult result, Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        if(result.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            result.getFieldErrors().forEach(error -> {
                stringBuilder.append(error.getDefaultMessage()).append("<br>");
            });
            model.addAttribute("errorMessage", "Nie udało się zapisać formularza.<br>Formularz zawierał poniższe błędy:<br>" + stringBuilder.toString());
            return "form";
        }
        donation.setUser(currentUser.getUser());
        Status status = new Status();
        status.setStatus(0);
        donation.setStatus(status);
        statusService.saveStatus(status);
        donationService.addDonation(donation);
        return "form-confirmation";
    }
}
