//package com.nuc.zp.dcm4che;
//
//import com.sun.imageio.plugins.jpeg.JPEGImageReaderSpi;
//import org.dcm4che3.data.Attributes;
//import org.dcm4che3.data.Tag;
//import org.dcm4che3.imageio.plugins.dcm.DicomImageReader;
//import org.dcm4che3.io.DicomInputStream;
//import org.dcm4che3.tool.dcm2jpg.Dcm2Jpg;
//
//import java.io.File;
//import java.io.IOException;
//
//public class Test {
//
//    public static void main(String[] args) {
//        String classpath = getCurrentClasspath("dicomfile");
//        File file = new File(classpath + "/Heart.dcm");
//        dicom2Jpg(classpath, new File[]{file});
//    }
//
//    /**
//     * dicom转jpg
//     *
//     * @param imagesPath 存储目录
//     * @param files      dicom文件集合
//     */
//    public static void dicom2Jpg(String imagesPath, File[] files) {
//        for (File dicom : files) {
//            String savePath = imagesPath + "/" + dicom.getName() + ".jpg";
//            File jpeg = new File(savePath);
//            if (jpeg.exists() || !dicom.isFile()) {
//                continue;
//            }
//            try {
//                Dcm2Jpg dcm2jpg = new Dcm2Jpg();
//                dcm2jpg.initImageWriter("JPEG", null, null, null, 1l);
//                dcm2jpg.convert(dicom, jpeg);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static String getCurrentClasspath(String fileName) {
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        String currentClasspath = classLoader.getResource(fileName).getPath();
//        // 当前操作系统
//        String osName = System.getProperty("os.name");
//        if (osName.startsWith("Windows")) {
//            // 删除path中最前面的/
//            currentClasspath = currentClasspath.substring(1);
//        }
//        return currentClasspath;
//    }
//}
