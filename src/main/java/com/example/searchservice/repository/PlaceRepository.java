package com.example.searchservice.repository;

import com.example.searchservice.model.Place;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByLatitudeAndLongitude(String latitude, String longitude);
}
