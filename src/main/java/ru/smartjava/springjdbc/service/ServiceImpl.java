package ru.smartjava.springjdbc.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smartjava.springjdbc.entity.Order;
import ru.smartjava.springjdbc.repository.JDBCRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements JDBCService {

    private final JDBCRepository repository;
    private final Gson gson = new GsonBuilder().create();
    @Override
    public Optional<String> getProductByName(String name) {
        Optional<List<Order>> customerList = repository.getProductByName(name);
        return customerList.map(gson::toJson);
    }
}
