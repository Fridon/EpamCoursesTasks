package ua.epamcourses.task2.systems;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ua.epamcourses.task2.lexemes.Punctuation;
import ua.epamcourses.task2.lexemes.Sentence;
import ua.epamcourses.task2.lexemes.Symbol;
import ua.epamcourses.task2.lexemes.Word;


public class Decomposer {
	
	public static String[] splitText(String text){
		Pattern pattern = Pattern.compile("\\s+");
		Matcher matcher = pattern.matcher(text);
		String temp = matcher.replaceAll(" ");
		pattern = Pattern.compile("(?<=[?.!])\\s+(?<=.)");
		return pattern.split(temp);
	}
	
	public static Sentence formSentence(String text){
		Sentence sentence = new Sentence();
		Pattern pattern = Pattern.compile("\\s");
		String[] splited = pattern.split(text);
		for(String s:splited){
			Word word = new Word();
			char[] temp = s.toCharArray();
			for(int i = 0; i < temp.length-1; i++){
				if(isPunctuation((new Character(temp[i])).toString()))
					word.addWordPart(new Punctuation(temp[i]));
				else
					word.addWordPart(new Symbol(temp[i]));
			}
			if(isPunctuation((new Character(temp[temp.length-1])).toString())){
				if(temp.length > 1)
					sentence.addSentencePart(word);
				sentence.addSentencePart(new Punctuation(temp[temp.length-1]));
			}else{
				word.addWordPart(new Symbol(temp[temp.length-1]));
				sentence.addSentencePart(word);
			}
				
		}		
		return sentence;
	}
	
	public static boolean isPunctuation(String punctuation){
		Pattern pattern = Pattern.compile("[\\p{Punct}–]");
		Matcher matcher = pattern.matcher(punctuation);
		return matcher.matches();
	}
	
	public static ArrayList<Sentence> formText(String text){
		ArrayList<Sentence> result = new ArrayList<Sentence>();
		String[] temp = splitText(text);
		for(String s:temp){
			result.add(formSentence(s));
		}		
		return result;
	}
		
}
