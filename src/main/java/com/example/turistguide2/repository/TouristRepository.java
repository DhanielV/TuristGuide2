package com.example.turistguide2.repository;

import com.example.turistguide2.model.Tags;
import com.example.turistguide2.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class TouristRepository {
    private final List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        populateAttractions();
    }

    public void populateAttractions() {
        attractions.add(new TouristAttraction(
                "Venice",
                "Cruises, overcrowding, environmental damage, and anti-tourism sentiments",
                Arrays.asList(Tags.CRUISES, Tags.OVERCROWDED, Tags.ENVIRONMENT, Tags.ANT_TOURISM, Tags.HOTSPOT),
                "Europe"
        ));
        attractions.add(new TouristAttraction(
                "Barcelona",
                "AIRBNB, overcrowding and anti-tourism sentiments",
                Arrays.asList(Tags.COMMERCIALIZATION, Tags.OVERCROWDED, Tags.ANT_TOURISM, Tags.HOTSPOT),
                "Europe"
        ));
        attractions.add(new TouristAttraction(
                "Mount Everest",
                "Pollution, and environmental damage from climbers and expeditions.",
                Arrays.asList(Tags.POLLUTION, Tags.ENVIRONMENT, Tags.FRAGILE_ECOSYSTEM),
                "Asia"
        ));
        attractions.add(new TouristAttraction(
                "Antarctica",
                "Cruises, environmental damage, pollution, and fragile ecosystems",
                Arrays.asList(Tags.CRUISES, Tags.ENVIRONMENT, Tags.POLLUTION, Tags.FRAGILE_ECOSYSTEM),
                "Antarctica"
        ));

    }

    public List<String> getRegions() {
        List<String> regions = new ArrayList<>();
        Collections.addAll(regions, "Europe", "Asia", "Antarctica");
        return regions;
    }


    //CRUD
    //Create
    public void saveAttraction(TouristAttraction touristAttraction) {
        attractions.add(touristAttraction);
    }

    //Read
    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public TouristAttraction getByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    //Update
    public void updateAttraction(TouristAttraction updatedAttraction) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(updatedAttraction.getName())) {
                attractions.set(i, updatedAttraction);

            }
        }
    }

    //Delete
    public void deleteAttraction(TouristAttraction deletedAttraction) {
        attractions.removeIf(attraction -> attraction.getName().equalsIgnoreCase(deletedAttraction.getName()));
    }
}

