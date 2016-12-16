package com.betomorrow.stubery.controllers;

import com.betomorrow.stubery.applications.domain.Application;
import com.betomorrow.stubery.applications.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {

    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/applications")
    public List<Application> list() {
        return applicationService.listAll();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/applications")
    public Application create(Application application) {
        return applicationService.add(application);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/applications/{id}")
    public Application read(@PathVariable("id") String id) {
        return applicationService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/applications")
    public Application update(Application application) {
        return applicationService.update(application);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/applications/{id}")
    public Application delete(String id) {
        return applicationService.remove(id);
    }

}
