package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Donation;

public interface DonationService {
    Integer getQuantityOfBags();
    Long countDonations();
    void addDonation(Donation donation);
}
