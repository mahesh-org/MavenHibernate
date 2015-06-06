package org.mahesh.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ADMIN on 02-11-2014.
 */
@Entity
@Table (name = "USER_DETAILS")
public class UserDetailsOld1 {
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private int userId;
    //@Transient
    private String username;
    //@Temporal (TemporalType.TIME)
    private Date joinedDate;
    //private String address;
    //@Lob
    private String description;
    @Embedded
    private AddressOld2 homeAddressOld2;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "office_street_name")),
            @AttributeOverride(name = "city", column = @Column(name = "office_city_name")),
            @AttributeOverride(name = "state", column = @Column(name = "office_state_name")),
            @AttributeOverride(name = "pincode", column = @Column(name = "office_pincode_name"))
    })
    private AddressOld2 officeAddressOld2;

    public AddressOld2 getHomeAddressOld2() {
        return homeAddressOld2;
    }

    public void setHomeAddressOld2(AddressOld2 homeAddressOld2) {
        this.homeAddressOld2 = homeAddressOld2;
    }

    public AddressOld2 getOfficeAddressOld2() {
        return officeAddressOld2;
    }

    public void setOfficeAddressOld2(AddressOld2 officeAddressOld2) {
        this.officeAddressOld2 = officeAddressOld2;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    /*public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }*/

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
