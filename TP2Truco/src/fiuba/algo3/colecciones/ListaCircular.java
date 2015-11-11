package fiuba.algo3.colecciones;

import java.util.ArrayList;

public class ListaCircular<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;

	@Override
	   public E get(int index) {
	      
		  return super.get(index % size());
	   }
}
