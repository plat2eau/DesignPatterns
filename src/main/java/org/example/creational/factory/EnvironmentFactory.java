package org.example.creational.factory;

import org.example.creational.factory.environments.Beta;
import org.example.creational.factory.environments.Prod;
import org.example.creational.factory.exceptions.NoSuchStageException;
import org.example.creational.factory.environments.Alpha;
import org.example.creational.factory.environments.Gamma;

public class EnvironmentFactory {

    public Environment getEnvironment(Stages stage) throws NoSuchStageException {
        switch (stage) {
            case ALPHA -> {
                return new Alpha();
            }
            case BETA -> {
                return new Beta();
            }
            case GAMMA -> {
                return new Gamma();
            }
            case PROD -> {
                return new Prod();
            }
            default -> throw new NoSuchStageException();
        }
    }
}
