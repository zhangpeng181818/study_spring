package com.nuc.zp.dcm4che;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.UID;
import org.dcm4che3.imageio.codec.Transcoder;

public class Dcm4cheTranscode {
    public static void main(String[] args) {
        File src = new File(getCurrentClasspath("dicomfile/Anonymized20201118.dcm")); //带有压缩协议的dicom原始文件
        File dest = new File(getCurrentClasspath("dicomfile") + "/31.dcm"); //解压成未压缩的dicom目标文件

        try {
            transcodeWithTranscoder(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void transcodeWithTranscoder(File src, final File dest) throws IOException {
        try (Transcoder transcoder = new Transcoder(src)) {
            transcoder.setDestinationTransferSyntax(UID.ImplicitVRLittleEndian);
            transcoder.transcode(new Transcoder.Handler() {
                @Override
                public OutputStream newOutputStream(Transcoder transcoder, Attributes dataset) throws IOException {
                    return new FileOutputStream(dest);
                }
            });
        } catch (Exception e) {
            Files.deleteIfExists(dest.toPath());
            e.printStackTrace();
            throw e;
        }
    }

    public static String getCurrentClasspath(String fileName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String currentClasspath = classLoader.getResource(fileName).getPath();
        // 当前操作系统
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Windows")) {
            // 删除path中最前面的/
            currentClasspath = currentClasspath.substring(1);
        }
        return currentClasspath;
    }
}

