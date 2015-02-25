package interpreter.bytecodes;

import interpreter.VirtualMachine;
import java.util.*;


public abstract class ByteCode {
    private String arg = new String();

    public abstract void init(ArrayList<String> byteCodeArgs);
    public abstract void execute(VirtualMachine vm);

    public void setSymbolicAddress(int address) {
    }

    public String getArg() {
        return arg;
    }
}
