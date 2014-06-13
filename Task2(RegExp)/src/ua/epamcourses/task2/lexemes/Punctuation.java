package ua.epamcourses.task2.lexemes;

import ua.epamcourses.task2.interfaces.SentencePart;
import ua.epamcourses.task2.interfaces.WordPart;

public class Punctuation implements SentencePart, WordPart{
	private char punctuation;

	public Punctuation(char punctuation){
		this.punctuation = punctuation;
	}
	
	public char getPunctuation() {
		return punctuation;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(punctuation);
		return sb.toString();
	}

	@Override
	public String forSentence() {
		return toString();
	}
}
