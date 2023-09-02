package ru.smartjava.springjdbc.service;

import java.util.List;

public interface JDBCService {

    List<String> getProductByName(String Name);
}
