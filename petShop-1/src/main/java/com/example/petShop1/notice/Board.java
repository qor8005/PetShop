
package com.example.petShop1.notice;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.example.petShop1.table.Customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="board")
public class Board implements Serializable {
	@Id
	@SequenceGenerator(name = "board_seq", sequenceName = "board_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq")
	@Column(name = "bodid")
	private int bodid;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "userNo")
	private Customer customer;
	
	@Column(name = "contents")
	private String contents;
	
	@Column(name="dat")
	private LocalDateTime dat;
}
