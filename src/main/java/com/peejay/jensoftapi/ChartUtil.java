package com.peejay.jensoftapi;

import com.jensoft.core.view.View2D;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ChartUtil {;

    public static byte[] toImageByteArray(View2D view2D, int width, int height, String imageType) {
        byte[] imageInByteArray;
        BufferedImage imageView = view2D.getImageView(width, height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(imageView, imageType, baos);
            baos.flush();
            imageInByteArray = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageInByteArray;
    }

    public static String toImageBase64EncodedByteArray(View2D view2D, int width, int height, String imageType) {
        BufferedImage imageView = view2D.getImageView(width, height);
        return encodeToString(imageView, imageType);
    }

    private static String encodeToString(BufferedImage image, String type) {
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
