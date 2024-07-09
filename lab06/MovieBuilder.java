/**
 * @ File name: MovieBuilder.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:54:33
 */



public abstract class MovieBuilder {

    protected Movie m;

    public void createNewMovie() {this.m = new Movie();}
    
    public Movie getMovie() {return this.m;}

    // Métodos abstratos que serão implementados pelos builders concretos (concrete builders/specific builders, i.e., "Terror", 
    // "Ação" e "Comédia") de acordo com o filme que se pretende construir.
    public abstract void addTitle();
    public abstract void addYear();
    public abstract void addDirector();
    public abstract void addWriter();
    public abstract void addSeries();
    public abstract void addCast();
    public abstract void addLocations();
    public abstract void addLanguages();
    public abstract void addGenres();
    public abstract void setIsTelevision();
    public abstract void setIsNetflix();
    public abstract void setIsIndependent();
}
