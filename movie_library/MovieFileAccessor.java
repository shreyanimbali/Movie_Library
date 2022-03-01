import java.io.*;
import java.util.ArrayList;

/**
 * This class extends FileAccessor to process the movie data in a text file.
 * The movies are stored in the file in comma-delimited(CSV) format. Each
 * line in the file reporesents one movie. Each line in the file is processed
 * into a new Movie object, which is placed on the MovieList member variable "movies".
 * Another method, writeMoviesToFile, takes a MovieList, converts its movies to a single 
 * CSV formatted String and writes it to the text file. 
**/
public class MovieFileAccessor extends FileAccessor{

  MovieList movies;
  /* After the call to the superclass constructor, initialize the member variable "movies" 
     to a new MovieList.  
  */
  public MovieFileAccessor(String f) throws IOException{
    super(f);
    movies = new MovieList();
  }
  
  /* This method implements the abstract method processLine in the FileAccessor class.
     It uses the String class method split to parse the line into individual Strings.
     The split method is passed "," as a parameter since the comma is the delimeter.
     
     Each line of the file has this format:
     title,director,genre,playTime,releaseYear
     Where title, director, playTime, releaseYear are required, and genre is optional. An example of
     a line with no genre:
     title,director,playTime,releaseYear
     
     You may assume that the title,director,playTime,releaseYear fields will always be present. After 
     the line has been tokenized, the array returned by split contains the data needed to create a 
     new Movie object which is then added to the MovieList object movies. 
     You have to check the length of the second token to determine if the genre field is present and based 
     on that length which Movie constructor to call.
  */
  public void processLine(String line){
  // TODO 1: Implement this method.
      String[] token = line.split(",");
      Movie newMovie;
      if (token.length == 5){
         newMovie = new Movie(token[0],token[1],token[2],Double.parseDouble(token[3]),Double.parseDouble(token[4]));
      movies.addMovie(newMovie);
      }
      if (token.length == 4){
         newMovie = new Movie(token[0],token[1],Double.parseDouble(token[2]),Double.parseDouble(token[3]));
      movies.addMovie(newMovie);
      }
      
  }
  
  /*  Formats the data in a Movie object into a String in CSV format.
   *  See the text files and instructions for examples of this format.
  */   
   public String movieToCSVString(Movie movie){
  // TODO 2: Implement this method.
     /**ArrayList<String> list = new ArrayList<String>();
     list.add(movie.getTitle());
     list.add(movie.getDirector());
     list.add(movie.getGenre());
     list.add(Double.toString(movie.getPlayTime()));
     list.add(Double.toString(movie.getReleaseYear()));
     String str = "";
        for(int i = 0; i<=list.size()-1;i++){
             str = str + (i+1) +list.get(i).toString() + "\n";
        }
            
     **/ 
     return movie.getTitle()+","+movie.getDirector()+","+movie.getGenre()+","+Double.toString(movie.getPlayTime())+","+Double.toString(movie.getReleaseYear());
  }
  
  /* This method returns a String of all movies in the movie list
     in CSV format. Each movie must be put into CSV format, and
     a line break inserted between movies. Calls movieToCSVString.
  */
  public String getMoviesAsCSV(MovieList movieList){
  // TODO 3: Implement this method.
     String str = "";
     for(int i=0; i<movieList.movieList.size(); i++){
         str = str+movieToCSVString(movieList.movieList.get(i))+"\n";
     }
     return str;
   }
   
  /* Returns the MovieList member variable "movies".
  */
  public MovieList getMovieList(){
    return movies;
  }

  /* This method writes the data in a MovieList object to the text file.
     The movies on the list must first be converted into a String in CSV
     format. Then this method calls the writeToFile method, passing it the 
     CSV String and the fileName.
  */  
  public void writeMoviesToFile(MovieList movies) throws IOException{
    writeToFile(getMoviesAsCSV(movies), fileName);
  }
  
  // This main can be run for testing MovieFileAccessor.
    public static void main(String[] args)throws IOException{
        // need a file to pass in, but can ignore it and enter your own inputs.
         String dataFile = "moviefiles/test0movies.txt";
         MovieFileAccessor sfa = new MovieFileAccessor(dataFile);
         Movie movie1 = new Movie("Inception", "Christopher Nolan", "Action", 2.28, 2010);
     //  Test movieToCSVString 
         System.out.println("****** Test movieToCSVString ******");
         String movieCSVstr = sfa.movieToCSVString(movie1);
         System.out.println("movieToCSVString output: "+ movieCSVstr); 
         System.out.println("correct output:  Inception,Christopher Nolan,Action,2.28,2010");
         System.out.println(" "); 
     //  Test getMoviesAsCSV 
         System.out.println("****** Test getMoviesAsCSV ******");
         MovieList movieList = new MovieList();
         movieList.addMovie(new Movie("Beauty and the Beast", "Gary Trousdale", "Children's film", 2.09, 2017));
         String moviesCSVstr = sfa.getMoviesAsCSV(movieList);
         System.out.println("movieToCSVString output:  "+ moviesCSVstr);
         System.out.println("correct output:  Beauty and the Beast,Gary Trousdale,Children's film,2.09,2017");
         System.out.println("-note: should see a space between the above because a line break is added in getMoviesAsCSV.");
         System.out.println(" "); 
     //  Test processLine
         System.out.println("****** Test processLine ******");
         String csvLine = "Avatar,James Cameron,Science Fiction,2.42,2009";
         sfa.processLine(csvLine);
         MovieList movies = sfa.getMovieList();
         ArrayList<Movie> movieArrayList = movies.getMovieList();
         Movie testMovie = movieArrayList.get(0);
         System.out.println("title test: "+"Avatar"+ " - "+testMovie.getTitle());
         System.out.println("director test: "+"James Cameron"+ " - "+testMovie.getDirector());
         System.out.println("genre test: "+"Science Fiction"+ " - "+testMovie.getGenre());
         System.out.println("playtime test: 2.42"+ " - "+testMovie.getPlayTime());
         System.out.println("playtime test: 2009"+ " - "+testMovie.getReleaseYear());
    }
}