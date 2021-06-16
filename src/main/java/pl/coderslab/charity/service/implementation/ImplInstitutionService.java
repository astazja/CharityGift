package pl.coderslab.charity.service.implementation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Service
public class ImplInstitutionService implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public ImplInstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> allInstitutions() {
        return institutionRepository.findAll();
    }
}
