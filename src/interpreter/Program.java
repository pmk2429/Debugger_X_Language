package interpreter;

import interpreter.bytecodes.ByteCode;
import java.util.ArrayList;
import java.util.HashMap;


public class Program {
    private ArrayList<ByteCode> byteCodeLines;
    private HashMap<String, Integer> labelAddrs;
    private ArrayList<Integer> legalBreakPts;
    private int counter = 0;

    public Program() {
        byteCodeLines = new ArrayList<ByteCode>();
        labelAddrs = new HashMap<String, Integer>();
        legalBreakPts = new ArrayList<Integer>();
    }

    public void setByteCodeLines(ByteCode bytecode) {
        byteCodeLines.add(bytecode);

        if(bytecode.getClass().getSimpleName().equals("LabelCode")) {
            labelAddrs.put(bytecode.getArg(), counter);
        }

        if(bytecode.getClass().getSimpleName().equals("LineCode") && Integer.parseInt(bytecode.getArg()) > 0) {
            legalBreakPts.add(Integer.parseInt(bytecode.getArg()));
        }

        counter++;
    }

    public void resolveAddresses() {
        for(ByteCode bc: byteCodeLines) {
            if(bc.getClass().getSimpleName().equals("DebugCallCode") || bc.getClass().getSimpleName().equals("FalseBranchCode") || bc.getClass().getSimpleName().equals("GotoCode")) {
                bc.setSymbolicAddress(labelAddrs.get(bc.getArg()));
            }
        }
    }
    
    public boolean isLegalBreakPoint(int offset) {
        return legalBreakPts.contains(offset);
    }

    public ByteCode getCode(int counter) {
        return byteCodeLines.get(counter);
    }

    public int getSize() {
        return byteCodeLines.size();
    }
}
