package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Status;

public interface StatusService {
    void saveStatus(Status status);
    void changStatus(Long id);
}
