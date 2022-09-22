package com.hibernate.introduction.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hibernate.introduction.model.Img;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileService {

    //private String upload_folder = ".//src//main//resources//files//";
    private String upload_folder = ".//introduction-spring-boot//src//main//resources//files//";

    public Img saveFile(MultipartFile file) throws IOException {
        Img img=null;
        
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            img=new Img(file.getOriginalFilename().toString(),upload_folder,"","");
            Path path = Paths.get(upload_folder + file.getOriginalFilename());
            Files.write(path,bytes);
        }

        return img;
    }
}
