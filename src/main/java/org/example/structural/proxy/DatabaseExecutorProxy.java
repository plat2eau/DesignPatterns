package org.example.structural.proxy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DatabaseExecutorProxy implements DatabaseExecutor {
    private final User user;
    private final DatabaseExecutorImpl databaseExecutor = new DatabaseExecutorImpl();

    @Override
    public void executeQuery(String query) throws AccessDeniedException {
        if(user.equals(User.ADMIN)) {
            databaseExecutor.executeQuery(query);
        } else {
            if(query.contains(" delete ")) {
                throw new AccessDeniedException(user.toString() + " user cannot perform delete operation");
            } else {
                databaseExecutor.executeQuery(query);
            }
        }
    }
}
