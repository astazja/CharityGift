package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Institution;

import java.util.List;

public interface InstitutionService {
    List<Institution> allInstitutions();
    Institution getInstitution(Long id);
    void addInstitution(Institution institution);
    void updateInstitution(Institution institution);
    void removeInstitution(Long id);

}
