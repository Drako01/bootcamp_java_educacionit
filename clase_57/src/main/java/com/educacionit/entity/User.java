package com.educacionit.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, length = 256, unique = true)
	private String email;
	@Column(nullable = false, length = 256)
	private String fullName;
	@Column(nullable = false, length = 256)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
			(
				name= "users_roles",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		List<SimpleGrantedAuthority> authoritiest = new ArrayList<>();
		
		for( Role unRole: roles ) {
			if(unRole.getName() != null) {				
				authoritiest.add(new SimpleGrantedAuthority(unRole.getName()));
			}
		}
		return authoritiest;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
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

}
