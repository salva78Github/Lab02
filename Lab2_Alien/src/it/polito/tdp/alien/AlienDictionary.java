package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionary {
	/*
	 * La classe AlienDictionary implementa il dizionario come una lista di
	 * oggetti di tipo Word.
	 * 
	 * 
	 */
	
//	private List<Word> words = new ArrayList<Word>();
	private List<WordEnhanced> words = new ArrayList<WordEnhanced>();
	

	/*
	 * Il metodo viene chiamato dal Controller per l’aggiunta, nel dizionario,
	 * di una nuova alienWord con corrispondente translation. Se alienWord è già
	 * presente, la traduzione deve essere aggiornata.
	 * 
	 */
	public void addWord(String alienWord, String translation) {
		
		for(WordEnhanced w : this.words){
			if(w.compare(alienWord)){
				w.updateTranslation(translation);
				return;
			}
		}
		
		//Word word = new Word(alienWord.toLowerCase(),translation.toLowerCase());
		WordEnhanced word = new WordEnhanced(alienWord, translation);
		this.words.add(word);
	}

	/*
	 * Il metodo viene chiamato dal Controller per la traduzione della parola
	 * alienWord passata come parametro. Il metodo restituisce la parola
	 * tradotta, altrimenti null se alienWord non è presente nel dizionario.
	 */
	public String translateWord(String alienWord) {
		StringBuffer translation = new StringBuffer();
		for(WordEnhanced w : this.words){
			if(w.compareForTranslation(alienWord)){
				translation.append(w.getTranslationToString());
			}
		}
		
		return translation.toString();
	}

}
