import java.util.Scanner;
/* This application manages a collection of movies for a user. The movies
 * are representeed by Movie objects. The movies are managed by a MovieList object.
 * The movies are stored in a comma-delimited text file.
 * A user has several options that are displayed in a menu format.
 * This class runs a console interface between a user and the MovieList
*/
import java.io.*;

public class LibraryMain {
       
    public static void main(String[] args) throws IOException{
         // the file to store the user's movies:
         String dataFile = "moviefiles/mymovies.txt";
         // testing files- uncomment a file for running tests:
         //dataFile = "moviefiles/test_no_genre.txt";
         //dataFile = "moviefiles/test1movie.txt";
         //dataFile = "moviefiles/test2movies.txt";
   //      dataFile = "moviefiles/test7movies.txt";

         System.out.println("My Movie Library");
         Scanner scan = new Scanner(System.in);
         
         // for reading the movie file
         MovieFileAccessor sfa = null;
         // maintains the movie list
         MovieList movies = null;
         
        // Load any movies that were saved in the dataFile.
   /********* comment out these 3 lines to bypass the fileIO part.****/ 
         sfa = new MovieFileAccessor(dataFile);
         sfa.processFile();
         movies = sfa.getMovieList();
   /*****************************************************************/
         
    /******* Testing without FileIO- to test only the MovieList- without FileIO
             uncomment the line below.   ********/
        // movies = getMoviesForTesting();
    /***************************************/
       
         boolean keepGoing = true;
         String userStr = "";
         int position;
         
         while(keepGoing) {
              System.out.println("Main Menu:");
              System.out.println("Enter A to add a movie."); 
              System.out.println("Enter R to remove a movie."); 
              System.out.println("Enter P to view all movies.");
              System.out.println("Enter S to save all movies."); 
              System.out.println("Enter C to clear all movies."); 
              System.out.println("Enter X to quit.");
              System.out.println("");
              userStr = scan.nextLine();
              
              if (userStr.equalsIgnoreCase("A")){
                 System.out.println("Enter the title: ");
                 String title = scan.nextLine();
                 System.out.println("Enter the director");
                 String director = scan.nextLine();                 
                 System.out.println("Enter the genre, enter a space if none: ");
                 String genre = scan.nextLine();
                 System.out.println("Enter the playing time: ");
                 String playTime = scan.nextLine();
                 System.out.println("Enter the release year: ");
                 String releaseYear = scan.nextLine();
                 movies.addMovie(new Movie(title, director, genre, Double.parseDouble(playTime), Double.parseDouble(releaseYear)));
              }
              else if (userStr.equalsIgnoreCase("R")){
                 System.out.println("Enter the director of the movie to be removed:");
                 String director = scan.nextLine();
                 if(movies.removeMovieByDirector(director))
                     System.out.println("Movie with director "+director+" removed.");
                 else
                     System.out.println("Could not find "+director+" in the list.");
              }
              else if (userStr.equalsIgnoreCase("S")){
                 System.out.println("Your movies have been saved.");
                 sfa.writeMoviesToFile(movies);
              }
              else if (userStr.equalsIgnoreCase("P")){
                 System.out.println("Your movies: ");
                 System.out.println(movies.getMovieListAsString());
              }
              else if (userStr.equalsIgnoreCase("C")){
                 movies.clearMovieList();
                 System.out.println("Movies cleared.");
              }
              else if(userStr.equalsIgnoreCase("X"))
                 keepGoing = false;
              else
                 System.out.println("Unrecognized input.");               
         }
         System.out.println("Bye for now.");
         scan.close();
    }
    
    public static MovieList getMoviesForTesting(){
       MovieList movies = new MovieList();       
       movies.addMovie(new Movie("Inception", "Christopher Nolan", "Action", 2.28, 2010));
       
       movies.addMovie(new Movie("Beauty and the Beast", "Gary Trousdale", "Children's film", 2.09, 2017));
       
       movies.addMovie(new Movie("Avatar", "James Cameron", "Science Fiction", 2.42, 2009));
   
       movies.addMovie(new Movie("The Lion King", "Roger Allers", "", 2.30, 1994));
       
       movies.addMovie(new Movie("The Dark Knight", "Christopher Nolan", "Action", 2.32, 2008));
       
       movies.addMovie(new Movie("Jurassic Park", "Steven Spielberg", "Science Fiction", 2.07, 1993));
       
       movies.addMovie(new Movie("Titanic", "James Cameron", "Romance", 3.30, 1997));
       return movies;
    } 

}