package com.nitroagility.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.nitroagility.graphql.dao.entity.Vehicle;
import com.nitroagility.graphql.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Component
public class VehicleMutation implements GraphQLMutationResolver {

    @Autowired
    private VehicleService vehicleService;

    @PreAuthorize("hasRole('USER')")
    public Vehicle createVehicle(final String type, final String modelCode, final String brandName, final String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }
}
