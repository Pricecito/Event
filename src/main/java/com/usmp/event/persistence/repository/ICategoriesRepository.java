package com.usmp.event.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.event.persistence.models.Categories;

@Repository
public interface ICategoriesRepository extends JpaRepository<Categories, Long> {

}
