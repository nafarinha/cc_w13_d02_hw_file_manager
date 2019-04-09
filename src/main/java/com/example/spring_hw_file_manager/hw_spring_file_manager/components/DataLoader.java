package com.example.spring_hw_file_manager.hw_spring_file_manager.components;

import com.example.spring_hw_file_manager.hw_spring_file_manager.models.File;
import com.example.spring_hw_file_manager.hw_spring_file_manager.models.Folder;
import com.example.spring_hw_file_manager.hw_spring_file_manager.models.User;
import com.example.spring_hw_file_manager.hw_spring_file_manager.repositories.FileRepository;
import com.example.spring_hw_file_manager.hw_spring_file_manager.repositories.FolderRepository;
import com.example.spring_hw_file_manager.hw_spring_file_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    public void run(ApplicationArguments args) {
        User user1 = new User("Travis");
        userRepository.save(user1);

        User user2 = new User("David");
        userRepository.save(user2);

        Folder folder1 = new Folder("Documents", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Documents", user2);
        folderRepository.save(folder2);

        File file10 = new File ("report", ".docx", 12.5, folder1);
        File file11 = new File("todo", ".txt", 1.1, folder1);

        File file20 = new File("homework", ".pdf", 5.1, folder2);
        File file21 = new File("cover_letter", ".docx", 7.2, folder2);
        File file22 = new File("cv", ".docx", 18.7, folder2 );

        fileRepository.save(file10);
        fileRepository.save(file11);
        fileRepository.save(file20);
        fileRepository.save(file21);
        fileRepository.save(file22);
    }
}
