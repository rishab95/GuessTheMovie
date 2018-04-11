package com.company;

public class Main {

    public static void main(String[] args){
        Game game = new Game("C:\\Users\\admin\\IdeaProjects\\GuessTheMovie\\src\\movies.txt");
        System.out.println("Welcome to the game - Guees the Movie");
        System.out.println("The rules are simple, the computer randomly picks a movie title, and shows you" +
                "how many letters are there in it");
        System.out.println("Your have to try to find out the movie by guessing one letter at a time.");
        System.out.println("If a letter is in the title the computer will display its correct position in" +
                "the word, if not, you lose a point.");

        System.out.println("If you lose 10 points, game ends!");
        System.out.println("Let's begin!");
        System.out.println("The movie title has " + game.getMovieTitle().length() + " characters (including spaces "
                + "and punctuation).");

        while(!game.gameEnd()){
            System.out.println("You are guessing:" + game.getMovieTitle());
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:"
                    + game.getWrongLetters());
            game.letterGuessMovie();
        }
        if(game.isGameStatus()){
            System.out.println("You win!");
            System.out.println("You have guessed " + game.getMovieTitle() + " correctly.");
        }
        else{
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:" +
                    game.getWrongLetters());
            System.out.println("You lost!");
            System.out.println("The movie title was " + game.getMovieTitle());
            System.out.println("Better luck next time.");
        }

    }
}
