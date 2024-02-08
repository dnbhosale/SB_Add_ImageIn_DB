package com.dn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image storeImage(String imageName, String imagePath, MultipartFile file) throws IOException {
        byte[] imageData = file.getBytes();
        Image image = new Image(imageName, imagePath, imageData);
        return imageRepository.save(image);
    }

    public Optional<Image> getImageById(Long id) {
        return imageRepository.findById(id);
    }
}
