package org.example.structural.proxy;

public class DatabaseExecutorImpl implements DatabaseExecutor {
    @Override
    public void executeQuery(String query) {
        System.out.println("Query: "+ query + " executed!");
    }
}
