package dev.salllesdev.cartservice.repository;

import dev.salllesdev.cartservice.entity.Basket;
import dev.salllesdev.cartservice.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends MongoRepository<Basket, String> {

    Optional<Basket> findByClientIdAndStatus(Long Id, Status status);
}
