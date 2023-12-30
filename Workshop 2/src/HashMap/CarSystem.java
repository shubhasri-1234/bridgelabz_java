package HashMap;

public class CarSystem {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        // Adding cars
        CarDetails car1Details = new CarDetails("car1", "model1", 2022, "Blue", 250.00);
        rentalSystem.addCar("Register1", car1Details);

        CarDetails car2Details = new CarDetails("car2", "model2", 2021, "Red", 220.00);
        rentalSystem.addCar("Register2", car2Details);

        CarDetails car3Details = new CarDetails("car3", "model3", 2022, "Blue", 250.00);
        rentalSystem.addCar("Register3", car3Details);

        CarDetails car4Details = new CarDetails("car4", "model4", 2021, "Red", 220.00);
        rentalSystem.addCar("Register4", car4Details);

        // Adding customers
        Customer customer1 = new Customer("Name1", "9785736756");
        rentalSystem.addCustomer("Cust1", customer1);

        Customer customer2 = new Customer("Name2", "9573457345");
        rentalSystem.addCustomer("Cust2", customer2);

        // Renting cars
        rentalSystem.rentCar("Register1", "Cust1", 7);
        rentalSystem.rentCar("Register2", "Cust2", 5);

        // Display available cars
        rentalSystem.displayAvailableCars();

        // Returning cars
        rentalSystem.returnCar("Register1", "Cust1");
        rentalSystem.returnCar("Register2", "Cust2");

        // Display available cars after returning
        rentalSystem.displayAvailableCars();
        rentalSystem.displayAvailableCustomers();

        // View rental history by customer
        rentalSystem.viewRentalHistoryByCustomer("Cust1");

        // View rental history by car
        rentalSystem.viewRentalHistoryByCar("Register1");

        // Update customer
        Customer updatedCustomer1 = new Customer("Nameupdated", "8973627876");
        rentalSystem.updateCustomer("Cust1", updatedCustomer1);
        
        // Delete customer
        rentalSystem.deleteCustomer("Cust2");

        // Update car
        CarDetails updatedCarDetails = new CarDetails("car3", "model3", 2022, "silver", 250.00);
        rentalSystem.updateCarDetails("Register3", updatedCarDetails);

        // Delete car details
        rentalSystem.deleteCar("Register3");

        // Display available cars after updating and deleting cars
        rentalSystem.displayAvailableCars();

        rentalSystem.displayAvailableCustomers();
    }
}
