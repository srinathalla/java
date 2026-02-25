package com.lld.elevator;

import java.util.List;

public interface SchedulingStrategy {

    Elevator assignElevator(List<Elevator> elevators, FloorRequest request);
}
