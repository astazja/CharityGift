package pl.coderslab.charity.service.implementation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DonationService;

@Service
public class ImplDonationService implements DonationService {

    public final DonationRepository donationRepository;

    public ImplDonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Integer getQuantityOfBags() {
        return donationRepository.getAllBags();
    }

    @Override
    public Long countDonations() {
        return donationRepository.count();
    }

    @Override
    public void addDonation(Donation donation) {
        donationRepository.save(donation);
    }
}
