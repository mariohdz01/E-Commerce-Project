package com.tts.ecommerce.model;

import java.util.Collection;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@SuppressWarnings("serial")
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	String username;
	@NotEmpty
	String password;
	
	@ElementCollection
	Map<Product, Integer> cart;
	
	public User(@NotEmpty String username, @NotEmpty String password, Map<Product, Integer> cart) {
        this.username = username;
        this.password = password;
        this.cart = cart;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Map<Product, Integer> getCart() {
		return cart;
	}

	public void setCart(Map<Product, Integer> cart) {
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public User() {
		
	}

}