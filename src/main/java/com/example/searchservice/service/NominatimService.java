package com.example.searchservice.service;

import com.example.searchservice.dto.PlaceDto;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NominatimService {
    private static final String NOMINATIM_BASE_ENDPOINT =
            "https://nominatim.openstreetmap.org";

    public List<PlaceDto> getPlacesByAddress(String address) {
        String request = NOMINATIM_BASE_ENDPOINT + "/search?format=json&q=" + address;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<PlaceDto>> placeResponse =
                restTemplate.exchange(request, HttpMethod.GET, null,
                        new ParameterizedTypeReference<>() {
                        });
        return placeResponse.getBody();
    }
}
