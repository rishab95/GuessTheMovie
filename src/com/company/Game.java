package com.company;

import java.util.Scanner;

public class Game {

    private String movieToGuess;
    private int lostPoints;
    private String wrongLetters;
    private String correctLetters;
    private boolean gameStatus;

    public Game(String pathName){
        MoviesList movieList = new MoviesList(pathName);
        movieToGuess = movieList.getRandomMovie().trim();
        lostPoints = 0;
        correctLetters = "";
        wrongLetters = "";
        gameStatus = false;
    }

    public String getMovieTitle(){
        if(correctLetters.equals("")){
            return movieToGuess.replaceAll("[a-zA-Z]", "_");
        } else {
            return movieToGuess.replaceAll("[a-zA-Z&&[^" + correctLetters + "]]", "_");
        }
    }

    public String getWrongLetters(){
        return wrongLetters;
    }

    public boolean isGameStatus() {
        return gameStatus;
    }

    public boolean gameEnd(){
        if(lostPoints >= Utils.lostPoints){
            return true;
        }
        if(! getMovieTitle().contains("_")){
            gameStatus = true;
            return true;
        }
        else{
            return false;
        }
    }

    public String inputLetter() {
        System.out.println("Guess a letter: ");
        Scanner letterScanner = new Scanner(System.in);
        String letter = letterScanner.nextLine().toLowerCase();

        if (!letter.matches("[a-zA-Z]")) {
            System.out.println("Please enter a valid alphabet");
            return inputLetter();
        } else if (wrongLetters.contains(letter) || correctLetters.contains(letter)) {
            System.out.println("This letter has been guessed already");
            return inputLetter();
        } else {
            return letter;
        }
    }

    public void letterGuessMovie(){

        String letterGuessed = inputLetter();

        if(movieToGuess.toLowerCase().contains(letterGuessed)){
            correctLetters += letterGuessed + letterGuessed.toUpperCase();
        }
        else{
            lostPoints++;
            wrongLetters += " " + letterGuessed;
        }
    }
}
