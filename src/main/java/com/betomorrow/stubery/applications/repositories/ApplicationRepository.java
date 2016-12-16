package com.betomorrow.stubery.applications.repositories;

import com.betomorrow.stubery.applications.domain.Application;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApplicationRepository extends MongoRepository<Application, String> {


}
