/**
 * @ File name: HorrorMovieBuilder.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:54:21
 */

package lab06.movie;

import java.util.List;

public class HorrorMovieBuilder extends MovieBuilder {

    // Métodos implementados de acordo com o filme concreto de Terror que se pretende construir
    public void addTitle() {m.setTitle("The Conjuring 2");}
    public void addYear() {m.setYear(2016);}
    public void addDirector() {m.setDirector(new Person("James Wan"));}
    public void addWriter() {m.setWriter(new Person("Chad Hayes"));}
    public void addSeries() {m.setSeries("The Conjuring");}
    public void addCast() {
        m.setCast(List.of(
            new Person("Vera Farmiga"),
            new Person("Patrick Wilson"),
            new Person("Madison Wolfe"),
            new Person("Frances O'Connor"),
            new Person("Lauren Esposito"),
            new Person("Benjamin Haigh")
        ));
    }
    public void addLocations() {
        m.setLocations(List.of(
            new Place("London, England, UK"),
            new Place("Los Angeles, California, USA"),
            new Place("Hollywood, California, USA")
            )
        );
    }
    public void addLanguages() {
        m.setLanguages(List.of("English"));
    }
    public void addGenres() {
        m.setGenres(List.of("Horror", "Mystery", "Thriller"));
    }   
    public void setIsTelevision() {m.setIsTelevision(true);}
    public void setIsNetflix() {m.setIsNetflix(false);}
    public void setIsIndependent() {m.setIsIndependent(false);}
}
