package org.mahesh.dto;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ADMIN on 09-11-2014.
 */
@Entity
@Table (name = "USER_DETAILS")
public class UserDetailsOld2 {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private int userId;
    private String userName;
    /*This is type of configuration is called Value type Entity */
    @ElementCollection (fetch = FetchType.EAGER)
    @JoinTable (name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    //private Set<AddressOld2> listOfAddreses = new HashSet<AddressOld2>();
    @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")}, generator = "hilo-gen", type = @Type(type = "long"))
    private Collection<AddressOld2> listOfAddreses = new ArrayList<AddressOld2>();

    public Collection<AddressOld2> getListOfAddreses() {
        return listOfAddreses;
    }

    public void setListOfAddreses(Collection<AddressOld2> listOfAddreses) {
        this.listOfAddreses = listOfAddreses;
    }

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
