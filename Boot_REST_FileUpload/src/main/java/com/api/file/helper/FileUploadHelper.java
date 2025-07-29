package com.api.file.helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    private String uploadDir;

    public FileUploadHelper() throws IOException {
        // Do not resolve path here to avoid premature ClassPathResource usage
    }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean f = false;

        try {
            // Initialize uploadDir when the method is called
            if (uploadDir == null) {
                // This will only work if static/image/ exists under src/main/resources
                uploadDir = new ClassPathResource("static/image/").getFile().getAbsolutePath();
            }

            Files.copy(
                multipartFile.getInputStream(),
                Paths.get(uploadDir + "//" + multipartFile.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING
            );
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
