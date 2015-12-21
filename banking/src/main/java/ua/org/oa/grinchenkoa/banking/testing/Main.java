package ua.org.oa.grinchenkoa.banking.testing;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ua.org.oa.grinchenkoa.banking.dao.Dao;
import ua.org.oa.grinchenkoa.banking.dao.DaoImpl;
import ua.org.oa.grinchenkoa.banking.entities.Account;
import ua.org.oa.grinchenkoa.banking.entities.Client;
import ua.org.oa.grinchenkoa.banking.service.ClientServiceImpl;

/**
 * Class for testing all functions
 * 
 * @author Andrei Grinchenko
 *
 */
public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		
		Dao dao = new DaoImpl();
		
		Client client1 = new Client();
		client1.setUsername("user1");
		client1.setPassword("12345");
		client1.setFirstname("Ivan");
		client1.setLastname("Ivanov");
		client1.setEmail("mail@mail.com");
		dao.create(client1);
		Account client1Account1 = new Account();
		client1Account1.setClient(client1);
		client1Account1.setCurrentAccount(26004732357L);
		client1Account1.setBalance(1000);
		dao.create(client1Account1);
		Account client1Account2 = new Account();
		client1Account2.setClient(client1);
		client1Account2.setCurrentAccount(26004685786L);
		client1Account2.setBalance(2000);
		dao.create(client1Account2);
		List<Account> accListClient1 = new ArrayList<Account>();
		accListClient1.add(client1Account1);
		accListClient1.add(client1Account2);
		
		Client client2 = new Client();
		client2.setUsername("user2");
		client2.setPassword("54321");
		client2.setFirstname("Mike");
		client2.setLastname("Lorrie");
		client2.setEmail("mail2@mail2.com");
		dao.create(client2);
		Account client2Account1 = new Account();
		client2Account1.setClient(client2);
		client2Account1.setCurrentAccount(26005687147L);
		client2Account1.setBalance(5000);
		dao.create(client2Account1);
		Account client2Account2 = new Account();
		client2Account2.setClient(client2);
		client2Account2.setCurrentAccount(26009362475L);
		client2Account2.setBalance(10000);
		dao.create(client2Account2);
		List<Account> accListClient2 = new ArrayList<Account>();
		accListClient2.add(client2Account1);
		accListClient2.add(client2Account2);
		
		
		ClientServiceImpl service = ClientServiceImpl.getInstance();
		Account account1 = (Account)dao.read(1, Account.class);
		Account account2 = (Account)dao.read(3, Account.class);
		service.pay(account1, account2, 150);
	
		List<Account> accList = dao.readAll(Account.class);
		Client client = (Client)dao.read(1, Client.class);
		System.out.println(service.getClientBalance(client));
		System.out.println(service.getClientWithMaxBalance(accList).getLastname());
		System.out.println(service.getClientWithMinBalance(accList).getLastname());
		System.out.println("done!");
	}

}
