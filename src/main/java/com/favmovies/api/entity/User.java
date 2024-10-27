package com.favmovies.api.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;
	
	@NotNull
	@Column(name = "name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;
	
	@Email
	@NotNull
	@Column(name = "email")
	private String userEmail;
	
	@NotNull
	@DateTimeFormat
	@Column(name = "created_at", updatable = false)
	private LocalDate createdAt;
	
	@NotNull
	@DateTimeFormat
	@Column(name = "modified_at")
	private LocalDate modifiedAt;
	
	@NotNull
	@Column(name = "is_active")
	private Boolean isActive;
	
	@PrePersist
	private void onCreate() {
		this.createdAt = LocalDate.now();
		this.modifiedAt = LocalDate.now();
	}
	
	@PreUpdate
	private void onUpdate() {
		this.modifiedAt = LocalDate.now();
	}

}
