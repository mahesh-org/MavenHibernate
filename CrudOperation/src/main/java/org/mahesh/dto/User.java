package org.mahesh.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ADMIN on 09-11-2014.
 */
@Entity
@Table (name = "USER")
public class User {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private int userId;
    private String userName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
