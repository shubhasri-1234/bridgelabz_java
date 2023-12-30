package HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRentalSystem {
    private Map<String, CarDetails> AllcarsMap;
    private Map<String, Customer> customerMap;
    private Map<String, RentalHistory> rentalHistoryMap;

    public CarRentalSystem() {
        AllcarsMap = new HashMap<>();
        customerMap = new HashMap<>();
        rentalHistoryMap = new HashMap<>();
    }

    public void addCar(String registrationNumber, CarDetails carDetails) {
         AllcarsMap.put(registrationNumber, carDetails);
    }

    public void addCustomer(String customerId, Customer customer) {
        customerMap.put(customerId, customer);
    }

    public void rentCar(String registrationNumber, String customerId, int rentalDuration) {
        if ( AllcarsMap.containsKey(registrationNumber) && customerMap.containsKey(customerId)) {
            CarDetails carDetails =  AllcarsMap.get(registrationNumber);
            Customer customer = customerMap.get(customerId);

            // Create a rental history entry
            RentalHistory rentalHistory = new RentalHistory(new Date(), null, rentalDuration, customer, carDetails);
            rentalHistoryMap.put(registrationNumber + "_" + customerId, rentalHistory);

            // Set the car as unavailable
             AllcarsMap.remove(registrationNumber);
            System.out.println("Car " + registrationNumber + " rented by " + customer.getName());
        } else {
            System.out.println("Invalid car or customer details.");
        }
    }

    public void returnCar(String registrationNumber, String customerId) {
        String key = registrationNumber + "_" + customerId;
        if (rentalHistoryMap.containsKey(key)) {
            RentalHistory rentalHistory = rentalHistoryMap.get(key);
            rentalHistory.setReturnDate(new Date());

            // Set the car as available again
            AllcarsMap.put(registrationNumber, rentalHistory.getCarDetails());
            System.out.println("Car " + registrationNumber + " returned by " + rentalHistory.getCustomer().getName());
        } else {
            System.out.println("Invalid rental history details.");
        }
    }

    public void displayAvailableCars() {
        System.out.println("Available Cars:");
        for (Map.Entry<String, CarDetails> entry :  AllcarsMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

        public void displayAvailableCustomers() {
        System.out.println("Available Customers:");
        for (Map.Entry<String, Customer> entry :  customerMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
    
    public void updateCustomer(String customerId, Customer updatedCustomer) {
        if (customerMap.containsKey(customerId)) {
            customerMap.put(customerId, updatedCustomer);
            System.out.println("Customer details updated successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void updateCarDetails(String registrationNumber, CarDetails updatedCar) {
        if (AllcarsMap.containsKey(registrationNumber)) {
            AllcarsMap.put(registrationNumber, updatedCar);
            System.out.println("Car details updated successfully.");
        } else {
            System.out.println("Car not found.");
        }
    }

    public void deleteCustomer(String customerId) {
        if (customerMap.containsKey(customerId)) {
            customerMap.remove(customerId);
            System.out.println("Customer removed successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void deleteCar(String registrationNumber) {
        if (AllcarsMap.containsKey(registrationNumber)) {
            AllcarsMap.remove(registrationNumber);
            System.out.println("Car removed successfully.");
        } else {
            System.out.println("Car not found.");
        }
    }

    public void viewRentalHistoryByCustomer(String customerId) {
        List<RentalHistory> customerRentalHistory = new ArrayList<>();

        for (Map.Entry<String, RentalHistory> entry : rentalHistoryMap.entrySet()) {
            if (entry.getKey().endsWith("_" + customerId)) {
                customerRentalHistory.add(entry.getValue());
            }
        }

        if (!customerRentalHistory.isEmpty()) {
            System.out.println("Rental History for Customer " + customerId + ":");
            for (RentalHistory history : customerRentalHistory) {
    
                System.out.println(history.getCarDetails().getMake() + " " + history.getCarDetails().getModel() +
                        " Rented on " + history.getRentalDate() + ", Returned on " + history.getReturnDate()+", durationInSeconds: " + "0 seconds"  );
            }
        } else {
            System.out.println("No rental history found for Customer " + customerId + ".");
        }
    }

    public void viewRentalHistoryByCar(String registrationNumber) {
        List<RentalHistory> carRentalHistory = new ArrayList<>();

        for (Map.Entry<String, RentalHistory> entry : rentalHistoryMap.entrySet()) {
            if (entry.getKey().startsWith(registrationNumber + "_")) {
                carRentalHistory.add(entry.getValue());
            }
        }

        if (!carRentalHistory.isEmpty()) {
            
            System.out.println("Rental History for Car " + registrationNumber + ":");
            for (RentalHistory history : carRentalHistory) {
                System.out.println(history.getCustomer().getName() + " Rented on " + history.getRentalDate() +
                        " and Returned on " + history.getReturnDate()+", durationInSeconds: "+ "0 seconds"  );
            }
        } else {
            System.out.println("No rental history found for Car " + registrationNumber + ".");
        }
    }

}
