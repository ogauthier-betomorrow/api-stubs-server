package com.betomorrow.stubery.applications.services;

import com.betomorrow.stubery.applications.domain.Application;
import com.betomorrow.stubery.applications.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultApplicationService implements ApplicationService {

    private ApplicationRepository repository;

    @Autowired
    public DefaultApplicationService(ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Application> listAll() {
        return repository.findAll();
    }

    @Override
    public Application get(String id) {
        return repository.findOne(id);
    }

    @Override
    public Application add(Application application) {
        return repository.save(application);
    }

    @Override
    public Application update(Application application) {
        Application saved = getApplication(application.getId());
        saved.updateWith(application);
        return repository.save(saved);
    }

    @Override
    public Application remove(String id) {
        Application saved = getApplication(id);
        repository.delete(saved);
        return saved;
    }

    private Application getApplication(String id) {
        Application saved = repository.findOne(id);
        if (saved == null) {
            throw  new IllegalArgumentException("Invalid application id : " + id);
        }
        return saved;
    }

}
