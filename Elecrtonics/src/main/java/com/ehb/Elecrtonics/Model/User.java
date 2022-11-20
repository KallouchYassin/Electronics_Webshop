package com.ehb.Elecrtonics.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id


    private String username;
    private String userFirstname;
    private String userLastname;
    private String userPassword;

    @ManyToMany(fetch= FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
            @JoinColumn(name="USER_ID")
    },
            inverseJoinColumns = {
            @JoinColumn(name="ROLE_ID")
            }

    )
    private Set<Role> role;





    



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}
