package com.jnu.student;

public class Book {
    private int imgId;

    private String bookName;

    public Book() {
    }

    public Book(int imgId, String bookName) {
        this.imgId = imgId;
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public int getImgId() {
        return imgId;
    }
}
