package com.nitroagility.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nitroagility.graphql.service.VehicleService;
import com.nitroagility.graphql.dao.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehicleQuery implements GraphQLQueryResolver {

    @Autowired
    private VehicleService vehicleService;

    @PreAuthorize("hasRole('USER')")
    public List<Vehicle> getVehicles(final int count) {
        return this.vehicleService.getAllVehicles(count);
    }

    @PreAuthorize("hasRole('USER')")
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleService.getVehicle(id);
    }
}
