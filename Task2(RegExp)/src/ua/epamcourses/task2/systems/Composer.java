package ua.epamcourses.task2.systems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ua.epamcourses.task2.lexemes.Sentence;

public class Composer {
	
	@SuppressWarnings("unchecked")
	public static void sortSentences(ArrayList<Sentence> text){
		@SuppressWarnings("rawtypes")
		Comparator c = new Comparator(){

			@Override
			public int compare(Object o1, Object o2) {
				Sentence temp1 = (Sentence)o1;
				Sentence temp2 = (Sentence)o2;
				return temp1.getWordCount().compareTo(temp2.getWordCount());
			}			
		};		
		Collections.sort(text, c);
	}
}
