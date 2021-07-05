package pl.coderslab.charity.service.implementation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DonationService;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
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

    @Override
    public List<Donation> userDonations(User user) {
        return donationRepository.findAllByUser(user);
    }
}
