package com.hurix.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hurix.model.Info;

@Repository
public interface InfoRepository extends JpaRepository<Info, Long> {

}
