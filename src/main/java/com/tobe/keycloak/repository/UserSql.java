package com.tobe.keycloak.repository;

public class UserSql {

    public static final String getUserByUsername = "SELECT u FROM UserEntity u WHERE u.username = :username";

    public static final String getUserByEmail = " SELECT u FROM UserEntity u WHERE u.email = :email";

    public static final String getUserCount = "SELECT count(u) FROM UserEntity u";

    public static final String getAllUsers = "SELECT u FROM UserEntity u";

    public static final String searchForUser = " SELECT u FROM UserEntity u  WHERE ( lower(u.username) LIKE :search OR u.email LIKE :search ) ORDER BY u.username";

}
