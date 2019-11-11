package com.nitroagility.graphql.dao.entity;

public class VehicleFactory {
    public static Vehicle createSampleVehicle()
    {
        Vehicle sample=new Vehicle();
        sample.setBrandName("Ferrari");
        sample.setModelCode("Testa Rossa");
        sample.setType("Fast Car");
        sample.setId(1);
        return sample;
    }
}
