package com.onlycgl.cgl.createMocktest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlycgl.cgl.createMocktest.entity.MockTest;
import java.util.List;

@Repository
public interface MockTestRepository extends JpaRepository<MockTest, Long> {
    
    // Example custom query method to find mock tests by title
    List<MockTest> findByTitle(String title);

    // Example custom query method to find all mock tests by a certain duration
    List<MockTest> findByDuration(Integer duration);

    // Example custom query method to find mock tests by title containing a certain string (like search)
    List<MockTest> findByTitleContainingIgnoreCase(String title);

}
