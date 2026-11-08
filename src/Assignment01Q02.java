public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            if (i % 2 == 0) {
                approxPi += 4.0 / (2 * i + 1);
            } else {
                approxPi -= 4.0 / (2 * i + 1);
            }
        }
  
        
        System.out.println(approxPi + " " + actualPi);
    }
}
