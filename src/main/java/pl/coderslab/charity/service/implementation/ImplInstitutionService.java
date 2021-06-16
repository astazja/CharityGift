package pl.coderslab.charity.service.implementation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

@Service
public class ImplInstitutionService implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public ImplInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }
}
