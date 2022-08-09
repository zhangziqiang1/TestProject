import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author 方健尔 f00563108
 * @since 2022-01-25
 * @description 使用规范中对文件的校验方式。
 * @tool SecBrella:SecS_Path_Manipulation;
 * @good unzip
 * @vision BUG2022012501557
 * @fixed yes
 * @fixedVersion 1.0.7 sp06
 */
public class PathManipulationFalsePositiveCase4 {
    private static final long MAX_FILE_COUNT = 100L;
    private static final long MAX_TOTAL_FILE_SIZE = 1024L * 1024L;

    public void unzip(FileInputStream zipFileInputStream, String dir) throws IOException {
        String entryName = System.getenv("xxx");
        String entryFilePath1 = sanitizeFileName1(entryName, dir);
        String entryFilePath = sanitizeFileName(entryFilePath1, dir);

        File entryFile = new File(entryFilePath);
        System.out.println(entryFile);
    }

    private String sanitizeFileName1(String entryName, String dir) {
        return entryName;
    }

    private String sanitizeFileName(String fileName, String dir) throws IOException {
        return fileName;
//        File file = new File(dir, fileName);
//        String canonicalPath = file.getCanonicalPath();
//        // dir的末尾缺少文件路径分隔符时，可能会导致校验错误。主动为dir参数末尾加上文件路径分隔符
//        String safeDir = new File(dir).getCanonicalPath() + File.separator;
//        if (canonicalPath.startsWith(safeDir)) {
//            return canonicalPath;
//        }
//        throw new IOException("Path Traversal vulnerability: ...");
    }

    private void creatDir(File dirPath) throws IOException {
        boolean result = dirPath.mkdirs();
        if (!result) {
            throw new IOException("Create dir failed, path is : " + dirPath.getPath());
        }
    }

    private void zipBombCheck(long totalFileSize) throws IOException {
        if (totalFileSize > MAX_TOTAL_FILE_SIZE) {
            throw new IOException("Zip Bomb! File size is too large. ...");
        }
    }
}