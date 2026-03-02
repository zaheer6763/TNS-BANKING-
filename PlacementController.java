package com.avn.placement.controller;

import com.avn.placement.entity.Placement;
import com.avn.placement.service.PlacementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placements")
@CrossOrigin(origins = "*")
public class PlacementController {

    private final PlacementService placementService;

    public PlacementController(PlacementService placementService) {
        this.placementService = placementService;
    }

    @PostMapping("/add")
    public ResponseEntity<Placement> addPlacement(@RequestBody Placement placement) {
        return new ResponseEntity<>(placementService.savePlacement(placement), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Placement> getPlacementById(@PathVariable Long id) {
        Placement placement = placementService.getPlacementById(id);
        if (placement == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(placement, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Placement>> getAllPlacements() {
        return new ResponseEntity<>(placementService.getAllPlacements(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Placement> updatePlacement(
            @PathVariable Long id,
            @RequestBody Placement placement) {

        Placement existing = placementService.getPlacementById(id);
        if (existing == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        existing.setName(placement.getName());
        existing.setQualification(placement.getQualification());
        existing.setYear(placement.getYear());
        existing.setDate(placement.getDate());
        existing.setCollege(placement.getCollege());

        return new ResponseEntity<>(placementService.savePlacement(existing), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlacement(@PathVariable Long id) {

        if (!placementService.existsById(id))
            return new ResponseEntity<>("Placement not found", HttpStatus.NOT_FOUND);

        placementService.deletePlacement(id);
        return new ResponseEntity<>("Placement deleted successfully", HttpStatus.OK);
    }
}
