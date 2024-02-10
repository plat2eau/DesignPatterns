package org.example.structural.proxy;

public interface DatabaseExecutor {

    void executeQuery(String query) throws AccessDeniedException;
}
