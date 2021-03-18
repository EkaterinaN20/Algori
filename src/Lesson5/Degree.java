package Lesson5;

public class Degree {
    public static void main(String[] args) {

        System.out.println(degree(0, 0));
        System.out.println(degree(1, 0));
        System.out.println(degree(5, 0));
        System.out.println(degree(-6, 2));
        System.out.println(degree(6, 5));
        System.out.println(degree(-6, -5));
        System.out.println(degree(0, -4));

    }

    private static double degree(int x, int degree) {
        if(x == 0) {
            if (degree > 0) return 0;
            else if (degree ==0 ) return 1;
            else throw new IllegalArgumentException("Illegal rank" + degree + ", must be >= 0");
        }
        if (degree == 0) return 1;
        if (degree < 0) return 1/(x * recDegree(x, -degree - 1));
        return x * recDegree(x, degree - 1);
    }

    private static double recDegree(int x, int degree) {
        if (degree == 0) return 1;
        return x * recDegree(x, degree - 1);
    }


}
