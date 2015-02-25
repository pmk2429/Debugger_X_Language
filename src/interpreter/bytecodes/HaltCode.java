package interpreter.bytecodes;

import interpreter.VirtualMachine;
import java.util.*;


public class HaltCode extends ByteCode {
    public void init(ArrayList<String> byteCodeArgs) {
    }

    public void execute(VirtualMachine vm) {
        vm.setIsRunning(false);
    }

    @Override
    public String toString() {
        return "HALT";
    }
}
