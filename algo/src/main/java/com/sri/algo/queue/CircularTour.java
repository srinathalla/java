package com.sri.algo.queue;

/**
 * Suppose there is a circle. There are n petrol pumps on that circle. You will
 * be given two sets of data.
 * 
 * 1. The amount of petrol that every petrol pump has.
 * 2. Distance from that petrol pump to the next petrol pump.
 * 
 * Your task is to complete the function tour which returns an integer denoting
 * the first point from where a truck will be able to complete the circle (The
 * truck will stop at each petrol pump and it has infinite capacity).
 * 
 * Example (To be used only for expected output)
 *  Input 
 *  1 
 *  4 
 *  4 6 6 5 7 3 4 5
 *  
 *  Output 1
 *
 */
public class CircularTour {

	private static class PetrolPump {
		int petrol;
		int dist;

		public PetrolPump(int petrol, int dist) {
			this.petrol = petrol;
			this.dist = dist;
		}
	}

	int tour(int petrol[], int distance[]) {

		PetrolPump[] pumps = new PetrolPump[petrol.length];

		for (int i = 0; i < petrol.length; i++) {
			pumps[i] = new PetrolPump(petrol[i], distance[i]);
		}

		return tour(pumps, pumps.length);

	}

	public static int tour(PetrolPump[] pumps, int n) {
		
		if (n == 0)
		{
			return -1;
		}
		int start = 0;
		int end = 1;

		// Enque first element.
		int curr_petrol = pumps[start].petrol - pumps[start].dist;

		while (end != start || curr_petrol < 0) {

			// Deque elements till curr_petrol is positive.
			while (curr_petrol < 0 && start != end) {
				curr_petrol -= (pumps[start].petrol - pumps[start].dist);
				start = (start + 1) % n;

				if (start == 0) {
					return -1;
				}
			}

			curr_petrol = curr_petrol + pumps[end].petrol - pumps[end].dist;
			end = (end + 1) % n;
		}

		return start;
	}

	// Driver program to test above functions
	public static void main(String[] args) {

		PetrolPump[] arr = { new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3) };

		int start = tour(arr, arr.length);

		System.out.println(start == -1 ? "No Solution" : "Start = " + start);

	}

}
