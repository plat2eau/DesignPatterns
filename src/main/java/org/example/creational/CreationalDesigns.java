package org.example.creational;

import org.example.creational.builder.Phone;
import org.example.creational.builder.PhoneBuilder;
import org.example.creational.factory.Environment;
import org.example.creational.factory.EnvironmentFactory;
import org.example.creational.factory.Stages;
import org.example.creational.factory.exceptions.NoSuchStageException;
import org.example.creational.prototype.BookShop;

public class CreationalDesigns {

    public void builder() {
        // Makes it easier to create object instead of remembering all params or passing null values
        Phone phone = new PhoneBuilder()
                .setOs("Android")
                .setBattery(3000)
                .build();

        System.out.println(phone);
    }

    public void factory() {
        // Makes it easier to get objects based on certain conditions
        try {
            Environment environment = new EnvironmentFactory().getEnvironment(Stages.ALPHA);
            environment.printStage();
        } catch (NoSuchStageException e) {
            throw new RuntimeException(e);
        }
    }

    public void prototype() {
        BookShop bookShop = new BookShop();
        bookShop.setName("Universal");
        bookShop.loadDataFromDatabase();

        // even without loading data from db, we created another object
        BookShop newBookShop = bookShop.clone();
        newBookShop.setName("A1");

        bookShop.getBooks().remove(2);

        System.out.println(bookShop);
        System.out.println(newBookShop);
    }
}
