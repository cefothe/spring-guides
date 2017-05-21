package com.cefothe.service;

import com.cefothe.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * Created by cefothe on 22.05.17.
 */
@Service
public class GitHubLookupService {

    private static final Logger LOG = LoggerFactory.getLogger(GitHubLookupService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public Future<User> findUser(String username) throws InterruptedException {
        LOG.info("Looking up {}", username);
        String url = String.format("https://api.github.com/users/%s", username);
        User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return new AsyncResult<>(results);
    }
}
