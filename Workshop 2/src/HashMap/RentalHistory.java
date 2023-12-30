package HashMap;

import java.util.Date;

public class RentalHistory {
    private Date rentalDate;
    private Date returnDate;
    private int rentalDuration;
    private Customer customer;
    private CarDetails carDetails;

    public RentalHistory(Date rentalDate, Date returnDate, int rentalDuration, Customer customer, CarDetails carDetails) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.rentalDuration = rentalDuration;
        this.customer = customer;
        this.carDetails = carDetails;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CarDetails getCarDetails() {
        return carDetails;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
