package ru.smartjava.springjdbc.repository;

import ru.smartjava.springjdbc.entity.Order;

import java.util.List;
import java.util.Optional;

public interface JDBCRepository {

    Optional<List<Order>> getProductByName(String Name);
}
