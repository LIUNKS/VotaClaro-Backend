package org.app.votaclaro.Application.Service.ServiceFile;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFilesService {
    String handleFileUpload(MultipartFile file) throws Exception;
    void deleteFile(String fileName);
}
