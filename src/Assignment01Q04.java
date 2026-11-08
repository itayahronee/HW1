import java.util.Arrays;

public class Assignment01Q04 {
    public static int[] shiftArrayOneStep(int[] array, char direction) {
        if (direction == 'L') {
            int firstElement = array[0];
            for (int i = 0; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = firstElement;
        } 
        else {
            int lastElement = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
                array[i] = array[i - 1];
            }
            array[0] = lastElement;
        }
        return array;
    }

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        if (array.length == 0) {
            return array;
        }
        if (direction != 'L' && direction != 'R') {
            return array;
        }
        if (move < 0) {
            if (direction == 'L') {
                shiftArrayCyclic(array, -move, 'R');
            } else {
                shiftArrayCyclic(array, -move, 'L');
            }
        }
        int moveEffective = move % array.length;
        if (direction == 'L') {
            for (int i = 0; i < moveEffective; i++) {
                array = shiftArrayOneStep(array, 'L');
            }
        } else {
            for (int i = 0; i < moveEffective; i++) {
                array = shiftArrayOneStep(array, 'R');
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}