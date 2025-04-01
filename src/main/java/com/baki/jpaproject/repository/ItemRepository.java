package com.baki.jpaproject.repository;

import com.baki.jpaproject.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
