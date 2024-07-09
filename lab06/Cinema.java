/**
 * @ File name: Cinema.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:54:03
 */

public class Cinema {
    public static void main(String[] args) {
        MovieDirector md = new MovieDirector();

        MovieBuilder action_MovieBuilder = new ActionMovieBuilder();
        MovieBuilder comedy_MovieBuilder = new ComedyMovieBuilder();
        MovieBuilder horror_MovieBuilder = new HorrorMovieBuilder();


        System.out.println("\n ============== Action Movies ============== \n");

        md.setSpecificMovieBuilder(action_MovieBuilder);
        md.constructMovie();
        Movie actionMovie = md.getMovie();
        System.out.println(actionMovie.toString());

        System.out.println("\n\n ============== Comedy Movies ============== \n");

        md.setSpecificMovieBuilder(comedy_MovieBuilder);
        md.constructMovie();
        Movie comedyMovie = md.getMovie();
        System.out.println(comedyMovie.toString());

        System.out.println("\n\n ============== Horror Movies ============== \n");

        md.setSpecificMovieBuilder(horror_MovieBuilder);
        md.constructMovie();
        Movie horrorMovie = md.getMovie();
        System.out.println(horrorMovie.toString());
    }
}
