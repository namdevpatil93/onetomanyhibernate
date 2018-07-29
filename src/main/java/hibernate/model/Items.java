package hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Items {

	private long id;
	private double itemTotal;
	private int quantity;
	private Cart cart;

	// Hibernate requires no-args constructor
	public Items() {
	}

	public Items( double total, int qty, Cart c) {
		this.itemTotal = total;
		this.quantity = qty;
		this.cart = c;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_id")	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	public double getItemTotal() {
		return itemTotal;
	}


	public void setItemTotal(double itemTotal) {
		this.itemTotal = itemTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id", nullable = false)
	public Cart getCart() 
	{
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}


}
