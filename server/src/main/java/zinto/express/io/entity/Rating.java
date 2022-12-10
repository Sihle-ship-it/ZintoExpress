package zinto.express.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Rating {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rateId;
	private double rate;
	private int count;
	
	@OneToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name="productId", nullable = false)
	@JsonIgnore
	private Product product;
	
	
	public Rating() {
		super();
	}
	
	public Rating(float rate, int count) {
		super();
		this.rate = rate;
		this.count = count;
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public Long getRateId() {
		return rateId;
	}

	public void setRateId(Long rateId) {
		this.rateId = rateId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
		
}
