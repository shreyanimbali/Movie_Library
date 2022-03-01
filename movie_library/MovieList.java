import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* This class encapsulates a list of movies in a user's collection and several
 * operations that can be performed on that list. A movie is represented 
 * by an instance of the Movie class. Each movie has the following fields:
 * a title, a director, an (optional) genre, a playing time, and a release year.
*/
public class MovieList {
   //Class member variable declaration(s):
   ArrayList<Movie> movieList;


   /* Constructor that initializes the list and any other 
   *  variables.
   */    
   public MovieList(){
   // TODO 1: Implement this method.
     movieList = new ArrayList<Movie>();
   
   }
   
   /* Returns true if the movie list contains no movies, false otherwise.
    */
   public boolean isEmpty(){
   // TODO 2: Implement this method.
   if(movieList.size() == 0){
      return true;
   } 
      return false;
   }
   
   /* Add the movie passed in to the end of the list. 
    * For example, if the list contained: movie1, movie2,
    * the next movie added, movie3, would result in this list:
    * movie1, movie2, movie3.
   */
   public void addMovie(Movie newMovie){
   // TODO 3: Implement this method.
   movieList.add(newMovie);
   }
   
   /* This method returns a String which consists of the String
    * representation of each movie in the list. A line break is
    * inserted between each movie String.
    * If the movie list is empty, the String "no movies" is returned.
   */
   public String getMovieListAsString(){
   // TODO 4: Implement this method.
     if(movieList.size() == 0){
        return "no movies";
        
     } else {
     String str = "";
        for(int i = 0; i<=movieList.size()-1;i++){
             str = str + (i+1) + movieList.get(i).toString() + "\n";
        }
        return str;
        
     }
   }
   
  /* Remove the movie in the movieList with the targetDirector.
   * First, the method searches for a movie in the list with a director that 
   * matches the targetDirector. If it is found, that movie is removed from 
   * the list. If the targetDirector is not matched, the list remains the same and false is returned.
   * Note that there should not be any null values between movies in the list.
   * For example, if the list contained: movie1, movie2, movie3,
   * and the title of movie2 was "director1", this call:  
   *          removeMovieByTitle("director1");
   * would result in this list:  movie1, movie3.
   * This method returns true if the targetDirector matches the director of a movie in the list,
   * false otherwise.
   */
   public boolean removeMovieByDirector(String targetDirector){ 
   // TODO 5: Implement this method.
     if(movieList.size() == 0){
      return false;  
      }
     boolean found = false;
      for(int i = 0; i <= movieList.size()-1; i++){
        if(movieList.get(i).getDirector().equals(targetDirector)){
            movieList.remove(i);
            found = true;
        }
      }
      return found;
   }
   
  /* 
   * Return the movie list object.
   */
   public ArrayList<Movie> getMovieList(){
   // TODO 6: Implement this method.
      return movieList;
   }
   
   /* Remove all movies from the list, resulting in an empty list.
    */
   public void clearMovieList(){
   // TODO 7: Implement this method.
    movieList.clear();
   }
    
}