/*
MovieCatalogueInteractor.java
*@author: Luisa Nunes
28th Jul 2022
*/

package movie.catalogue.process;

import java.util.List;
import java.util.Scanner;

public class MovieCatalogueInteractor {

    private Scanner sc = new Scanner(System.in); //creating the class responsible for interacting with the user
    private MovieCatalogueProcessor processor = new MovieCatalogueProcessor();

    /**
     * Method used to start the application
     */
    public void start() {

        int selectMenu = 0;
        do {
            //displaying main menu
            displayMenu();

            System.out.println("Enter your number choice: ");

            //input validation
            while(!isValidNumber()) {
                System.out.println("Please, enter with valid input \n");
                continue;
            }

            //get selected option
            selectMenu = sc.nextInt();
            sc.nextLine();

            //selected menu option validation
            if(selectMenu > 6 || selectMenu <= 0)
                System.out.println("Please, enter the number for given the options \n");

            switch(selectMenu)
            {
                case 1:
                    if(!enterMovieSuccessfully()) {
                        System.out.println("Please, enter the valid duration of the movie \n");
                        continue;
                    }
                    break;

                case 2:
                    getLastEnteredMovie();
                    break;

                case 3:
                    moviesList(processor.getAllMoviesByShortedDuration());
                    break;

                case 4:
                    moviesList(processor.getAllMoviesByLongestDuration());
                    break;

                case 5:
                    System.out.println("Average duration for all movies: " + processor.getAveravgeDuration()+"\n");
                    break;
            }

        } while(selectMenu != 6);

        System.out.println("Exit system");
        sc.close();
    }

    /**
     * Method used to display the menu
     */
    public void displayMenu() {
        System.out.println("Application Menu - Item Type: Movie\n");
        System.out.println("1 - Provide the details of a movie\n");
        System.out.println("2 - Display the details of the last entered movie\n");
        System.out.println("3 - Display the movies according to the shortest duration\n");
        System.out.println("4 - Display the movies according to the longest duration\n");
        System.out.println("5 - Display the average duration of all movies\n");
        System.out.println("6 - Exit application\n");
    }

    /**
     * Method used to validate the number
     * @return
     */
    public boolean isValidNumber() {
        if(!sc.hasNextInt()) {
            sc.nextLine();
            return false;
        }
        return true;
    }

    /**
     * Method is used to accept input from user to enter new movie and validate the same
     * @return
     */
    public boolean enterMovieSuccessfully() {
        int duration = 0;
        System.out.println("Enter movie name: ");
        String name = sc.nextLine();
        System.out.println("Enter movie duration in minutes: ");
        if(isValidNumber()) {             //movie duration validation
            duration = sc.nextInt();
            sc.nextLine();
            if(duration <= 0) {
                return false;
            }
        }
        else {
            return false;
        }
        processor.insertNewMovie(name, duration);
        System.out.println("Sucess\n");
        return true;
    }

    /**
     * Method is used to display the last entered movie from user
     */
    public void getLastEnteredMovie() {
        Movie movie = processor.getLastEnteredMovie();
        //checks if you have any movie inserted
        if(movie == null) {
            System.out.println("No movies found, please select option 1 to enter new movie");
        }else {
            System.out.println("Movie name: " + movie.getName());
            System.out.println("Movie duration: " + movie.getDuration() + "\n");
        }
    }

    /**
     * Method used to show all movies
     * @param movies
     */
    public void moviesList(List<Movie> movies) {
        //loop to loop through the list of movies
        for(Movie movie : movies) {
            System.out.println("\n Movie name: " + movie.getName() +
                    ", Movie Duration: " + movie.getDuration());
        }
        System.out.println();
    }
}
