package com.example.account.entity;

import java.math.BigDecimal;
import java.util.List;

//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal balance;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal newBalance) {
		this.balance = newBalance;
	}

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

}
