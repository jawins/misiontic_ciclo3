package com.hibernate.introduction.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hibernate.introduction.model.Img;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

@Service
public class UploadFileService {

    //private String upload_folder = ".//src//main//resources//files//";
    private String upload_folder = ".//introduction-spring-boot//src//main//resources//files//";

    public String saveFile(MultipartFile file) throws IOException {
        Img img=null;
        String encodedString ="";
        byte[] bytes=null;
        if(!file.isEmpty()){
             bytes = file.getBytes();
            img=new Img(file.getOriginalFilename().toString(),upload_folder,"","");

            Path path = Paths.get(upload_folder + file.getOriginalFilename());
            Files.write(path,bytes);
        }

        try {
            String ruta = upload_folder+ "//"+file.getOriginalFilename() +".txt";

            encodedString = Base64.getEncoder().encodeToString(bytes);
            String contenido =encodedString;
            File files = new File(ruta);
            // Si el archivo no existe es creado
            if (!files.exists()) {
                files.createNewFile();
            }
            FileWriter fw = new FileWriter(files);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encodedString;
    }
}
