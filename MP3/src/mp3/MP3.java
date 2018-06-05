//	Add R1, R2 and R0. This instruction adds the contents of source registers R1 and R2, and stores the results in destination register R0. This addition can be executed as follows:
//		The registers R0, R1, and R2 are extracted from the IR.
//		The contents of R1 and R2 are passed to the ALU for addition
//		The output of the ALU is transferred to R0.

//	Add X, R0. This instruction adds the contents of memory location X to register R0 and stores the result in R0. This addition can be executed as follows:
//		The memory location X is extracted from IR and loaded into MAR.
//		As a result of memory read operation, the contents of X are loaded into MDR.
//		The contents of MDR are added to the contents of R0.

package mp3;

/**
 *
 * @author Paul Kiunisala
 */

import java.util.*;


public class MP3 {
    public static int alu(int reg1, int reg2){
        return reg1 + reg2;
    }
    public static void main(String[] args) {
        //initialize Instruction Register
        String blah = "32156465105";
        int st = blah.length() - 1;
        ArrayList<Integer> ir = new ArrayList<>();
        for (int i = 0; i < blah.length(); i++){
            int k = (int)blah.charAt(i) - 48;
            ir.add(k);
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("1. ADD R0, R1, R2");
        System.out.println("2. ADD X, R0");
        int choice = scan.nextInt();
        if (choice == 1){
            System.out.println("Enter addresses of R1 and R2:(must be from 1 to " + st + " since address '0' is reserved for R0)");
            int r1Add = scan.nextInt();
            int r2Add = scan.nextInt();
            
            int r1 = ir.get(r1Add);
            int r2 = ir.get(r2Add);
            System.out.println("Values of R1:" + r1 + ", and R2:" + r2);
            
            System.out.println("Passing contents of R1 and R2 to ALU and perform addition");
            //ALU
            int ALU = alu(r1, r2);
            
            System.out.println("Initial value of R0:" + ir.get(0));
            
            System.out.println("Transferring output of ALU to R0");
            ir.set(0, ALU);
            
            System.out.println("New value of R0:" + ir.get(0));
        }
        if (choice == 2){
            System.out.println("Enter memory address X:(must be from 1 to " + st + " since address '0' is reserved for R0)");
            int MAR = scan.nextInt();
            System.out.println("Extracting X from IR, then loading it to MAR");
            System.out.println("Loading contents of X to MDR");
            int MDR = ir.get(MAR);
            System.out.println("Content in MDR:" + MDR);
            int r0 = ir.get(0);
            System.out.println("Initial value of R0:" + r0);
            r0 = alu(r0, MDR);
            ir.set(0, r0);
            System.out.println("New value of R0:" + r0);
        }
    }
    
}
