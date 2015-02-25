package interpreter.debugger.ui.commands;

import interpreter.debugger.DebugVM;
import java.util.ArrayList;

public class Help extends Command {
    @Override
    public void init(ArrayList<String> helpArgs) {
    }

    @Override
    public void execute(DebugVM dvm) {
        System.out.println("[sb] - Sets a new breakpoint(s) Can take multiple arguments");
        System.out.println("[cb] - Clears all breakpoints or specific breakpoint if specified");
        System.out.println("[lb] - List breakpoints");
        System.out.println("[df] - Display function");
        System.out.println("[dv] - Display variables");
        System.out.println("[cn] - Continue");
        System.out.println("[so] - Step out");
        System.out.println("[q] - Quit program");
        //System.out.println("[?] - Display help menu");
        //System.out.println("[si] - Step in");
        //System.out.println("[sv] - Step over");
        //System.out.println("[tr] - Stes function tracing");
        //System.out.println("[ds] - Display current call stack");
    }
}
