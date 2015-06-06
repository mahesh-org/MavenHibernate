package com.collectionType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

/**
 * Created by maheshwar on 5/30/2015.
 */
@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {
    @Id
    @Column (name = "USER_ID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int userId;
    @Column (name = "USER_NAME")
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable (name = "USER_ADDRESS",
                joinColumns = @JoinColumn (name = "USER_ID")
    )
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = @Column(name = "ADDRESS_ID"), generator = "hilo-gen", type = @Type(type = "long"))
    private Collection<Address> listOfAddress = new ArrayList<Address>();
    @Lob
    private String description;
    @Transient //the column is not going to persist into the database
    private String columnSkip;

    public Collection<Address> getListOfAddress() {
        return listOfAddress;
    }

    public void setListOfAddress(Collection<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName + " from getter";
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColumnSkip() {
        return columnSkip;
    }

    public void setColumnSkip(String columnSkip) {
        this.columnSkip = columnSkip;
    }

    @Override
    public String toString() {
        return "com.collectionType.UserDetails{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", joinedDate=" + joinedDate +
                ", description='" + description + '\'' +
                ", columnSkip='" + columnSkip + '\'' +
                ", listOfAddress=" + listOfAddress +
                '}';
    }
}
