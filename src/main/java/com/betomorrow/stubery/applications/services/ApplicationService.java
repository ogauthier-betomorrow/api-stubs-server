package com.betomorrow.stubery.applications.services;

import com.betomorrow.stubery.applications.domain.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> listAll();
    Application get(String id);
    Application add(Application application);
    Application update(Application application);
    Application remove(String id);


}
