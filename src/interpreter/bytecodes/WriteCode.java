package interpreter.bytecodes;

import interpreter.VirtualMachine;
import java.util.*;


public class WriteCode extends ByteCode {
    public void init(ArrayList<String> byteCodeArgs) {
    }

    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    @Override
    public String toString() {
        return "WRITE";
    }
}
