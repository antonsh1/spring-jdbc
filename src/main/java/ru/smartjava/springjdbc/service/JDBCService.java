package ru.smartjava.springjdbc.service;

import java.util.Optional;

public interface JDBCService {

    Optional<String> getProductByName(String Name);
}
