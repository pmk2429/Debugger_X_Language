package interpreter.bytecodes;

import interpreter.VirtualMachine;
import javax.swing.JOptionPane;
import java.util.*;


public class ReadCode extends ByteCode {
    @Override
    public void init(ArrayList<String> byteCodeArgs) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = console.nextInt();

        System.out.println(input);
        vm.push(input);
    }

    @Override
    public String toString() {
        return "READ";
    }
}
