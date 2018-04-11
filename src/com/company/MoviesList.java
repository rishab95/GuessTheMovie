package com.company;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class MoviesList {
    public ArrayList <String> movies;

    public MoviesList(String pathName){
        movies = new ArrayList();
        File file = new File(pathName);
        System.out.println(file.exists());
        try{
            Scanner fileScanner =  new Scanner(file);

            while(fileScanner.hasNextLine()){
                movies.add(fileScanner.nextLine());
            }
        } catch(FileNotFoundException FileException){
            System.out.println("No such file exists");
        }
    }

    public String getRandomMovie(){
        int indexOfMovie = (int) (Math.random()* movies.size());
        return movies.get(indexOfMovie);
    }
}
