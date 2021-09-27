package stockmanager.dtos.viewDtos.bookDtos;

import com.google.gson.annotations.Expose;

public class ViewBookDto {

    @Expose
    private String id;
    @Expose
    private String author;
    @Expose
    private String country;
    @Expose
    private String language;
    @Expose
    private int pages;
    @Expose
    private String title;
    @Expose
    private int year;


    public ViewBookDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
