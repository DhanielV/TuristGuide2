package com.example.turistguide2.controller;

import com.example.turistguide2.model.Tags;
import com.example.turistguide2.model.TouristAttraction;
import com.example.turistguide2.service.TouristService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TouristController.class)
class TouristControllerTest {

    private TouristAttraction touristAttraction = new TouristAttraction();

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private TouristService touristService;

    @BeforeEach
    public void setUp(){
        // Initialize the TouristAttraction object with necessary data
        touristAttraction = new TouristAttraction();
        touristAttraction.setName("Venice");
        touristAttraction.setTags(Arrays.asList(Tags.CRUISES, Tags.OVERCROWDED));
        // Set other fields if necessary

        // Mock the service method to return the initialized attraction
        when(touristService.getByName("Venice")).thenReturn(touristAttraction);
    }



    @Test
    void getAllAttractions() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("attractionList"));
    }

    @Test
    void showTags() throws Exception{


        mockMvc.perform(get("/attractions/Venice/tags"))
                .andExpect(status().isOk())
                .andExpect(view().name("tags"))
                .andExpect(content().string(containsString("Venice Tags:")));
    }

    @Test
    void addForm() throws Exception{
        mockMvc.perform(get("/attractions/add"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("touristAttraction"))
                .andExpect(model().attributeExists("regions"))
                .andExpect(model().attributeExists("tags"))
                .andExpect(view().name("add-form"));
    }

    @Test
    void saveAttraction() throws Exception {
        mockMvc.perform(post("/attractions/save").sessionAttr("touristAttraction", this.touristAttraction))                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/attractions"));

    }

    @Test
    void editForm() {
    }

    @Test
    void updateAttraction() {
    }

    @Test
    void deleteAttraction() {
    }
}