/**
 * @ File name: MovieDirector.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:59:34
 */

package lab06.movie;

public class MovieDirector {
    private MovieBuilder mb;
    // Define o movie builder que será utilizado para construir o filme 
    public void setSpecificMovieBuilder(MovieBuilder mb) {this.mb = mb;}

    public Movie getMovie() {return mb.getMovie();}

    // Aqui é onde o filme é realmente construído DE ACORDO COM O BUILDER PRETENDIDO (i.e., se é de Terror, de Ação ou de Comédia) 
    // E isto porque os métodos chamados em baixo são os métodos definidos no builder específico escolhido "mb", ou seja,
    // o método constructMovie() chama os métodos do builder para construir o filme especificado em "setSpecificMovieBuilder()".
    public void constructMovie() {
        mb.createNewMovie();
        mb.addTitle();
        mb.addYear();
        mb.addDirector();
        mb.addWriter();
        mb.addSeries();
        mb.addCast();
        mb.addLocations();
        mb.addLanguages();
        mb.addGenres();
        mb.setIsTelevision();
        mb.setIsNetflix();
        mb.setIsIndependent();
    }
}
