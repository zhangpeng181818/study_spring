package com.nuc.zp.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.apache.tomcat.util.buf.ByteBufferUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class ImageDemo {
    private final static Logger logger = LoggerFactory.getLogger(ImageDemo.class);


    public static void main(String args[]) {

        System.out.println(new BigInteger("FFFFFFFF", 16));
        getData(getCurrentClasspath("dicomfile/Anonymized20201118.dcm"));
//        getData(getCurrentClasspath("dicomfile/ileitis_in_yersiniosis_42_0001.dic"));

    }

    /**
     * 读取dicom文件字节流数据看看
     */
    private static void getData(String filePath) {
        System.out.println("解析文件：" + filePath);
        try {
            byte[] content = getContent(filePath);
            ByteBuf byteBuf = Unpooled.directBuffer();
            byteBuf.writeBytes(content);

            int length = byteBuf.readableBytes();


            byteBuf.readBytes(new byte[128]);//导言
            byte[] bytes = new byte[4];
            byteBuf.readBytes(bytes);
            System.out.println(new String(bytes));//DICM
            length = length - 128 - 4;

            while (length > 0) {
                length = parseTag(byteBuf, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int parseTag(ByteBuf byteBuf, int length) {
        String group = Integer.toHexString(byteBuf.readShortLE());
        if ("7fe0".equals(group)) {
            return -1;
        }
        System.out.print("Group:" + group);
        String element = Integer.toHexString(byteBuf.readShortLE());
        System.out.print(" Element:" + element);
        String vr = "CS";
        byte[] bytes;
        if (group.equals("8") || group.equals("9") || group.equals("10") || group.equals("18") || group.equals("19") || group.equals("20") || group.equals("21") || group.equals("23") || group.equals("27")
                || group.equals("28") || group.equals("40") || group.equals("43") || group.equals("45")) {
            if (group.equals("8") && element.equals("1140")) {
                byteBuf.skipBytes(124);
                System.out.println();
                return length;
            }
//            else if (group.equals("18")&&element.startsWith("ffff")) {
//                vr = "FD";
//            }

        } else {
            bytes = new byte[2];
            byteBuf.readBytes(bytes);
            vr = new String(bytes);
            System.out.print("  VR：" + vr);
        }
        length -= 6;
        int size = 0;


        if (Arrays.asList("OB", "SQ").contains(vr)) {
            byteBuf.readShortLE();
            size = byteBuf.readIntLE();
        } else if ("CS".equals(vr)) {
            size = byteBuf.readIntLE();
        } else {
            size = byteBuf.readShortLE();
        }
        System.out.print("  size：" + size);


        if ("UL".equals(vr)) {
            System.out.print("  value：" + byteBuf.readIntLE());
            length -= 4;
        } else if ("OB".equals(vr)) {
            bytes = new byte[2];
            byteBuf.readBytes(bytes);
            System.out.print("  value：" + new String(bytes).trim());
            length -= 2;
        } else if ("FD".equals(vr)) {
            bytes = new byte[size];
            byteBuf.readBytes(bytes);
            System.out.println("  value：" + new String(bytes));
            length -= size;
        } else {
            bytes = new byte[size];
            byteBuf.readBytes(bytes);
            System.out.print("  value：" + new String(bytes).trim());
            length -= size;
        }
        System.out.println();
        return length;
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

    public static byte[] getContent(String filePath) throws IOException, FileNotFoundException {
        File file = new File(filePath);
        long fileSize = file.length();
        if (fileSize > Integer.MAX_VALUE) {
            System.out.println("file too big...");
            return null;
        }
        FileInputStream fi = new FileInputStream(file);
        byte[] buffer = new byte[(int) fileSize];
        int offset = 0;
        int numRead = 0;
        while (offset < buffer.length
                && (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {
            offset += numRead;
        }
        // 确保所有数据均被读取
        if (offset != buffer.length) {
            throw new IOException("Could not completely read file "
                    + file.getName());
        }
        fi.close();
        return buffer;
    }


}