package com.hibernate.introduction.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hibernate.introduction.model.Img;
import com.hibernate.introduction.services.UploadFileService;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadFileController {

    @Autowired
    private UploadFileService uploadFileService;

    
    @CrossOrigin(origins = "http://localhost:5501")
    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
       String msg="";
       Img img;
        if (file.isEmpty()) {
           // return  "Seleccionar un archivo";
           return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
        }

       
        try {
            img=uploadFileService.saveFile(file);
            //return "subido correctamente---";
            return new ResponseEntity<Object>(img, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            msg=e.getMessage() + e.toString();
        }

       // return "subido correctamente"+ msg;
       return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
    }

    /** ACCIONES */
  @CrossOrigin(origins = "http://localhost:5501")
  @GetMapping
  public String obtenerPersonas() {
    return "Hola";
  }
}

