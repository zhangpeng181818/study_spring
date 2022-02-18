//package com.nuc.zp.dcm4che;
//
//import com.sun.image.codec.jpeg.JPEGCodec;
//import com.sun.image.codec.jpeg.JPEGImageEncoder;
//import org.dcm4che3.imageio.plugins.dcm.DicomImageReadParam;
//
//import javax.imageio.ImageIO;
//import javax.imageio.ImageReader;
//import javax.imageio.stream.ImageInputStream;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.util.Iterator;
//
//public class Examplke1 {
//    static BufferedImage myJpegImage = null;
//
//    public static void main(String[] args) {
//        String classpath = getCurrentClasspath("dicomfile");
//        File file = new File(classpath + "/Heart.dcm");
//        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("DICOM");
//        int i = 0;
//        while (iterator.hasNext()) {
//            ImageReader imageReader = (ImageReader) iterator.next();
//            DicomImageReadParam dicomImageReadParam = (DicomImageReadParam) imageReader.getDefaultReadParam();
//            try {
//                ImageInputStream iis = ImageIO.createImageInputStream(file);
//                imageReader.setInput(iis, false);
//                myJpegImage = imageReader.read(0, dicomImageReadParam);
//                iis.close();
//                if (myJpegImage == null) {
//                    System.out.println("Could not read image!!");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            File file2 = new File(classpath + "/test_" + i + ".jpg");
//            i++;
//            try {
//                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file2));
//                JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
//                encoder.encode(myJpegImage);
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Completed");
//        }
//
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
