package com.example.Practice.maping;

import lombok.Data;

@Data
class Book{
    private int bookId;
    private String bookName;
}

@Data
class DemoBook{
    private int bookId;
    private String  bookName;
}
public class BeanPropertiesCopy {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("Middle Class Mohan");
        DemoBook demoBook = new DemoBook();
        org.springframework.beans.BeanUtils.copyProperties(book, demoBook);
        //1) cant handle null values
        //2) similar name property copy
        //3) didnt do type conversion
        System.out.print("Demo Book Id :"+demoBook.getBookId());
        System.out.print("Demo Book Name :"+demoBook.getBookName());
    }
}
