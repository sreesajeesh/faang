package leetcode.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] arr = new int[]{10,2,-5};
        System.out.println(Arrays.toString(getAsteroids1(arr)));
    }

    public static int[] getAsteroids1(int[] asteroids){
        Stack<Integer> asteroidStack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroidStack.isEmpty()) {
                asteroidStack.push(asteroid);
            } else {
                int value = asteroidStack.peek();
                if (((value < 0 && asteroid < 0) || (value > 0 && asteroid > 0))){
                    asteroidStack.push(asteroid);
                } else if ((value < 0 && asteroid > 0)) {
                    asteroidStack.push(asteroid);
                } else if (value > 0 && asteroid < 0) {
                    while (Math.abs(asteroid) > value && !asteroidStack.isEmpty()) {
                        asteroidStack.pop();
                        if(!asteroidStack.isEmpty())
                            value = asteroidStack.peek();
                    }
                    if (value + asteroid == 0) {
                        if (!asteroidStack.isEmpty()) {
                            asteroidStack.pop();
                        }
                    }
                }
            }
        }
        return asteroidStack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getAsteroids(int[] asteroids) {
        Stack<Integer> asteroidStack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroidStack.isEmpty()) {
                asteroidStack.push(asteroids[i]);
            } else {
                Integer value = asteroidStack.peek();
                if (asteroids[i] < 0) {
                    if (value > 0 && value < Math.abs(asteroids[i])) {
                        while (Math.abs(value) < Math.abs(asteroids[i]) && !asteroidStack.isEmpty()) {
                            asteroidStack.pop();
                            if (!asteroidStack.isEmpty())
                                value = asteroidStack.peek();
                        }
                        if (!asteroidStack.isEmpty())
                            value = asteroidStack.peek();
                        if (value < Math.abs(asteroids[i]))
                            asteroidStack.push(asteroids[i]);
                    } else if (value > 0 && value == Math.abs(asteroids[i])) {
                        asteroidStack.pop();
                    } else if (value < 0) {
                        asteroidStack.push(asteroids[i]);
                    }
                } else {
                    asteroidStack.push(asteroids[i]);
                }
            }
        }
        return asteroidStack.stream().mapToInt(Integer::intValue).toArray();
    }
}
