package ua.epamcourses.task2.systems;

import java.util.ArrayList;

import ua.epamcourses.task2.lexemes.Sentence;


public class Main {

	
	public static void main(String[] args) {
		String Text = "� ���� � ������      �������� ���,\n ����� ������ � ���� ��������, " +
				"�� ������� �����, ���������� ����, ���� � ����������� ������ � ��������? " +
				"� ������� �� ���� ����� ������\t\t �� 3 �� 8 ����� � ����������� �� ������� ���������� " +
				"� ���� ����� ������������� � �������. ���� �������� ��� ���������� ������� � �����������, " +
				"�� ������� ������ �����, � ���� �������� ������ ���� � ����������� ����� �� ���� ������ �����������! " +
				"���������� ������� �� ��������� ����, �� ���� ������� ��� ��������� �������, � �� �������� ��� (��� ���) � �������. " +
				"���������� ��� � �� ������������ �������� ��������������, ������� � �������� � ����� � ����������� ���������� �� ������������ ���� �������. " +
				"�� ���� � ����� �������������� �������, ��� ��� ������ ����� ������ ������� � �������, ��� �� ������� � ���� ������ �������� ����������� ������ �������, " +
				"� ������, ���, �������� ������� ����������: ������� �� ������, ��� �� ������� � ����� �� ����� � ���������� �������, ������-���� � ��� ������ ���� ������ ���� " +
				"� �������� ������� � ���� ������ ���, ������ � ��� ������������ ���������.";
		
		ArrayList<Sentence> temp = Decomposer.formText(Text);
		Composer.sortSentences(temp);
		for(Sentence str:temp){
			System.out.println(str);
			System.out.println(str.getWordCount());
		}
	



	}

}
