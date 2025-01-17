package day16;

import java.util.PriorityQueue;

public class DestroyingAsteroids {
    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {5,10,2,1};
        System.out.println(new DestroyingAsteroids().asteroidsDestroyed(mass,asteroids));
    }
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int asteroid : asteroids) {
            pq.offer(asteroid);
        }

        long currentMass = mass;

        while(!pq.isEmpty()) {
            if(currentMass >= pq.peek()) {
                currentMass += pq.poll();
            } else {
                return false;
            }
        }

        return true;
    }
}
