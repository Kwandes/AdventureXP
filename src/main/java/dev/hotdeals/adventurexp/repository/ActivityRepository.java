package dev.hotdeals.adventurexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import dev.hotdeals.adventurexp.model.Activity;

import java.util.List;


public interface ActivityRepository extends JpaRepository<Activity, Integer>{
    List<Activity> findAllByAgeRestriction(int ageRestriction);
}
