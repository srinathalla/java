package com.lld.elevator;

import java.util.List;

public class NearestElevatorScheduler  implements SchedulingStrategy {

    public Elevator assignElevator(List<Elevator> elevators, FloorRequest request) {
        Elevator best = null;
        int bestScore = Integer.MAX_VALUE;
        int floor = request.floor;
        Direction requestedDir  = request.direction;

        for (Elevator e : elevators) {
            int score = Integer.MAX_VALUE;

            // Rule 1: Idle elevator (highest priority)
            if (e.getDirection() == Direction.IDLE) {
                score = Math.abs(e.getCurrentFloor() - floor) * 1;
            }

            // Rule 2: Moving in same direction and will pass the floor
            else if (e.getDirection() == requestedDir) {
                if ((requestedDir == Direction.UP && e.getCurrentFloor() <= floor) ||
                        (requestedDir == Direction.DOWN && e.getCurrentFloor() >= floor)) {
                    score = Math.abs(e.getCurrentFloor() - floor) * 2;
                }
            }

            // Rule 3: Fallback to nearest elevator
            if (score == Integer.MAX_VALUE) {
                score = Math.abs(e.getCurrentFloor() - floor) * 3;
            }

            // Choose best with tie-breaking
            if (score < bestScore) {
                bestScore = score;
                best = e;
            } else if (score == bestScore && best != null) {
                // 🔹 Tie-breaking rules:
                // 1. Elevator with fewer passengers
                if (e.getPassengerCount() < best.getPassengerCount()) {
                    best = e;
                }
                // 2. If still equal, prefer elevator already moving in requested direction
                else if (e.getDirection() == requestedDir && best.getDirection() != requestedDir) {
                    best = e;
                }
                // 3. As final fallback, pick the one with smaller ID (deterministic choice)
                else if (e.getId() < best.getId()) {
                    best = e;
                }
            }
        }

        return best;
    }
}
