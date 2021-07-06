package pl.coderslab.charity.service.implementation;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Status;
import pl.coderslab.charity.repository.StatusRepository;
import pl.coderslab.charity.service.StatusService;

@Service
public class ImplStatusService implements StatusService {
    private final StatusRepository statusRepository;

    public ImplStatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public void saveStatus(Status status) {
        statusRepository.save(status);
    }

    @Override
    public void changStatus(Long id) {
        Status status = statusRepository.findById(id).get();
        status.setStatus(1);
        statusRepository.save(status);
    }
}
