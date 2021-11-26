package multmatrius;

import java.util.Scanner;

public class MultMatrius {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
        
    }
    
    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueix el número de columnes de la primera matriu");
        System.out.println("I el número de files de la segona matriu (seràn iguals)");
        int colAFilB = input.nextInt();
        input.nextLine();
        System.out.println("Introdueix el número de files de la primera matriu");
        int filA = input.nextInt();
        input.nextLine();
        System.out.println("Introdueix el número de columnes de la segona matriu");
        int colB = input.nextInt();
        input.nextLine();
        System.out.println("Pitja 1 per a multiplicar amb múltiples threads");
        System.out.println("Pitja 2 per a multiplicar amb un únic thread");
        int mode = input.nextInt();
        input.nextLine();
        Matriu a = new Matriu(filA, colAFilB);
        Matriu b = new Matriu (colAFilB, colB);
        Matriu c ;
        long start;
        long tempsTotal;
        switch (mode) {
            case 1: 
                start = System.currentTimeMillis();
                c = a.threadMult(b);
                tempsTotal = System.currentTimeMillis() - start;
                System.out.println("La multiplicació amb un únic thread ha tardat: " + String.valueOf(tempsTotal) + " ms");
                System.out.println("Pitja enter per a mostrar la matriu resultant");
                input.nextLine();
                c.mostrar();
                
                break;
            case 2:
                start = System.currentTimeMillis();
                c = a.noThreadMult(b);
                tempsTotal = System.currentTimeMillis() - start;
                System.out.println("La multiplicació amb un únic thread ha tardat: " + String.valueOf(tempsTotal) + " ms");
                System.out.println("Pitja enter per a mostrar la matriu resultant");
                input.nextLine();
                c.mostrar();
                break;
            default:
                System.out.println("Error, no has introduït ni 1 ni 2");
            break;
        }
        
        
        
    }
    
    
}
