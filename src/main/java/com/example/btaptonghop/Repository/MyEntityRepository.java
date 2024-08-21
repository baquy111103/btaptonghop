package com.example.btaptonghop.Repository;

import com.example.btaptonghop.Model.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {
}
