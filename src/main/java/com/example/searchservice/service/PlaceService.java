package com.example.searchservice.service;

import com.example.searchservice.model.Place;
import java.util.List;
import java.util.Optional;

public interface PlaceService {
    Optional<Place> getByCoordinates(String latitude, String longitude);

    void saveAll(List<Place> places);
}
