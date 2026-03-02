package com.avn.placement.service;

import com.avn.placement.entity.Placement;
import com.avn.placement.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementServiceImpl implements PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    @Override
    public Placement savePlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public Placement getPlacementById(Long id) {
        return placementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    @Override
    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return placementRepository.existsById(id);
    }
}
