package interpreter.bytecodes;

import interpreter.VirtualMachine;
import java.util.*;


public class FalseBranchCode extends ByteCode {
    private String falseBranchCodeArg = new String();
    private int symbolicAddress;

    public void init(ArrayList<String> byteCodeArgs) {
        falseBranchCodeArg = byteCodeArgs.get(0);
    }

    public void execute(VirtualMachine vm) {
        int branch = vm.pop();

        if(branch == 0) {
            vm.setPC(symbolicAddress);
        }
    }

    @Override
    public void setSymbolicAddress(int address) {
        symbolicAddress = address;
    }

    @Override
    public String getArg() {
        return falseBranchCodeArg;
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + falseBranchCodeArg;
    }
}
