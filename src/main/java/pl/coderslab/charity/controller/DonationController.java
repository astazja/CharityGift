package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

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
    public String saveDonation(Donation donation) {
        donationService.addDonation(donation);
        return "form-confirmation";
    }
}
