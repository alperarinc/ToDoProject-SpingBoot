package com.totoProject.repositoriy;

import com.totoProject.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoriy extends JpaRepository<Task, Long>{

}
