package Dictionary;

import java.util.*;
import java.util.stream.Collectors;

public class English_Russian implements Runnable{
    ArrayList<Word> words;
    Scanner in = new Scanner(System.in);
    public English_Russian() {
        words = new ArrayList<Word>();
    }
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("\n\n-- Welcome to English-Russian dictionary --");
                System.out.println("Please choose an option");
                System.out.println("1 - Translate");
                System.out.println("2 - Add new word");
                System.out.println("3 - Edit word");
                System.out.println("4 - Delete word");
                System.out.println("5 - Add new translation");
                System.out.println("6 - Edit translation");
                System.out.println("7 - Delete translation");
                System.out.println("8 - TOP-10 most popular words");
                System.out.println("9 - TOP-10 most unpopular words");
                System.out.println("q - Exit");
                char choice;
                choice = in.nextLine().charAt(0);
                switch (choice) {
                    case '1':
                        translate();
                        break;
                    case '2':
                        addNewWord();
                        break;
                    case '3':
                        editWord();
                        break;
                    case '4':
                        deleteWord();
                        break;
                    case '5':
                        addNewTranslation();
                        break;
                    case '6':
                        editTranslation();
                        break;
                    case '7':
                        deleteTranslation();
                        break;
                    case '8':
                        mostPopular();
                        break;
                    case '9':
                        mostUnpopular();
                        break;
                    case 'q':
                        System.exit(0);
                        break;
                }
            } catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    private void translate() {
        try {
            System.out.print("Enter the word: ");
            String wordToSearch = in.nextLine();
            Word word = searchWord(wordToSearch);
            if(word == null){
                System.out.println("There is no such word in the dictionary");
            }
            else {
                for(Word usage: words){
                    if(usage.equals(word)){
                        usage.usages++;
                        for (String translation : usage.translations) {
                            System.out.println(translation);
                        }
                    }
                }
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private Word searchWord(String word){
        for(Word toTranslate : words){
            if(toTranslate.getWord().equals(word)){
                return toTranslate;
            }
        }
        return null;
    }

    public void addNewWord(){
        try {
            System.out.print("Enter the word: ");
            String word = in.nextLine();
            System.out.print("Enter the translation: ");
            String translation = in.nextLine();
            Word newWord = new Word();
            newWord.setWord(word);
            newWord.translations.add(translation);
            words.add(newWord);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void editWord(){
        System.out.print("Enter the word to edit: ");
        String wordToEdit = in.nextLine();
        Word word = searchWord(wordToEdit);
        if(word == null){
            System.out.println("There is no such word in the dictionary");
        }
        else {
            System.out.print("Enter the new version of the word: ");
            String newVersion = in.nextLine();
            word.setWord(newVersion);
            for(Word toEdit: words){
                if(toEdit.translations.equals(word.translations)){
                    toEdit = word;
                    System.out.println("Success");
                }
            }
        }
    }

    public void deleteWord() {
        System.out.print("Enter the word to delete: ");
        String wordToDelete = in.nextLine();
        Word word = searchWord(wordToDelete);
        if(word == null){
            System.out.println("There is no such word in the dictionary");
        }
        else {
            for(Word toDelete: words){
                if(toDelete.word.equals(word.word)){
                    words.remove(toDelete);
                    System.out.println("Success");
                }
            }
        }
    }

    public void addNewTranslation() {
        try{
            System.out.print("Enter the word: ");
            String word = in.nextLine();
            Word addTranslation = searchWord(word);
            if(addTranslation != null) {
                System.out.print("Enter the translation to add: ");
                addTranslation.translations.add(in.nextLine());
                for(Word toEdit: words){
                    if(toEdit.word.equals(addTranslation.word)){
                        toEdit = addTranslation;
                        System.out.println("Success");
                    }
                }
            } else {
                System.out.println("There is no such word in the dictionary");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void editTranslation() {
        try{
            System.out.print("Enter the word: ");
            String wordToFind = in.nextLine();
            Word word = searchWord(wordToFind);
            for(Word toEdit: words){
                if(toEdit.equals(word)){
                    System.out.println("Here are all the translations of this word: ");
                    for(String translation: toEdit.translations){
                        System.out.println(translation);
                    }
                    System.out.print("Select a translation to edit: ");
                    String translationToEdit = in.nextLine();
                    toEdit.translations.remove(translationToEdit);
                    System.out.print("Enter a new version: ");
                    toEdit.translations.add(in.nextLine());
                    System.out.println("Success");
                }
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteTranslation() {
        try{
            System.out.print("Enter the word: ");
            String wordToFind = in.nextLine();
            Word word = searchWord(wordToFind);
            for(Word toEdit: words){
                if(toEdit.equals(word)){
                    System.out.println("Here are all the translations of this word: ");
                    for(String translation: toEdit.translations){
                        System.out.println(translation);
                    }
                    System.out.print("Select a translation to delete: ");
                    String translationToDelete = in.nextLine();
                    toEdit.translations.remove(translationToDelete);
                    System.out.println("Success");
                }
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void mostPopular() {
        words.sort(Collections.reverseOrder(Comparator.comparing(Word::getUsages)));
        List<Word> top10 = words.stream().limit(10).toList();
        for(Word word: top10) {
            System.out.println(word.getWord() + " : " + word.getUsages() + " usages");
        }
    }

    public void mostUnpopular() {
        words.sort(Comparator.comparing(Word::getUsages));
        List<Word> top10 = words.stream().limit(10).toList();
        for(Word word: top10) {
            System.out.println(word.getWord() + " : " + word.getUsages() + " usages");
        }
    }
}
