package model;

import javax.persistence.*;

/**
 * Created by CoT on 6/18/18.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;
    private String password;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String service;
    private String bookingTime;

    public Customer() {
    }

    public String getService() {return service;}

    public void setService(String service) {this.service = service;}

    public String getBookingTime() {return bookingTime;}

    public void setBookingTime(String bookingTime) { this.bookingTime = bookingTime; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
