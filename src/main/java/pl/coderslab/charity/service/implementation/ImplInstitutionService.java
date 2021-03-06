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

    @Override
    public Institution getInstitution(Long id) {
        return institutionRepository.findInstitutionById(id);
    }

    @Override
    public void addInstitution(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public void updateInstitution(Institution institution) {
        institutionRepository.save(institution);
    }

    @Override
    public void removeInstitution(Long id) {
        institutionRepository.deleteById(id);
    }
}
