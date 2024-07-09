/**
 * @ File name: Movie.java
 * @ Author1: Danilo Silva 113384
 * @ Author2: Tomás Fernandes 112981
 * @ Modified time: 2024-04-05 12:54:27
 */


import java.util.List;

public class Movie {
    private String title;
    private int year;
    private Person director;
    private Person writer;
    private String series;
    private List<Person> cast;
    private List<Place> locations;
    private List<String> languages;
    private List<String> genres;
    private boolean isTelevision;
    private boolean isNetflix;
    private boolean isIndependent;

    public void setTitle(String title) {this.title = title;}
    public void setYear(int year) {this.year = year;}
    public void setDirector(Person director) {this.director = director;}
    public void setWriter(Person writer) {this.writer = writer;}
    public void setSeries(String series) {this.series = series;}
    public void setCast(List<Person> cast) {this.cast = cast;}
    public void setLocations(List<Place> locations) {this.locations = locations;}
    public void setLanguages(List<String> languages) {this.languages = languages;}
    public void setGenres(List<String> genres) {this.genres = genres;}
    public void setIsTelevision(boolean isTelevision) {this.isTelevision = isTelevision;}
    public void setIsNetflix(boolean isNetflix) {this.isNetflix = isNetflix;}
    public void setIsIndependent(boolean isIndependent) {this.isIndependent = isIndependent;}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: " + title + "\n");
        sb.append("Year: " + year + "\n");
        sb.append("Director: " + director.getName() + "\n");
        sb.append("Writer: " + writer.getName() + "\n");
        sb.append("Series: " + series + "\n");
        sb.append("Cast: \n");
        for (Person p : this.cast) { sb.append("    - " + p.getName() + "\n");}
        sb.append("Locations: \n");
        for (Place p : this.locations) { sb.append("    - " + p.getLocation() + "\n");}
        sb.append("Languages: \n");
        for (String s : this.languages) { sb.append("    - " + s + "\n");}
        sb.append("Genres: \n");
        for (String s : this.genres) { sb.append("    - " + s + "\n");}
        sb.append("Is Television: " + isTelevision + "\n");
        sb.append("Is Netflix: " + isNetflix + "\n");
        sb.append("Is Independent: " + isIndependent + "\n");

        return sb.toString();
    }
}
