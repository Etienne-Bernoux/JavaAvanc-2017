package fr.ece.bernoux.Lab6Lambda.Exercice3;

public class Main {

	public static void main(String[] args) {
		Seq<String> seq = new Seq.Cons<String>("hello ",new Seq.Cons<String>("world!",new Seq.NIi<String>()));
		seq.forEach(System.out::print);
		
		seq = Seq.nil();
		Seq<String> seq2 = seq.prepend("world").prepend("3").prepend("\nhello");
		seq2.forEach(System.out::println);

	}

}
