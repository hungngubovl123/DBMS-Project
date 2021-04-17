package com.ute.dbms.bkwebshop.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "USERS")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false, unique = true)
    private String password;

    @ManyToMany
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    public User() {
    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    // @Override
    // public int hashCode() {
    //     return Objects.hash(id, email, password, loggedIn);
    // }
    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     User other = (User) obj;
    //     return Objects.equals(email, other.email) &&
    //          Objects.equals(password, other.password);
    // }
    // @Override
    // public String toString(){
    //     return "User{" +
    //             "id=" + id +
    //             ", email='" + email +'\'' +
    //             ", password='" + password + '\'' +
    //             ", loggedIn=" + loggedIn +
    //             '}';
    // }
}
