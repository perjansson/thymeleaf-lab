package com.peejay.jensoftapi;

import com.jensoft.core.palette.ColorPalette;
import com.jensoft.core.palette.RosePalette;
import com.jensoft.core.palette.Spectral;
import com.jensoft.core.plugin.pie.Pie;
import com.jensoft.core.plugin.pie.PiePlugin;
import com.jensoft.core.plugin.pie.PieSlice;
import com.jensoft.core.plugin.pie.PieToolkit;
import com.jensoft.core.plugin.pie.painter.draw.PieDefaultDraw;
import com.jensoft.core.plugin.pie.painter.effect.PieLinearEffect;
import com.jensoft.core.view.View2D;
import com.jensoft.core.window.Window2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PieChart extends View2D {

   private byte[] imageInByteArray = null;
    private final BufferedImage imageView;

    public PieChart() {
        super(0);

        Window2D window = new Window2D.Linear(-1, 1, -1, 1);
        registerWindow2D(window);

        PiePlugin piePlugin = new PiePlugin();
        window.registerPlugin(piePlugin);

        Pie pie = PieToolkit.createPie("pie", 120);
        PieLinearEffect fx1 = new PieLinearEffect();
        pie.setPieEffect(fx1);

        PieDefaultDraw draw = new PieDefaultDraw();
        draw.setDrawColor(RosePalette.LIME);
        draw.setDrawStroke(new BasicStroke(1.4f));
        pie.setPieDraw(draw);

        PieSlice s1 = PieToolkit.createSlice("s1", new Color(240, 240, 240, 240), 45, 0);
        PieSlice s2 = PieToolkit.createSlice("s2", ColorPalette.alpha(Spectral.SPECTRAL_RED, 240), 5, 0);
        PieSlice s3 = PieToolkit.createSlice("s3", ColorPalette.alpha(Spectral.SPECTRAL_BLUE2, 240), 30, 0);
        PieSlice s4 = PieToolkit.createSlice("s4", ColorPalette.alpha(Spectral.SPECTRAL_PURPLE1, 240), 20, 0);
        PieToolkit.pushSlices(pie, s1, s2, s3, s4);

        piePlugin.addPie(pie);

        imageView = this.getImageView(500, 500);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(imageView, "png", baos);
            baos.flush();
            imageInByteArray = baos.toByteArray();
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImageView() {
        return imageView;
    }

    public byte[] getImageInByteArray() {
        return imageInByteArray;
    }
}
