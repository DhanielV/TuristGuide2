package com.example.turistguide2.controller;

import com.example.turistguide2.model.Tags;
import com.example.turistguide2.model.TouristAttraction;
import com.example.turistguide2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")

public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }

    @GetMapping("")
    public String getAllAttractions(Model model){
        List<TouristAttraction> touristAttractions = touristService.getAllAttractions();
        model.addAttribute("attractions", touristAttractions);
        return "attractionList";

    }

    @GetMapping("/{name}/tags")
    public String showTags(@PathVariable String name, Model model){
        TouristAttraction touristAttraction = touristService.getByName(name);
        model.addAttribute("attraction", touristAttraction);
        return "tags";

    }

    @GetMapping("/add")
    public String addForm(Model model){
        TouristAttraction touristAttraction = new TouristAttraction();
        model.addAttribute("touristAttraction", touristAttraction);
        model.addAttribute("regions", touristService.getRegions());
        model.addAttribute("tags", Tags.values());
        return "add-form";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction touristAttraction, Model model){
        touristService.saveAttraction(touristAttraction);
        model.addAttribute("attraction", touristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("{name}/edit")
    public String editForm(@PathVariable String name, Model model){
        TouristAttraction touristAttraction = touristService.getByName(name);
        model.addAttribute("touristAttraction", touristAttraction);
        model.addAttribute("regions", touristService.getRegions());
        model.addAttribute("tags", Tags.values());
        return "edit-form";
    }

    @PostMapping("/update")
    public String updateAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.updateAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @PostMapping("{name}/delete")
    public String deleteAttraction(@PathVariable String name){
        TouristAttraction touristAttraction = touristService.getByName(name);
        touristService.deleteAttraction(touristAttraction);
        return "redirect:/attractions";
    }
}
