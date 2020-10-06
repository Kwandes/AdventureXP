package dev.hotdeals.adventurexp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotdeals.adventurexp.model.Activity;



public interface ActivityRepository extends JpaRepository<Activity, Integer>{

}
