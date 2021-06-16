package pl.coderslab.charity.service.implementation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DonationService;

@Service
public class ImplDonationService implements DonationService {

    public final DonationRepository donationRepository;

    public ImplDonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }
}
