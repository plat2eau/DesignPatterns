package org.example.creational.prototype;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookShop implements Cloneable {

    private String name;
    private List<Book> books = new ArrayList<>();

    public void loadDataFromDatabase() {
        for (int i = 0; i < 10 ;i++){
            Book b = new Book();
            b.setId(i);
            b.setName("Book " + i);
            books.add(b);
        }
    }

    @Override
    public BookShop clone() {
        BookShop clone = new BookShop();
        for (Book b: this.getBooks()) {
            clone.getBooks().add(b);
        }
        return clone;
    }
}
