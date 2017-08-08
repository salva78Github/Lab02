package it.polito.tdp.alien;

public class Word {

	private final String alienWord;
	private String translation;

	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getTranslation() {
		return this.translation;
	}

	private String getAlienWord() {
		return this.alienWord;
	}

	/*
	 * controllare se la parola alienWord è già presente nel dizionario
	 */
	public boolean compare(String alienWord) {

		return getAlienWord().equalsIgnoreCase(alienWord);
	}

	public void updateTranslation(String translation) {
		this.translation = translation;

	}

}
