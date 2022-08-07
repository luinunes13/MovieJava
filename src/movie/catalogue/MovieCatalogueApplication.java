/*
MovieCatalogueApplication.java
*@author: Luisa Nunes
28th Jul 2022
*/

//Movie application

package movie.catalogue;

import movie.catalogue.process.MovieCatalogueInteractor;

public class MovieCatalogueApplication {

    public static void main(String[] args) {

        MovieCatalogueInteractor interactor = new MovieCatalogueInteractor();
        interactor.start();
    }
}