package ru.sfedu.Medicine.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;


public class FileUtil {
    private static final Logger log = LogManager.getLogger(CsvUtil.class.getName());

    public static void createFileIfNotExists(String filePath) throws IOException {
        File file = new File(filePath); //путь к папке
        if (!file.exists()) {    //есть ли такой файл
            boolean flag = file.createNewFile();   //если нет , то создаст файл
            log.info("createFileIfNotExists [1]: New file{}, is created:  {}", file.getAbsolutePath(), flag);
        } else {
            log.info("createFileIfNotExists [2]: file{} is exists", file.getAbsolutePath());
        }
    }


}
