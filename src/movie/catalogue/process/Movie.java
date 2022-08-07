/*
Movie.java
*@author: Luisa Nunes
28th Jul 2022
*/

package movie.catalogue.process;

public class Movie implements Comparable<Movie>{

    //class attributes
    private String name;
    private int duration;

    //class constructor
    public Movie(String name, int duration) {
        super();
        this.name = name;
        this.duration = duration;
    }

    //getters e setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    //method of checking if the objects are the same
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (duration != other.duration)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    //printing of the object on the screen with the attributes
    @Override
    public String toString() {
        return "Movie [name=" + name + ", durationInMinutes=" + duration + "]";
    }

    //film size comparison method
    @Override
    public int compareTo(Movie movie) {
        if(movie == this || duration == movie.duration)
            return 0;
        else if(duration > movie.duration)
            return 1;
        else
            return -1;
    }


}
