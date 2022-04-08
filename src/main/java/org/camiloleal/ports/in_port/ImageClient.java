package org.camiloleal.ports.in_port;

import org.camiloleal.domain.model.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "image-microservice", path = "/image")
public interface ImageClient {

    @PostMapping
    Image saveImage(@RequestParam MultipartFile file);
}
