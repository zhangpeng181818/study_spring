//package com.nuc.zp.dcm4che;
//
//import org.dcm4che3.data.Attributes;
//import org.dcm4che3.data.Tag;
//import org.dcm4che3.io.DicomInputStream;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//public class Dcm4cheTest {
//    public static void main(String[] args) {
//        try {
//            readDicom();
////            readMultiFrameDicom();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    private static void readDicom() throws IOException {
////        DicomInputStream dis = new DicomInputStream(new File(getCurrentClasspath("dicomfile/Anonymized20201119.dcm")));
////        DicomInputStream dis = new DicomInputStream(new File(getCurrentClasspath("dicomfile/31.dcm")));
//        DicomInputStream dis = new DicomInputStream(new File(getCurrentClasspath("dicomfile/Heart.dcm")));
//
//        Attributes d = dis.readDataset(-1, -1);
//        System.out.println(d);
//        //patient
//        //Accession Number
//        byte[] sh = d.getBytes(Tag.AccessionNumber);
//        System.out.println(new String(sh));
//
//        //patient name
//        byte[] pn = d.getBytes(Tag.PatientName);
//        System.out.println(new String(pn));
//
//        //patient id
//        byte[] patientIdBytes = d.getBytes(Tag.PatientID);
//        System.out.println(new String(patientIdBytes));
//        //patient size
//        byte[] patientSizeBytes = d.getBytes(Tag.PatientSize);
////        System.out.println(new String(patientSizeBytes));
//
//        //Study
//        //StudyDate
//        byte[] studyDateBytes = d.getBytes(Tag.StudyDate);
//        System.out.println(new String(studyDateBytes));
//
//        //StudyDate
//        byte[] studyInstanceUIDBytes = d.getBytes(Tag.StudyInstanceUID);
//        System.out.println(new String(studyInstanceUIDBytes).trim());
//
//        double revolutionTime = d.getDouble(Tag.RevolutionTime, 0.0f);
//        System.out.println(revolutionTime);
//        double singleCollimationWidth = d.getDouble(Tag.SingleCollimationWidth, 0.0f);
//        System.out.println(singleCollimationWidth);
//
//        double tableSpeed = d.getDouble(Tag.TableSpeed, 0.0f);
//        System.out.println(tableSpeed);
//
//        int nNumberOfFrames = d.getInt(Tag.NumberOfFrames, 0);
//        System.out.println("nNumberOfFrames---" + nNumberOfFrames);
//        System.out.println("transferSyntax---" + dis.getTransferSyntax());
//
///**
// * Tag.PixelData这个字段里存的就是Dicom文件的图像数据
// * Tag.BitsAllocated 图像数据存储位数，一般是8位和16位，本文图像处理用的是16位图像
// * Tag.PixelRepresentation 是否是带符号，0是无符号，1是有符号
// * Tag.Rows 图像行数(图像高度)
// * Tag.Columns 图像列数(图像宽度)
// * Tag.WindowCenter 默认窗位
// * Tag.WindowWidth 默认窗宽
// *
// */
//        int rescaleIntercept = d.getInt(Tag.RescaleIntercept, -1);
//        int rescaleSlope = d.getInt(Tag.RescaleSlope, -1);
//        int rescaleType = d.getInt(Tag.RescaleType, -1);
//
//        System.out.println(rescaleIntercept + "--" + rescaleSlope + "--" + rescaleType);
//
//        int nBitsAllocated = d.getInt(Tag.BitsAllocated, 0);
//        int nPixelRepresentation = d.getInt(Tag.PixelRepresentation, -1);
//        System.out.println(nBitsAllocated + "--" + nPixelRepresentation);
//        if (nBitsAllocated >= 8 && nPixelRepresentation == 0) {
//            processImagePixelFor16BitUnsigned(d);
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
//
//    private static void readMultiFrameDicom() throws IOException {
//        DicomInputStream dis = new DicomInputStream(new File(getCurrentClasspath("dicomfile") + "/Heart.dcm"));
//        Attributes d = dis.readDataset(-1, -1);
//        int nNumberOfFrames = d.getInt(Tag.NumberOfFrames, 0);
//
//        int nRows = d.getInt(Tag.Rows, 0);
//        int nColumns = d.getInt(Tag.Columns, 0);
//        float fC = d.getFloat(Tag.WindowCenter, 0);
//        float fW = d.getFloat(Tag.WindowWidth, 0);
//        int nBitsAllocated = d.getInt(Tag.BitsAllocated, 0);
//        byte[] pixelData = d.getBytes(Tag.PixelData);
//
//        int length = nRows * nColumns;
//        if (nBitsAllocated == 16) {
//            length <<= 1;
//        }
//        byte[] desPixelData = new byte[length];
//
//        for (int i = 0; i < nNumberOfFrames; i++) {
//            System.arraycopy(pixelData, i * desPixelData.length, desPixelData, 0, desPixelData.length);
//            Dcm2Image.convertToJPEGImageFor16BitUnsigned(nRows, nColumns, 1024, 512, desPixelData, getCurrentClasspath("dicomfile") + "/XA_" + i + ".jpg");
//        }
//    }
//
//    private static void processImagePixelFor16BitUnsigned(Attributes d) throws IOException {
//        if (d == null) {
//            return;
//        }
//
//        int height = d.getInt(Tag.Rows, 0);
//        int width = d.getInt(Tag.Columns, 0);
//        float fC = d.getFloat(Tag.WindowCenter, 0);
//        float fW = d.getFloat(Tag.WindowWidth, 0);
//        byte[] pixelData = d.getBytes(Tag.PixelData);
//
//        short[] shortPixelData = toShortArray(pixelData);
//
//        float fMin = (float) ((2.0f * fC - fW) / 2.0f + 0.5);
//        float fMax = (float) ((2.0f * fC + fW) / 2.0f + 0.5);
//        BufferedImage BI = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
//
//        for (int h = 0; h < height; h++) {
//
//            for (int w = 0; w < width; w++) {
//                int index = w + h * width;
//                short pixel = shortPixelData[index];
//                //int value = (int) (((pixel - fC) / fW + 0.5) * 255.0);
//                int value = (int) ((pixel - fMin) * 255.0 / (fMax - fMin));
//                int newVal = Math.min(Math.max(value, 0), 255);
//                int pixelValue = 0xffffffff;
//                pixelValue = (newVal << 16) & 0x00ff0000 | (pixelValue & 0xff00ffff);
//                pixelValue = (newVal << 8) & 0x0000ff00 | (pixelValue & 0xffff00ff);
//                pixelValue = (newVal) & 0x000000ff | (pixelValue & 0xffffff00);
//                BI.setRGB(w, h, pixelValue);
//            }
//        }
//        ImageIO.write(BI, "jpg", new File(getCurrentClasspath("dicomfile") + "/test_111.jpg"));
//    }
//
//    public static short[] toShortArray(byte[] src) {
//        int count = src.length >> 1;
//        short[] dest = new short[count];
//        for (int i = 0; i < count; i++) {
//            dest[i] = (short) ((src[i * 2] & 0xff) | ((src[2 * i + 1] & 0xff) << 8));
//        }
//        return dest;
//    }
//
//}
