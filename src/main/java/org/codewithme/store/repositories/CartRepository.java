package org.codewithme.store.repositories;

import org.codewithme.store.entities.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CartRepository extends CrudRepository<Cart, UUID> {
}