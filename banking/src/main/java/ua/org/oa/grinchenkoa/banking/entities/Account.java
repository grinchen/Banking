package ua.org.oa.grinchenkoa.banking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Class describes objects "account" stored in database, implements Entity interface,
 * 
 * @author Andrei Grinchenko
 * 
 * 
 */

@Entity
@Table(name="account")
public class Account implements ua.org.oa.grinchenkoa.banking.entities.Entity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="current_account")
	private long currentAccount;
	
	@Column(name="balance")
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="id_client", referencedColumnName="id", nullable=false)
	private Client client;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public long getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(long currentAccount) {
		this.currentAccount = currentAccount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
