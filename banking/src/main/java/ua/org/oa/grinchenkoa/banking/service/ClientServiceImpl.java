package ua.org.oa.grinchenkoa.banking.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import ua.org.oa.grinchenkoa.banking.dao.Dao;
import ua.org.oa.grinchenkoa.banking.dao.DaoImpl;
import ua.org.oa.grinchenkoa.banking.entities.Account;
import ua.org.oa.grinchenkoa.banking.entities.Client;
import ua.org.oa.grinchenkoa.banking.entities.Payment;

/**
 * 
 * Class implements ClientService specification and banking operations
 * 
 * @author Andrei Grinchenko
 *
 */


public class ClientServiceImpl implements ClientService {
	
	/**
	 * ClientServiceImpl instance
	 */
	private static ClientServiceImpl instance;
	
	/**
	 * Private constructor, unable to create instance outside
	 */
	private ClientServiceImpl() {} 
	
	/**
	 * Singleton of getting instance
	 * @return single ClientServiceIpml instance
	 */
	public static ClientServiceImpl getInstance() {
		if (instance == null)
			instance = new ClientServiceImpl();
		return instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public double getClientBalance(Client client) {
		double balance = 0.0;
		for(Account account : client.getAccounts()) {
			balance += account.getBalance();
		}
		return balance;
	}

	/**
	 * {@inheritDoc}
	 */
	public Client getClientWithMaxBalance(List<Account> accounts) {
		try {
			Client client = accounts.get(0).getClient();
			double balance = accounts.get(0).getBalance();
			for (Account account : accounts) {
				if (account.getBalance() > balance) { 
					balance = account.getBalance();
					client = account.getClient();
				}
			}
			return client;
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("There are no accounts");
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Client getClientWithMinBalance(List<Account> accounts) {
		try {
			Client client = accounts.get(0).getClient();
			double balance = accounts.get(0).getBalance();
			for (Account account : accounts) {
				if (account.getBalance() < balance) { 
					balance = account.getBalance();
					client = account.getClient();
				}
			}
			return client;
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("There are no accounts");
		}
		return null;
	}

	/**
	 * 
	 * @param payerAccount Payer's account
	 * @param recipientAccount Recipient's account
	 * @param sum Sum
	 * @throws SQLException
	 * @throws IOException
	 */
	public void pay(Account payerAccount, Account recipientAccount, double sum) throws SQLException, IOException {
		double payerAccountBallance = payerAccount.getBalance();
		double recipientAccountBallance = recipientAccount.getBalance();
		Dao dao = new DaoImpl();
		if (payerAccountBallance >= sum) {
			payerAccount.setBalance(payerAccountBallance - sum);
			recipientAccount.setBalance(recipientAccountBallance + sum);
			Payment payment = new Payment();
			payment.setPayerAccount(payerAccount);
			payment.setRecipientAccount(recipientAccount);
			payment.setTotal(sum);
			dao.create(payment);
			dao.update(payerAccount);
			dao.update(recipientAccount);
		}
		else {
			System.out.println("No enough money");
		}
	}

}
