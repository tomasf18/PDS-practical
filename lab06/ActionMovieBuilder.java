/**
 * @ File name: ActionMovieBuilder.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:53:35
 */



import java.util.List;

public class ActionMovieBuilder extends MovieBuilder {

    // Métodos implementados de acordo com o filme concreto de Ação que se pretende construir
    public void addTitle() {m.setTitle("Avengers - Endgame");}
    public void addYear() {m.setYear(2019);}
    public void addDirector() {m.setDirector(new Person("Anthony Russo"));}
    public void addWriter() {m.setWriter(new Person("Christopher Markus"));}
    public void addSeries() {m.setSeries("Avengers");}
    public void addCast() {
        m.setCast(List.of(
            new Person("Robert Downey Jr."),
            new Person("Chris Evans"),
            new Person("Mark Ruffalo"),
            new Person("Chris Hemsworth"),
            new Person("Scarlett Johansson"),
            new Person("Jeremy Renner")
        ));
    }
    public void addLocations() {
        m.setLocations(List.of(
            new Place("Atlanta, Georgia, USA"),
            new Place("New York City, New York, USA"),
            new Place("Edinburgh, Scotland, UK"),
            new Place("Tokyo, Japan"),
            new Place("Morag, Xandar, Vormir, Asgard, Knowhere, and Titan")
            )
        );
    }
    public void addLanguages() {
        m.setLanguages(List.of("English"));
    }
    public void addGenres() {
        m.setGenres(List.of("Action", "Adventure", "Drama", "Sci-Fi"));
    }
    public void setIsTelevision() {m.setIsTelevision(false);}
    public void setIsNetflix() {m.setIsNetflix(false);}
    public void setIsIndependent() {m.setIsIndependent(true);}

}
