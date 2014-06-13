package ua.epamcourses.task2.lexemes;

import java.util.ArrayList;

import ua.epamcourses.task2.interfaces.SentencePart;

public class Sentence {
	private ArrayList<SentencePart> sentence; 
	private Integer wordCount;
	
	
	public Sentence(){
		sentence = new ArrayList<SentencePart>();
		wordCount = 0;
	}
	
	public void addSentencePart(Word word){
		sentence.add(word);
		wordCount++;
	}
	
	public void addSentencePart(Punctuation punctuation){
		sentence.add(punctuation);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(sentence.get(0));
		for(int i = 1; i < sentence.size(); i++){
			if(sentence.get(i).toString().equals("–"))
				sb.append(" ");			
			sb.append(sentence.get(i).forSentence());			
		}
		sb.append(" ");
		return sb.toString();
	}
	
	public Integer getWordCount(){
		return wordCount;
	}
}
