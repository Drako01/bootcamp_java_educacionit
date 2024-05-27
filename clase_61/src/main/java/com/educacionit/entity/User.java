package com.educacionit.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User implements UserDetails {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false, length = 255, unique = true)
	private String email;

	@Column(nullable = false, length = 255)
	private String fullName;

	@Column(nullable = false, length = 255)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonIgnore
	private Set<Rol> roles = new HashSet<>();

	public void addRole(Rol role) {
		this.roles.add(role);
	}

	// retorna lista de AUTORIDAD otorgada al suuario autenticado
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Rol role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
		
		//return List.of(new SimpleGrantedAuthority(role.nombre()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

}
