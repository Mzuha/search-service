package com.example.searchservice.service.mapper;

import com.example.searchservice.dto.PlaceDto;
import com.example.searchservice.model.Place;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapper {
    public Place toModel(PlaceDto placeDto) {
        Place place = new Place();
        place.setAddress(placeDto.getDisplayName());
        place.setLatitude(placeDto.getLat());
        place.setLongitude(placeDto.getLon());
        place.setPlaceClass(placeDto.getPlaceClass());
        place.setPlaceType(placeDto.getType());
        return place;
    }

    public PlaceDto toDto(Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.setDisplayName(place.getAddress());
        placeDto.setLat(place.getLatitude());
        placeDto.setLon(place.getLongitude());
        placeDto.setPlaceClass(place.getPlaceClass());
        placeDto.setType(place.getPlaceType());
        return placeDto;
    }
}
