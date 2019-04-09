package com.example.spring_hw_file_manager.hw_spring_file_manager.repositories;

import com.example.spring_hw_file_manager.hw_spring_file_manager.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FolderRepository extends JpaRepository<Folder, Long> {
}
