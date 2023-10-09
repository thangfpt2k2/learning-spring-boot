package com.demo.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
		name = "tbl_account",
		uniqueConstraints = {
				@UniqueConstraint(name = "account_username_unique",columnNames = "user_name")
		}
)
public class Account implements UserDetails {

	@Id
	@SequenceGenerator(
			name = "account_sequence",
			sequenceName = "account_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = SEQUENCE,
			generator = "account_sequence"
	)
	@Column(
			name = "id",
			updatable = false
	)
	private Long id;
	
	@Column(
			name = "user_name",
			unique = true,
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String username;

	@Column(
			name = "password",
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String pass;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role.getAuthorities();
	}

	@Override
	public String getPassword() {
		return pass;
	}

	@Override
	public String getUsername() {
		return username;
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
