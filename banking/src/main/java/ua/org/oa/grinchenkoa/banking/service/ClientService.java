package ua.org.oa.grinchenkoa.banking.service;

import java.util.List;
import ua.org.oa.grinchenkoa.banking.entities.Account;
import ua.org.oa.grinchenkoa.banking.entities.Client;

/**
 * 
 * Interface describes client's service operations
 * 
 * 
 * @author Andrei Grinchenko
 *
 */

public interface ClientService {
	/**
	 * 
	 * @param client Client's object reference
	 * @return Client balance
	 */
	double getClientBalance(Client client);
	
	/**
	 * 
	 * @param accounts All bank's accounts' list
	 * @return Client with max balance
	 */
	Client getClientWithMaxBalance(List<Account> accounts);
	
	/**
	 * 
	 * @param accounts All bank's accounts' list
	 * @return Client with min balance
	 */
	Client getClientWithMinBalance(List<Account> accounts);
}
