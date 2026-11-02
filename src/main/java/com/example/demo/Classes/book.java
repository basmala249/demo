package com.example.demo.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class book {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer ID;

    String author ;
    String title ;
    String genre ;
    Double price ;
    String publish_date ;
    String description ;

    public book() {
    }
    
    public book(String author, String title, String genre, Double price, String publish_date, String description) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.publish_date = publish_date;
        this.description = description;
    }
    public Integer getId(){
        return ID ;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getPublish_date() {
        return publish_date;
    }
    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "book [ID=" + ID + ", author=" + author + ", title=" + title + ", genre=" + genre + ", price=" + price
                + ", publish_date=" + publish_date + ", description=" + description + "]";
    }
    
}
