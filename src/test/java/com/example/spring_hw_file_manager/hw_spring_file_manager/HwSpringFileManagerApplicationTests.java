package com.example.spring_hw_file_manager.hw_spring_file_manager;

import com.example.spring_hw_file_manager.hw_spring_file_manager.models.File;
import com.example.spring_hw_file_manager.hw_spring_file_manager.models.Folder;
import com.example.spring_hw_file_manager.hw_spring_file_manager.models.User;
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
	UserRepository userRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	FileRepository fileRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateFileManager() {
		User user = new User("Travis");
		userRepository.save(user);

		Folder folder = new Folder("Documents", user);
		folderRepository.save(folder);

		File file = new File("thesis", ".doc", folder);
		fileRepository.save(file);
	}



}
