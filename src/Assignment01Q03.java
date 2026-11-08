public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        System.out.println("The first " + x + " Fibonacci numbers are:");
        int firstNum =1;
        int secondNum =1;
        int temp;
        int numOdd = 0;
        for (int i = 0; i < x; i++) {
            System.out.print(firstNum);
            if (firstNum%2==1){
                numOdd++;
            }
            temp = secondNum;
            secondNum = temp + firstNum;
            firstNum = temp;
            
            if (i < x - 1) 
                System.out.print(" "); 
            
        }
        System.out.println();
        
     
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
