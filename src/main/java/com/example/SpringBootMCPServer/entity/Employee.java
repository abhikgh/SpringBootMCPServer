package com.example.SpringBootMCPServer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email",length = 10)
	private String email;

	@Column(name = "account",length = 100)
	private String account;


}
