/**
 * @ File name: ComedyMovieBuilder.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:54:14
 */

import java.util.List;

public class ComedyMovieBuilder extends MovieBuilder {

    // Métodos implementados de acordo com o filme concreto de Comédia que se pretende construir
    public void addTitle() {m.setTitle("The Man from Toronto");}
    public void addYear() {m.setYear(2021);}
    public void addDirector() {m.setDirector(new Person("Patrick Hughes"));}
    public void addWriter() {m.setWriter(new Person("Robbie Fox"));}
    public void addSeries() {m.setSeries(null);}
    public void addCast() {
        m.setCast(List.of(
            new Person("Kevin Hart"),
            new Person("Woody Harrelson"),
            new Person("Kaley Cuoco"),
            new Person("Ellen Barkin")
        ));
    }
    public void addLocations() {
        m.setLocations(List.of(
            new Place("Toronto, Ontario, Canada"),
            new Place("Atlanta, Georgia, USA")
            )
        );
    }
    public void addLanguages() {
        m.setLanguages(List.of("English"));
    }
    public void addGenres() {
        m.setGenres(List.of("Comedy", "Action"));
    }
    public void setIsTelevision() {m.setIsTelevision(false);}
    public void setIsNetflix() {m.setIsNetflix(false);}
    public void setIsIndependent() {m.setIsIndependent(true);}  
}
