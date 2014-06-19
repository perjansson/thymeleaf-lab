package com.peejay.report;

import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class Module {

    private String key;

    public Module(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static String encodeToBase64String(byte[] imageBytes) {
        return new BASE64Encoder().encode(imageBytes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Module module = (Module) o;

        if (key != null ? !key.equals(module.key) : module.key != null) return false;

        return true;
    }

    public abstract String getStyle();

    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }

    @Override
    public String toString() {
        return key;
    }
}
