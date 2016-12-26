package CustomerDaoPackage;

import java.util.List;

public interface CustomerDao {

	Customer getCustomer(int customer_id);

	List<Customer> getAllCustomers();

	boolean addCustomer(Customer c);

	boolean updateCustomer(Customer c);
}