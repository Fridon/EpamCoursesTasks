package ua.epamcourses.task2.lexemes;

import java.util.LinkedList;

import ua.epamcourses.task2.interfaces.SentencePart;
import ua.epamcourses.task2.interfaces.WordPart;


public class Word implements SentencePart{
	LinkedList<WordPart> word;
	
	public Word(){
		word = new LinkedList<WordPart>();
	}
	
	public void addWordPart(WordPart part){
		word.add(part);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(WordPart w:word){
			sb.append(w.toString());
		}
		return sb.toString();
	}

	@Override
	public String forSentence() {
		StringBuilder sb = new StringBuilder();
		sb.append(" ");
		for(WordPart w:word){
			sb.append(w.toString());
		}
		return sb.toString();
	}
	
}
