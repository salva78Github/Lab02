package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class WordEnhanced {
	private final String alienWord;
	private List<String> translation = new ArrayList<String>();

	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation.add(translation);
	}

	public List<String> getTranslation() {
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
	
	public boolean compareForTranslation(String alienWord) {
		if(alienWord.contains("?")){
			int position = alienWord.indexOf("?");
			System.out.println("<compareForTranslation> position: " + position);
			//alienWord.("?", getAlienWord().substring(position, position+1));
			alienWord = alienWord.substring(0, position)+getAlienWord().substring(position, position+1)+
					alienWord.substring(position+1);	
			System.out.println("<compareForTranslation> alienWord: " + alienWord);
		}
		return getAlienWord().equalsIgnoreCase(alienWord);
	}
	

	public void updateTranslation(String translation) {
		if(!getTranslation().contains(translation)){
			this.translation.add(translation);
		}
	}

	public String getTranslationToString() {
		if (getTranslation().size() != 0) {
			StringBuffer sb = new StringBuffer("Traduzioni per " + getAlienWord() +": \n");
			int i = 1;
			for (String t : getTranslation()) {
				sb.append(i).append(". ").append(t).append("\n");
				i++;
			}
			return sb.toString();
		} else {
			return null;
		}

	}

}
