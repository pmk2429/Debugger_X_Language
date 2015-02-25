package interpreter;

import interpreter.bytecodes.ByteCode;
import java.io.*;
import java.util.*;


public class ByteCodeLoader {
    private BufferedReader byteCodeFile;
    private String nextLine;

    public ByteCodeLoader(String programFile) throws IOException {
        byteCodeFile = new BufferedReader(new FileReader(programFile));
    }

    public Program loadCodes() throws IOException {
        ArrayList<String> byteCodeArgs = new ArrayList();
        Program program = new Program();
        int counter = 0;

        nextLine = byteCodeFile.readLine();

        while(nextLine != null) {
            ByteCode bytecode = null;
            StringTokenizer byteCodeLine = new StringTokenizer(nextLine);
            String code = byteCodeLine.nextToken();

            try {
                bytecode = (ByteCode)(Class.forName("interpreter.bytecodes." + getCode(code)).newInstance());
            }
            catch(Exception e) {
                System.out.println(e);
            }

            while(byteCodeLine.hasMoreTokens()) {
                byteCodeArgs.add(byteCodeLine.nextToken());
            }

            bytecode.init(byteCodeArgs);
            program.setByteCodeLines(bytecode);
            byteCodeArgs.clear();
            nextLine = byteCodeFile.readLine();
            counter++;
        }

        program.resolveAddresses();
        return program;
    }

    public String getCode(String code) {
        return CodeTable.get(code);
    }
}
