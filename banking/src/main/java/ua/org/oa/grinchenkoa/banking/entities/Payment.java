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
 * Class describes objects "payment" stored in database, implements Entity interface,
 * 
 * @author Andrei Grinchenko
 * 
 * 
 */

@Entity
@Table(name="payment")
public class Payment implements ua.org.oa.grinchenkoa.banking.entities.Entity {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="total")
	private double total;
	
	@ManyToOne
	@JoinColumn(name="id_payeraccount", referencedColumnName="id", nullable=false)
	private Account payerAccount;
	
	@ManyToOne
	@JoinColumn(name="id_recipientaccount", referencedColumnName="id", nullable=false)
	private Account recipientAccount;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Account getPayerAccount() {
		return payerAccount;
	}

	public void setPayerAccount(Account payerAccount) {
		this.payerAccount = payerAccount;
	}


	public Account getRecipientAccount() {
		return recipientAccount;
	}

	public void setRecipientAccount(Account recipientAccount) {
		this.recipientAccount = recipientAccount;
	}

	
}
