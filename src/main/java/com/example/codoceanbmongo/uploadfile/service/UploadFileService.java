package com.example.codoceanbmongo.uploadfile.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {
     String uploadImage(MultipartFile file, String folderName);
     String deleteImage(String urlImage);
}
