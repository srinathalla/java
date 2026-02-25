package com.lld.elevator;

import java.util.List;

public class ElevatorController {

    List<Elevator> elevators;
    SchedulingStrategy scheduler;

    ElevatorController(List<Elevator> elevators, SchedulingStrategy scheduler) {
        this.elevators = elevators;
        this.scheduler = scheduler;
    }

    void handleExternalRequest(FloorRequest req) {
       Elevator elevator = scheduler.assignElevator(this.elevators, req);
       elevator.addRequest(req.floor);
    }

    void handleInternalRequest(int elevatorId, InternalRequest req) {
        elevators.get(elevatorId).addRequest(req.floor);
    }

    void step() {
        // time tick: move all elevators
        for (Elevator e : elevators) {
            e.move();
        }
    }
}
