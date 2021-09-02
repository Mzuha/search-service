package com.example.searchservice.service.impl;

import com.example.searchservice.model.Place;
import com.example.searchservice.repository.PlaceRepository;
import com.example.searchservice.service.PlaceService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceServiceImpl(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public Optional<Place> getByCoordinates(String latitude, String longitude) {
        return placeRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

    @Override
    public void saveAll(List<Place> places) {
        placeRepository.saveAll(places);
    }
}
