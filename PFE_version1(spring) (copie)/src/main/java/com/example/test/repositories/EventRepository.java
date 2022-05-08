package com.example.test.repositories;

import com.example.test.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static org.hibernate.loader.Loader.SELECT;
import static org.hibernate.sql.ast.Clause.FROM;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {



    long countEventsByDateBetween(double startDate, double endDate);

 //   String getMonth(String date);
}
