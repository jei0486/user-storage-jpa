package com.tobe.keycloak.provider;

import org.jboss.logging.Logger;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

import javax.naming.InitialContext;


public class TobeUserStorageProviderFactory implements UserStorageProviderFactory<TobeUserStorageProvider> {
    public static final String PROVIDER_ID = "tobe-user-storage-jpa";
    public static final String DESCRIPTION = "JPA datasource User Storage Provider";
    public static final String CLOSE_MSG = "<<<<<< Closing factory";

    private static final Logger logger = Logger.getLogger(TobeUserStorageProviderFactory.class);

    @Override
    public TobeUserStorageProvider create(KeycloakSession session, ComponentModel model) {
        return new TobeUserStorageProvider(session, model);
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getHelpText() {
        return DESCRIPTION;
    }

    @Override
    public void close() {
        logger.info(CLOSE_MSG);
    }
}
