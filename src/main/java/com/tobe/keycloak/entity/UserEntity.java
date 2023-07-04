package com.tobe.keycloak.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tobe.keycloak.repository.UserSql;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@NamedQueries({
        @NamedQuery(name="getUserByUsername", query=UserSql.getUserByUsername),
        @NamedQuery(name="getUserByEmail", query=UserSql.getUserByEmail),
        @NamedQuery(name="getUserCount", query=UserSql.getUserCount),
        @NamedQuery(name="getAllUsers", query=UserSql.getAllUsers),
        @NamedQuery(name="searchForUser", query= UserSql.searchForUser),
})
@Table(name = "user_tb")
@Entity
public class UserEntity {

    @Id
    private String id;

    @Column(columnDefinition = "varchar(255) comment '로그인 아이디'")
    private String username;

    @Column(columnDefinition = "varchar(150) comment '이메일'")
    private String email;

    @Column(columnDefinition = "varchar(255) comment '비밀번호'")
    private String password;

    @Column(columnDefinition = "varchar(150) comment '휴대폰 번호'")
    private String phone;

    @Column(name = "first_name" ,columnDefinition = "varchar(255) comment '성'")
    private String firstName;

    @Column(name="last_name",columnDefinition = "varchar(255) comment '이름'")
    private String lastName;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name="created_at",columnDefinition = "datetime comment '생성일'")
    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
