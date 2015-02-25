package interpreter.bytecodes;

import interpreter.VirtualMachine;
import java.util.*;


public class StoreCode extends ByteCode {
    private ArrayList<String> storeCodeArgs = new ArrayList<String>();
    private int topOfStack;

    public void init(ArrayList<String> byteCodeArgs) {
        for(String bca: byteCodeArgs) {
            storeCodeArgs.add(bca);
        }
    }

    public void execute(VirtualMachine vm) {
        int offset = Integer.parseInt(storeCodeArgs.get(0));

        vm.store(offset);
        topOfStack = vm.peek();
    }

    @Override
    public String toString() {
        return "STORE " + storeCodeArgs.get(0) + " " + storeCodeArgs.get(1) + "     " + storeCodeArgs.get(1) + " = " + topOfStack;
    }
}
