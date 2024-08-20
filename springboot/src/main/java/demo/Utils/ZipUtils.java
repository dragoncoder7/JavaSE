package demo.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils {

    public static final Logger LOGGER = LoggerFactory.getLogger(ZipUtils.class);
    /**
     * 解压缩
     * @param zipFilePath
     * @param destDir
     * @return
     */
    public static List<String> unzip(String zipFilePath, String destDir, String fileName) {
        List<String> extractedFileNames = new ArrayList<>();
        File dir = new File(destDir);
        // 如果目标目录不存在，则创建
        if (!dir.exists()) dir.mkdirs();
        int isZip = 0;
        FileInputStream fis;
        byte[] buffer = new byte[1024];
        try {
            File newFile;
//            if (isZip == 0){
//                // zipFilePath /home/weaver/ecology/filesystem/202010/U/06ee680e-ed48-4c19-95d7-0da6dc2c8e0c
//                File originalFile = new File(zipFilePath);// /home/weaver/ecology/filesystem/202010/U/06ee680e-ed48-4c19-95d7-0da6dc2c8e0c
//                File renamedFile = new File(destDir + File.separator + fileName); // /home/weaver/ecology/filesystem/202010/U + / + fileName
//                if (renamedFile.exists()) {
//                LOGGER.info("目标文件已存在，不能重命名。");
//                } else {
//                    if (originalFile.renameTo(renamedFile)) {
//                        // 将解压后的文件名全称（包括路径）添加到列表
//                        extractedFileNames.add(renamedFile.getAbsolutePath());
//                        LOGGER.info("文件重命名成功！");
//                    } else {
//                        LOGGER.info("文件重命名失败！");
//                    }
//                }
//                return extractedFileNames;
//            }
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry zipEntry = zis.getNextEntry();

            while (zipEntry != null) {
                //String fileName = zipEntry.getName();

                newFile = new File(destDir + File.separator + fileName);

                // 如果是目录则创建目录
                if (zipEntry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    // 如果是文件则解压
                    new File(newFile.getParent()).mkdirs();

                    //生成文件
                    FileOutputStream fos = new FileOutputStream(newFile);

                    LOGGER.info("Unzipping to " + newFile.getAbsolutePath());

                    extractedFileNames.add(newFile.getAbsolutePath());

                    int len;
                    //写入数据
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                }
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
            fis.close();

//            File newFile1 = new File(destDir + File.separator + "123.xlsx");
//
//            if (newFile1.exists()) {
//                LOGGER.info("目标文件已存在，不能重命名。");
//            } else {
//
//                if (newFile.renameTo(newFile1)) {
//                    // 将解压后的文件名全称（包括路径）添加到列表
//                    extractedFileNames.add(newFile1.getAbsolutePath());
//
//                    LOGGER.info("文件重命名成功！");
//                } else {
//                    LOGGER.info("文件重命名失败！");
//                }
//            }
        } catch (IOException e) {
            LOGGER.info("解压缩产生异常！"+e);
        }
        return extractedFileNames;
    }

    public static void main(String[] args) {
        // ZIP 文件路径
        String zipFilePath = "/path/to/your/file.zip";
        // 解压后的输出路径
        String destDir = "/path/to/destination/directory";
        List<String> extractedFiles = unzip(zipFilePath, destDir,"");

        // 输出解压缩后的文件全称
        LOGGER.info("Extracted files:");
        for (String filePath : extractedFiles) {
            LOGGER.info(filePath);
        }
    }
}
