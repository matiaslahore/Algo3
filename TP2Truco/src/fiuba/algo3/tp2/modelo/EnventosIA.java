package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.List;

class EnventosIA {
    private List<Oyente> listeners = new ArrayList<Oyente>();

    public void addListener(Oyente toAdd) {
        listeners.add(toAdd);
    }

    public void sayHello() {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (Oyente hl : listeners)
            hl.seCantoTruco();
    }
    
    
}