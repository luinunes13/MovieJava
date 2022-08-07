/*
MovieCatalogueProcessor.java
*@author: Luisa Nunes
28th Jul 2022
*/
package movie.catalogue.process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieCatalogueProcessor {

    private Movie lastMovie;
    private List<Movie> movies = new ArrayList<>(); //creating a movie list

    /**
     *Method used to insert a new movie
     * @param name
     * @param duration
     */
    public void insertNewMovie(String name, int duration) {
        Movie movie = new Movie(name, duration); //creation of a new object with name and duration received by the method
        movies.add(movie); //add this object to the list
        lastMovie = movie;
    }

    /**
     * Method to return the last inserted movie
     * @return last movie entered
     */
    public Movie getLastEnteredMovie() {
        return lastMovie;
    }

    /**
     * method used to return all movies according to movie length
     * @return list of movies that are on the list
     */
    public List<Movie> getAllMoviesByShortedDuration() {
        Collections.sort(movies); //collections library method that sorts
        return movies;
    }

    /**
     * Method is used to return all movies with descending order of movie duration
     * @return list of movies with longest duration
     */
    public List<Movie> getAllMoviesByLongestDuration() {
        Collections.reverse(movies); //collections library method that sorts
        return movies;
    }

    /**
     * Method is used to get the average movie duration
     * @return average duration
     */
    public float getAveravgeDuration() {
        if(movies.size() == 0){ //checks if there are registered movies
            return 0;
        }else { //if it doesn't exist, it will do the operation to calculate the average duration of movies
            float sum = 0;
            for (Movie movie : movies) {
                sum += movie.getDuration();
            }
            return sum / movies.size();
        }
    }
}
