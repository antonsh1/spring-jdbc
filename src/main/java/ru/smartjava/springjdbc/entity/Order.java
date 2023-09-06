package ru.smartjava.springjdbc.entity;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

@Entity
@ToString
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private Date date;
  private String productName;
  @OneToOne
  private Customer customer;
  private long amount;

}
