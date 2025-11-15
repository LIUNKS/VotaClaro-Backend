package org.app.votaclaro.Application.Service.ServiceFile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@Slf4j
public class UploadFilesServiceImpl implements IUploadFilesService {

    @Override
    public String handleFileUpload(MultipartFile file) throws Exception {
        try {
            // Verificar archivo y obtener extensión
            String ext = validarYObtenerExtension(file);

            // Crear nombre único
            String newFileName = UUID.randomUUID() + ext;

            // Carpeta donde se guardan las imágenes
            String baseDir = System.getProperty("user.dir") + "/uploads/pictures";
            File folder = new File(baseDir);
            if (!folder.exists()) folder.mkdirs();

            // Guardar archivo
            Path path = folder.toPath().resolve(newFileName);
            Files.write(path, file.getBytes());

            log.info("✅ Imagen guardada en: {}", path.toAbsolutePath());
            return newFileName;

        } catch (Exception e) {
            log.error("❌ Error al subir archivo: {}", e.getMessage());
            throw new Exception("Error al subir el archivo: " + e.getMessage());
        }
    }

    @Override
    public void deleteFile(String fileName) {
        try {
            if( fileName == null || fileName.isBlank()){
                throw new RuntimeException("El nombre del archivo no puede estar vacío");
            }

            String baseDir = System.getProperty("user.dir") + "/uploads/pictures";
            Path path = Path.of(baseDir, fileName);

            if(Files.exists(path)){
                Files.delete(path);
                log.info("🗑️ Imagen eliminada correctamente: {}", path.toAbsolutePath());
            } else {
                log.warn("⚠️ No se encontró la imagen para eliminar: {}", path.toAbsolutePath());
            }

        }catch (Exception e) {
            log.error("❌ Error al eliminar archivo: {}", e.getMessage());
            throw new RuntimeException("Error al eliminar archivo: " + e.getMessage());
        }
    }

    private String validarYObtenerExtension(MultipartFile file) {
        String nombre = file.getOriginalFilename();

        if (nombre == null || nombre.isBlank())
            throw new RuntimeException("El archivo no tiene nombre válido");

        if (file.isEmpty())
            throw new RuntimeException("El archivo está vacío");

        String lower = nombre.toLowerCase();

        if (!lower.endsWith(".jpg") && !lower.endsWith(".jpeg") && !lower.endsWith(".png") && !lower.endsWith("pdf"))
            throw new RuntimeException("Solo se permiten .jpg, .jpeg o .png");

        return lower.substring(lower.lastIndexOf("."));
    }

}
