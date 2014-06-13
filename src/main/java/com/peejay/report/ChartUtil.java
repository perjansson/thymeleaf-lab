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
}
