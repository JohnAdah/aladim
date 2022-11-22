package com.trader.smarttrade.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class SaveImage {

    private static final Logger log = LoggerFactory.getLogger(SaveImage.class);


    private static final String BASE_PATH = "C:/Users/john.adah/Desktop/Spring/SmartTrade/src/main/resources/static";


    public static String imagePath(MultipartFile file){
        log.info("File" + file);
        String path = "";
        try {
            path = "/images/request/" + file.getOriginalFilename();
            String fullPath = BASE_PATH + path;
            File newFile = new File(fullPath);
            newFile.createNewFile();
            FileOutputStream myfile = new FileOutputStream(newFile);
            myfile.write(file.getBytes());
            myfile.close();
            log.info("File should be saved now :: ");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }

    public static String imageResponsePath(MultipartFile newFile){

        log.info("File" + newFile);
        String path = "";
        try {
            path = "/images/response/" + newFile.getOriginalFilename();
            String fullPath = BASE_PATH + path;
            log.info(fullPath);
            File netFile = new File(fullPath);
            netFile.createNewFile();
            FileOutputStream myFile = new FileOutputStream(netFile);
            myFile.write(newFile.getBytes());
            myFile.close();
            log.info("File should be saved now :: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info(path);
        return path;
    }

    public static String convertImage(MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains("..")){
            log.info("File format is wrong");
        }
        String imgByte = Base64.getEncoder().encodeToString(file.getBytes());
        return imgByte;
    }

}
