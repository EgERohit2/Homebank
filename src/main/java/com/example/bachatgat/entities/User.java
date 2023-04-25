package com.example.bachatgat.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="bachatgat")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	private int id;
	private String name;
	private double monthly;
	private double principal;
	private double penalty;
	private double loan;
	private String loanDate;
	
	
}
