package interpreter.debugger.ui;

import java.util.HashMap;

public class CommandTable {
    public static HashMap<String, String> commands = new HashMap<String, String>();

    public static String get(String command) {
        if(command.equals(null)) {
            return "Invalid";
        }

        if(commands.containsKey(command)) {
            return commands.get(command);
        }
        else {
            return "Invalid";
        }
    }

    public static void init() {
        commands.put("?", "Help");
        commands.put("sb", "SetBreakPoints");
        commands.put("cb", "ClearBreakPoints");
        commands.put("lb", "ListBreakPoints");
        commands.put("cn", "Continue");
        commands.put("df", "DisplayFunction");
        commands.put("dv", "DisplayVariables");
        commands.put("ds", "DisplayCallStack");
        commands.put("so", "StepOut");
        commands.put("si", "StepInto");
        commands.put("sv", "StepOver");
        commands.put("tr", "Trace");
        commands.put("q", "Quit");
    }
}
