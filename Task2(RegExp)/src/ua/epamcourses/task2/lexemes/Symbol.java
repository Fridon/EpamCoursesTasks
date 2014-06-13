package ua.epamcourses.task2.lexemes;

import ua.epamcourses.task2.interfaces.WordPart;

public class Symbol implements WordPart{
	private char symbol;

	public Symbol(char symbol){
		this.symbol = symbol; 
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(symbol);
		return sb.toString();
	}
}
