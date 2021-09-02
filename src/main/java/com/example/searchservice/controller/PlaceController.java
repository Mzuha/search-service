package com.example.searchservice.controller;

import com.example.searchservice.dto.PlaceDto;
import com.example.searchservice.model.Place;
import com.example.searchservice.service.NominatimService;
import com.example.searchservice.service.PlaceService;
import com.example.searchservice.service.mapper.PlaceMapper;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private final NominatimService nominatimService;
    private final PlaceService placeService;
    private final PlaceMapper placeMapper;

    public PlaceController(NominatimService nominatimService,
                           PlaceService placeService,
                           PlaceMapper placeMapper) {
        this.nominatimService = nominatimService;
        this.placeService = placeService;
        this.placeMapper = placeMapper;
    }

    @GetMapping("/by-address")
    public List<PlaceDto> getByAddress(@RequestParam String address) {
        List<PlaceDto> placeDtos = nominatimService.getPlacesByAddress(address);
        List<Place> placesByAddress = placeDtos.stream()
                .map(placeMapper::toModel)
                .collect(Collectors.toList());
        placeService.saveAll(placesByAddress);
        return placeDtos;
    }

    @GetMapping("/by-coordinates")
    public PlaceDto getByCoordinates(@RequestParam String latitude,
                                     @RequestParam String longitude) {
        Place place = placeService.getByCoordinates(latitude, longitude)
                .orElseThrow(() ->
                        new NoSuchElementException("Cant found address with this coordinates"));
        return placeMapper.toDto(place);
    }
}
