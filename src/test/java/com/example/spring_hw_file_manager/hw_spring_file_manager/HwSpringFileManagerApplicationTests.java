package com.example.spring_hw_file_manager.hw_spring_file_manager;

import com.example.spring_hw_file_manager.hw_spring_file_manager.repositories.FileRepository;
import com.example.spring_hw_file_manager.hw_spring_file_manager.repositories.FolderRepository;
import com.example.spring_hw_file_manager.hw_spring_file_manager.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HwSpringFileManagerApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;
	@Test
	public void contextLoads() {
	}

}
