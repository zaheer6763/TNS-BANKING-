package com.avn.placement.service;

import com.avn.placement.entity.Placement;
import java.util.List;

public interface PlacementService {

    Placement savePlacement(Placement placement);

    Placement getPlacementById(Long id);

    List<Placement> getAllPlacements();

    void deletePlacement(Long id);

    boolean existsById(Long id);
}
