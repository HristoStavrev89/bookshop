package stockmanager.dtos.seedDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

public class BookDto {

    @Expose
    private String author;
    @Expose
    private String country;

    @JsonIgnore
    private String imageLink;

    @Expose
    private String language;

    @JsonIgnore
    private String link;

    @Expose
    private int pages;

    @Expose
    private String title;

    @Expose
    private int year;

    public BookDto() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}







//"author": "Chinua Achebe",
//        "country": "Nigeria",
//        "imageLink": "images/things-fall-apart.jpg",
//        "language": "English",
//        "link": "https://en.wikipedia.org/wiki/Things_Fall_Apart\n",
//        "pages": 209,
//        "title": "Things Fall Apart",
//        "year": 1958