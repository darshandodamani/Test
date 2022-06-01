package wordleGame;

import java.util.Random;
import java.util.Scanner;

public class App {

	public static String[] names = { "coding", "is", "fun", "and", "enjoyable" };

	private static String selectWord() {

		return (names[new Random().nextInt(names.length)]);
	}

	private static char[] selectWord2() {
		return names[(int) (Math.random() * names.length)].toCharArray();
	}

	private static char[] hiddenWord(char[] firstWord) {
		char[] hiddenWord = new char[firstWord.length];
		for (int i = 0; i < firstWord.length; i++) {
			hiddenWord[i] = '?';
		}
		return hiddenWord;
	}

	public static void main(String[] args) {

		
		int numberOfGuesses = 0;
		Scanner input = new Scanner(System.in);
		int missed = 0;
		String unknownWord = selectWord();
		char[] unknownWord1 = selectWord2();
		char[] letterGuess1 = hiddenWord(unknownWord1);

		do {
			unknownWord = selectWord();

			System.out.print("(Guess) Enter a letter in word " + String.valueOf(letterGuess1) + " ");
			char ch = input.nextLine().charAt(0);

			// Check if already made this guess
			for (int j = 0; j < letterGuess1.length; j++) {
				if (letterGuess1[j] == ch) {
					System.out.println(ch + " Already in the word");
					missed = missed + 1;
					return;
				}
			}

			boolean isCorrect = false;
			for (int j = 0; j < unknownWord1.length; j++) {
				if (unknownWord1[j] == ch) {
					letterGuess1[j] = ch;
					isCorrect = true;
				}
			}
			if (!isCorrect) {
				System.out.println(ch + " is not in the word");
				missed = missed + 1;
			}
                 if(letterGuess1.equals(unknownWord1)) {
                	 
                 }
						
		} while (!letterGuess1.equals(unknownWord1));

				
		if (letterGuess1.equals(unknownWord1) ) {
			System.out.println("You won!");

		} else {
			System.out.println("You lose.");
		}
		System.out.println("The secret word is " + unknownWord);
		System.out.println("You made " + numberOfGuesses + " guesses.");
	}
}