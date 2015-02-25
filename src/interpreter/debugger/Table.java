package interpreter.debugger;

import java.util.HashMap;
import java.util.Set;

class Binder {
    private Object value;
    private String prevtop;   // prior symbol in same scope
    private Binder tail;      // prior binder for same symbol
                              // restore this when closing scope
    Binder(Object v, String p, Binder t) {
        value = v;
        prevtop = p;
        tail = t;
    }

    Object getValue() {
        return value;
    }

    String getPrevtop() {
        return prevtop;
    }

    Binder getTail() {
        return tail;
    }
}

public class Table {
    private HashMap<String, Binder> symbols;
    private String top;

    public HashMap<String, Binder> getSymbols() {
        return symbols;
    }

 
    public Object get(String key) {
	    int e = (Integer) symbols.get(key).getValue();
	    return e;
    }


    public void put(String key, int value) {
        symbols.put(key, new Binder(value, top, symbols.get(key)));
        top = key;
    }

 
    public void beginScope() {
        symbols = new HashMap<String, Binder>();
        top = null;
    }

 
    public void endScope(int pop) {
        for(int i = 1; i <= pop; i++) {
            Binder e = symbols.get(top);

            if(e.getTail() != null) {
                symbols.put(top, e.getTail());
            }
            else {
                symbols.remove(top);
            }

            top = e.getPrevtop();
        }
    }

    
    public Set<String> keys() {
        return symbols.keySet();
    }
}
