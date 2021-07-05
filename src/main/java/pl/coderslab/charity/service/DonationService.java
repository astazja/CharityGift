package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;

import java.util.List;

public interface DonationService {
    Integer getQuantityOfBags();
    Long countDonations();
    void addDonation(Donation donation);
    List<Donation> userDonations(User user);
}
