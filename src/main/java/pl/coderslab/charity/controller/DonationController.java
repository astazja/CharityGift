package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @GetMapping("/add")
    public String addDonation(Model model) {
        model.addAttribute("categories", categoryService.allCategories());
        model.addAttribute("institutions", institutionService.allInstitutions());
        model.addAttribute("donation", new Donation());
        return "form";
    }
    @PostMapping("/add")
    public String saveDonation(@Valid Donation donation, BindingResult result, Model model) {
        if(result.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            result.getFieldErrors().forEach(error -> {
                stringBuilder.append(error.getDefaultMessage()).append("<br>");
            });
            model.addAttribute("errorMessage", "Nie udało się zapisać formularza.<br>Formularz zawierał poniższe błędy:<br>" + stringBuilder.toString());
            return "form";
        }
        donationService.addDonation(donation);
        return "form-confirmation";
    }
}
