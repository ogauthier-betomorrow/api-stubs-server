package com.betomorrow.stubery.controller;

import com.betomorrow.stubery.applications.domain.Application;
import com.betomorrow.stubery.applications.services.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ApplicationService applicationService;

    @Test
    public void testListApplications() throws Exception {
        Application app1 = new Application("123456789", "sample1", "sample1Ctx", null);
        Application app2 = new Application("987654321", "sample2", "sample2Ctx", null);

        given(applicationService.listAll()).willReturn(Arrays.asList(app1, app2));

        ResponseEntity<Application[]> result = restTemplate.getForEntity("/applications", Application[].class);

        assertThat(result.getBody()).hasSize(2).containsExactly(app1, app2);
    }


}
