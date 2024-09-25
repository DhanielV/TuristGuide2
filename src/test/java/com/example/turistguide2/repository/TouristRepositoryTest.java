/*package com.example.turistguide2.repository;

import com.example.turistguide2.model.Tags;
import com.example.turistguide2.model.TouristAttraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TouristRepositoryTest {

    private TouristRepository touristRepository;

    @BeforeEach
    void setUp() {
        touristRepository = new TouristRepository();
        // Clear existing data to ensure test isolation
        touristRepository.getAllAttractions().clear();
        // Repopulate with initial data
        touristRepository.populateAttractions();
    }

    @Test
    void getRegions() {
        // Sunshine scenario: Get all regions
        List<String> regions = touristRepository.getRegions();
        assertNotNull(regions);
        assertEquals(3, regions.size());
        assertTrue(regions.containsAll(Arrays.asList("Europe", "Asia", "Antarctica")));
    }

    @Test
    void saveAttraction() {
        // Sunshine scenario: Save a new attraction
        TouristAttraction newAttraction = new TouristAttraction(
                "Grand Canyon",
                "A natural wonder in the USA",
                Arrays.asList(Tags.HOTSPOT, Tags.FRAGILE_ECOSYSTEM),
                "North America"
        );

        touristRepository.saveAttraction(newAttraction);
        TouristAttraction retrievedAttraction = touristRepository.getByName("Grand Canyon");
        assertNotNull(retrievedAttraction);
        assertEquals("Grand Canyon", retrievedAttraction.getName());
        assertEquals("North America", retrievedAttraction.getRegion());
    }

    @Test
    void saveAttraction_DuplicateName() {
        // Alternative scenario: Try to save an attraction with a name that already exists
        TouristAttraction duplicateAttraction = new TouristAttraction(
                "Venice",
                "Duplicate attraction",
                Arrays.asList(Tags.HOTSPOT),
                "Europe"
        );

        touristRepository.saveAttraction(duplicateAttraction);
        // Verify that the size of the attractions list hasn't increased
        List<TouristAttraction> attractions = touristRepository.getAllAttractions();
        long count = attractions.stream().filter(a -> a.getName().equalsIgnoreCase("Venice")).count();
        assertEquals(1, count, "Should not allow duplicate attraction names");
    }

    @Test
    void getAllAttractions() {
        // Sunshine scenario: Get all attractions
        List<TouristAttraction> attractions = touristRepository.getAllAttractions();
        assertNotNull(attractions);
        assertEquals(4, attractions.size());
    }

    @Test
    void getByName_Existing() {
        // Sunshine scenario: Get an attraction by existing name
        TouristAttraction attraction = touristRepository.getByName("Venice");
        assertNotNull(attraction);
        assertEquals("Venice", attraction.getName());
    }

    @Test
    void getByName_NonExisting() {
        // Alternative scenario: Get an attraction by a name that doesn't exist
        TouristAttraction attraction = touristRepository.getByName("Atlantis");
        assertNull(attraction, "Should return null for non-existing attraction");
    }

    @Test
    void updateAttraction() {
        // Sunshine scenario: Update an existing attraction
        TouristAttraction attractionToUpdate = touristRepository.getByName("Venice");
        assertNotNull(attractionToUpdate);

        attractionToUpdate.setDescription("An updated description");
        touristRepository.updateAttraction(attractionToUpdate);

        TouristAttraction updatedAttraction = touristRepository.getByName("Venice");
        assertEquals("An updated description", updatedAttraction.getDescription());
    }

    @Test
    void updateAttraction_ChangeNameToExisting() {
        // Alternative scenario: Update an attraction's name to one that already exists
        TouristAttraction attractionToUpdate = touristRepository.getByName("Venice");
        assertNotNull(attractionToUpdate);

        attractionToUpdate.setName("Barcelona");
        touristRepository.updateAttraction(attractionToUpdate);

        // Check that the name was not updated to prevent duplicates
        TouristAttraction updatedAttraction = touristRepository.getByName("Venice");
        assertNotNull(updatedAttraction, "Original attraction should still exist");
        assertEquals("Venice", updatedAttraction.getName(), "Name should not be changed to an existing name");
    }

    @Test
    void deleteAttraction() {
        // Sunshine scenario: Delete an existing attraction
        TouristAttraction attractionToDelete = touristRepository.getByName("Venice");
        assertNotNull(attractionToDelete);

        touristRepository.deleteAttraction(attractionToDelete);
        TouristAttraction deletedAttraction = touristRepository.getByName("Venice");
        assertNull(deletedAttraction, "Attraction should be deleted");
    }

    @Test
    void deleteAttraction_NonExisting() {
        // Alternative scenario: Attempt to delete a non-existing attraction
        TouristAttraction nonExistingAttraction = new TouristAttraction(
                "Atlantis",
                "Mythical city",
                Arrays.asList(Tags.COMMERCIALIZATION),
                "Unknown"
        );

        touristRepository.deleteAttraction(nonExistingAttraction);
        // Verify that the attractions list size remains unchanged
        List<TouristAttraction> attractions = touristRepository.getAllAttractions();
        assertEquals(4, attractions.size(), "Attractions list size should remain unchanged");
    }

    @Test
    void saveAttraction_InvalidData() {
        // Invalid test case: Save an attraction with invalid data (e.g., negative price)
        TouristAttraction invalidAttraction = new TouristAttraction(
                "Invalid Attraction",
                "12345", // Description only consisting of numbers
                Arrays.asList(Tags.HOTSPOT),
                "Europe"
        );

        // Assuming there's validation logic (not present in current code)
        // Here, we'll simply check if the attraction is added
        touristRepository.saveAttraction(invalidAttraction);
        TouristAttraction retrievedAttraction = touristRepository.getByName("Invalid Attraction");
        assertNotNull(retrievedAttraction, "Attraction with invalid data should be saved (no validation in code)");
    }
}*/
