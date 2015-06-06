Hibernate configuraiton
Model Object - use annotation
Service Method


1) create a session-factory - it creates a sessions
2) create sessions from session-factory
3) Use the session to save teh model object


@Transient
@Temporal
@Lob

/*****/
@Embeddable
public class Address {}

@Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "street", column = @Column(name = "OFFICE_STREET_NAME")
            ),
            @AttributeOverride(
                    name = "city", column = @Column(name = "OFFICE_CITY_NAME")
            ),
            @AttributeOverride(
                    name = "state", column = @Column(name = "OFFICE_STATE_NAME")
            ),
            @AttributeOverride(
                    name = "pincode", column = @Column(name = "OFFICE_PINCODE_NAME")
            ),
    })
    private Address officeAddress;
/******/
Can not use both @Id and @Embedded, instead use @EmbededId

Natural and serogate key:

serogate key : non bussined purpose (Ex: auto generated values)
Natural key : for the bussiness purpose (Ex: username or email, These must be uniqyue for some bussiness purpose)


Entity and value object:
Entity : has meaning on its own (Ex: User table or class has its own meaning belongs to user)
Value : does not have its own meening (Ex: if the address is not belongs to user table. then there is no meaning for it to find whose address it is)
Understand how value object (Address) linked with Entity (user) object.

Eager and Lazy:
There two are called as fetch stratage.
Lazy: Intaitlly only those are required, Ex list of objects will not be initialled, only when u call getter run, hibernate pulls all the value.
Eager:


