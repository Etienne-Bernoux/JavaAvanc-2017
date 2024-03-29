package fr.ece.bernoux.Lab6Lambda.Exercice3;

import java.util.function.Consumer;


/**
 * interface ISeq to manage a sequence of data
 * 
 * @author Etienne & Nicolas
 *
 * @param <T>
 */
public interface ISeq<T> {
	void forEach(Consumer<T> consumer);
	default ISeq<T> prepend(T newElement){
			return new Cons<T>(newElement,this);
	}	
	public class Cons<T> implements ISeq<T> {
		private final T element;
		private final ISeq<T> next;
		public Cons(T element, ISeq<T> next) {
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
	public class Nil<T> implements ISeq<T> {

		public Nil() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public void forEach(Consumer<T> consumer) {			
		}
	}
	public class NilFactory<T>{
		public Nil<T> creator(){		
			return new Nil<T>();			
		}	
	}
}


