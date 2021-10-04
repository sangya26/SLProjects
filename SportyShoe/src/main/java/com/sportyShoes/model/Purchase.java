package com.sportyShoes.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "purchase", schema = "shoe")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Purchase {
	
	@Id
	@GeneratedValue
	private int purchaseId;
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	@OneToMany
	private List<Product> purchasedProducts;
	
}
