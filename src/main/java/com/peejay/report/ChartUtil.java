package com.peejay.report;

import com.peejay.chart.Chart;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ChartUtil {;

    public static byte[] toImageByteArray(Chart chart, int width, int height, String imageType) {
        byte[] imageInByteArray;
        BufferedImage image = chart.asBufferedImage(width, height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, imageType, baos);
            baos.flush();
            imageInByteArray = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageInByteArray;
    }

    public static String toImageBase64EncodedByteArray(Chart chart, int width, int height, String imageType) {
        BufferedImage image = chart.asBufferedImage(width, height);
        return encodeToBase64String(image, imageType);
    }

    private static String encodeToBase64String(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageString;
    }
}
