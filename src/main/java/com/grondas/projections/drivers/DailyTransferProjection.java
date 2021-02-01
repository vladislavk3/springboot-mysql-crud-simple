package com.grondas.projections.drivers;

public interface DailyTransferProjection {

    String getOrigin();
    String getDestination();
    String getClient();
}
