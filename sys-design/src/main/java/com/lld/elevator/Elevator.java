package com.lld.elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {


    int id;
   int currentFloor;
   Direction direction;
   DoorStatus doorStatus;
   Queue<Integer> requests;
   int passengerCount;

    Elevator(int id, int startFloor) {
        this.id = id;
        this.currentFloor = startFloor;
        this.direction = Direction.IDLE;
        this.doorStatus = DoorStatus.CLOSED;
        this.requests = new LinkedList<>();
    }

    void addRequest(int floor) {
        requests.add(floor);
    }

    void move() {
       if(requests.isEmpty())
       {
           this.direction = Direction.IDLE;
           return;
       }
       int request = requests.peek();
       if(currentFloor < request)
       {
           this.direction = Direction.UP;
           this.currentFloor++;
       }
        else if(currentFloor > request)
        {
            this.direction = Direction.DOWN;
            this.currentFloor--;
        }
        else {
            this.openDoor();;
            this.requests.poll();
            this.closeDoor();
       }
    }

    void openDoor() {
        doorStatus = DoorStatus.OPEN;
        System.out.println("Elevator " + id + " opening doors at floor " + currentFloor);
    }

    void closeDoor() {
        doorStatus = DoorStatus.CLOSED;
        System.out.println("Elevator " + id + " closing doors at floor " + currentFloor);
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }

    public Queue<Integer> getRequests() {
        return requests;
    }
    public int getPassengerCount() {
        return passengerCount;
    }

    public static void main(String[] args) {
        // Create elevators
        Elevator e1 = new Elevator(1, 0); // id=1, starts at floor 0
        Elevator e2 = new Elevator(2, 5); // id=2, starts at floor 5

        // Add elevators to controller
        List<Elevator> elevators = new ArrayList<>();
        elevators.add(e1);
        elevators.add(e2);

        ElevatorController controller =
                new ElevatorController(elevators, new NearestElevatorScheduler());

        // External requests (people pressing buttons outside)
        controller.handleExternalRequest(new FloorRequest(3, Direction.UP));  // someone at floor 3 going UP
        controller.handleExternalRequest(new FloorRequest(7, Direction.DOWN)); // someone at floor 7 going DOWN

        // Internal request (person inside elevator 1 presses button for floor 6)
        controller.handleInternalRequest(1, new InternalRequest(6));

        // Simulate time steps
        for (int t = 0; t < 10; t++) {
            System.out.println("\n=== Time step " + t + " ===");
            controller.step();

            for (Elevator e : elevators) {
                System.out.println("Elevator " + e.id +
                        " at floor " + e.currentFloor +
                        " going " + e.direction +
                        " | Queue: " + e.requests);
            }
        }
    }
}

