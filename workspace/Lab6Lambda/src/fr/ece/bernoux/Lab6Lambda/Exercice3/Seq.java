package fr.ece.bernoux.Lab6Lambda.Exercice3;

import java.util.function.Consumer;

public interface Seq<T> {
	void forEach(Consumer<T> consumer);
	default Seq<T> prepend(T newElement){
			return new Cons<T>(newElement,this);
	}
	static Seq nil() {
		return new NIi();	
	}
	
	
	public class Cons<T> implements Seq<T> {
		private final T element;
		private final Seq<T> next;
		
		public Cons(T element, Seq<T> next) {
			super();
			this.element = element;
			this.next = next;
		}

		@Override
		public void forEach(Consumer<T> consumer) {
			//We execute the consumer with the element
		consumer.accept(element);
			//We execute for each for the next element
		next.forEach(consumer);
			
		}



	}
	public class NIi<T> implements Seq<T> {

		public NIi() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public void forEach(Consumer<T> consumer) {			
		}
	}
}

