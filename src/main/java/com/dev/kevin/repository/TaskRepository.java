package com.dev.kevin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.kevin.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser_Id(long id);
	
//	@Query(value = "SELECT t FROM Task t WHERE t.user.id = :id ")
//	List<Task> findByUser_Id(@Param ("id") long id);
	
//	@Query(value = "SELECT * FROM task t WHERE t.user_id = :id" nativeQuery = true)
//	List<Task> findByUser_Id(@Param ("id") long id);
}
