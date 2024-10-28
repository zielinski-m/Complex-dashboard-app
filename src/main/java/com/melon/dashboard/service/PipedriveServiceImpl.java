package com.melon.dashboard.service;

import com.melon.dashboard.config.PipedriveConfig;
import com.melon.dashboard.model.PipedriveResponse;
import com.melon.dashboard.model.PipedriveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PipedriveServiceImpl implements PipedriveService {

    private final RestTemplate restTemplate;
    private final String apiPipeToken;

    @Autowired
    public PipedriveServiceImpl(RestTemplate restTemplate, PipedriveConfig pipedriveConfig) {
        this.restTemplate = restTemplate;
        this.apiPipeToken = pipedriveConfig.pipedriveApiToken();
    }

    @Override
    public List<PipedriveUser> getUsers() {
        String url = "https://api.pipedrive.com/v1/users?api_token=" + apiPipeToken;

        try {
            ResponseEntity<PipedriveResponse> responseEntity = restTemplate.getForEntity(url, PipedriveResponse.class);
            if (responseEntity.getStatusCode().is2xxSuccessful() && responseEntity.getBody() != null) {
                PipedriveResponse response = responseEntity.getBody();
                return response.getData();
            } else {
                throw new RuntimeException("Bad response from API Pipedrive || no data" + responseEntity.getStatusCode().toString());
            }
        } catch (RestClientException e) {
            throw new RuntimeException("API connection error " + e.getMessage(), e);
        }
    }
}
