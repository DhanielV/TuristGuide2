package com.example.turistguide2.service;

import com.example.turistguide2.model.TouristAttraction;
import com.example.turistguide2.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }


    //CRUD
    //Create
    public void saveAttraction(TouristAttraction touristAttraction) {
        touristRepository.saveAttraction(touristAttraction);
    }

    //Read
    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public List<String> getRegions(){
        return touristRepository.getRegions();
    }

    public TouristAttraction getByName(String name) {
        return touristRepository.getByName(name);
    }


    //Update
    public void updateAttraction(TouristAttraction updatedAttraction) {
        touristRepository.updateAttraction(updatedAttraction);
    }

    //Delete
    public void deleteAttraction(TouristAttraction deletedAttraction) {
        touristRepository.deleteAttraction(deletedAttraction);
    }
}
