package fr.ece.bernoux.Lab6Lambda.Exercice3;
/**
 * 
 * @author etienne $ nicolas
 *
 */
public class Main {

	public static void main(String[] args) {
		
		//New sequence using the manual building
		ISeq<String> seq = new ISeq.Cons<String>("hello ",new ISeq.Cons<String>("world!",new ISeq.Nil<String>()));
		seq.forEach(System.out::print);
		//New sequence with the Nil factory to begin the sequence
		seq = new ISeq.NilFactory<String>().creator();
		//using of the prepend method
		ISeq<String> seq2 = seq.prepend("world!").prepend(" ").prepend("\nhello");
		seq2.forEach(System.out::print);
	}
}
