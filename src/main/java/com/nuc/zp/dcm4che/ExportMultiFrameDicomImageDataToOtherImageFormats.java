package com.nuc.zp.dcm4che;


import static com.pixelmed.display.ConsumerFormatImageMaker.*;

public class ExportMultiFrameDicomImageDataToOtherImageFormats {

    public static void main(String[] arg) {

//        String dicomFile = "D:\\JavaProjects\\Sample Images\\XA-MONO2-8-12x-catheter";
        String outputJpgFile = "D:\\JavaProjects\\Sample Images\\Outputs\\XA-MONO2-8-12x-catheter.jpg";
        String dicomfile = getCurrentClasspath("dicomfile");


        String dicomFileName = arg.length > 0 ? arg[0] : dicomfile + "/Heart.dcm";
        String outputFileName = arg.length > 1 ? arg[1] : dicomfile + "/zzz.jpg";
        String outputFormat = arg.length > 2 ? arg[2] : "jpeg";
        double windowCenter = arg.length > 3 ? Double.parseDouble(arg[3]) : 0;
        double windowWidth = arg.length > 4 ? Double.parseDouble(arg[4]) : 0;
        int imageWidth = arg.length > 5 ? Integer.parseInt(arg[5]) : 0;
        int imageHeight = arg.length > 6 ? Integer.parseInt(arg[6]) : 0;
        int imageQuality = arg.length > 7 ? Integer.parseInt(arg[7]) : 100;
        String annotation = arg.length > 8 ? arg[8] : NO_ANNOTATIONS;
        //(ALL_ANNOTATIONS + "_" + COLOR_ANNOTATIONS);
        int regionX = arg.length > 12 ? Integer.parseInt(arg[9]) : 0;
        int regionY = arg.length > 12 ? Integer.parseInt(arg[10]) : 0;
        int regionWidth = arg.length > 12 ? Integer.parseInt(arg[11]) : 0;
        int regionHeight = arg.length > 12 ? Integer.parseInt(arg[12]) : 0;
        int firstFrame = arg.length > 14 ? Integer.parseInt(arg[13]) : 0;
        int lastFrame = arg.length > 14 ? Integer.parseInt(arg[14]) : -1;

        try {
            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomFileName, outputFileName, outputFormat, windowCenter, windowWidth, imageWidth, imageHeight, regionX, regionY, regionWidth, regionHeight, firstFrame, lastFrame, imageQuality, annotation);

            //Will result in 16 jpeg files created as the input DICOM file has 16 frames
//            ConsumerFormatImageMaker.convertFileToEightBitImage(dicomfile+"/Anonymized20201119.dcm", dicomfile + "/teest.jpeg", "jpeg");

//            new Convert8To16Bits(dicomfile+"/Heart.dcm",dicomfile+"/hah.jpeg",16);

        } catch (Exception e) {
            e.printStackTrace(); //in real life, do something about this exception
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