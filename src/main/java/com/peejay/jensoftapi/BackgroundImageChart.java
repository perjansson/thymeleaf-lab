package com.peejay.jensoftapi;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.jensoft.core.catalog.nature.JenSoftView;
import com.jensoft.core.glyphmetrics.GlyphMetric;
import com.jensoft.core.glyphmetrics.StylePosition;
import com.jensoft.core.glyphmetrics.painter.fill.GlyphFill;
import com.jensoft.core.glyphmetrics.painter.marker.RoundMarker;
import com.jensoft.core.graphics.Shader;
import com.jensoft.core.palette.ColorPalette;
import com.jensoft.core.palette.FilPalette;
import com.jensoft.core.palette.InputFonts;
import com.jensoft.core.palette.RosePalette;
import com.jensoft.core.palette.TangoPalette;
import com.jensoft.core.plugin.background.BackgroundPlugin;
import com.jensoft.core.plugin.function.FunctionPlugin.AreaFunction;
import com.jensoft.core.plugin.function.area.Area;
import com.jensoft.core.plugin.function.area.painter.draw.AreaDefaultDraw;
import com.jensoft.core.plugin.function.area.painter.fill.AreaGradientFill;
import com.jensoft.core.plugin.function.source.UserSourceFunction;
import com.jensoft.core.plugin.grid.Grid.GridOrientation;
import com.jensoft.core.plugin.grid.GridPlugin;
import com.jensoft.core.plugin.metrics.AxisMetricsPlugin;
import com.jensoft.core.plugin.metrics.manager.ModeledMetricsManager.MetricsModelRangeCollections;
import com.jensoft.core.plugin.outline.OutlinePlugin;
import com.jensoft.core.plugin.stripe.StripePlugin;
import com.jensoft.core.plugin.stripe.painter.StripePalette;
import com.jensoft.core.plugin.translate.TranslatePlugin;
import com.jensoft.core.plugin.zoom.box.ZoomBoxPlugin;
import com.jensoft.core.plugin.zoom.wheel.ZoomWheelPlugin;
import com.jensoft.core.view.Portfolio;
import com.jensoft.core.view.View2D;
import com.jensoft.core.view.background.DarkViewBackground;
import com.jensoft.core.view.background.RoundViewFill;
import com.jensoft.core.window.Window2D;

@JenSoftView(background=DarkViewBackground.class,description="Display device image background")
public class BackgroundImageChart extends View2D {

    private static final long serialVersionUID = 1318388140033364145L;

    /** demo font */
    private Font font = new Font("lucida console", Font.PLAIN, 10);

    @Portfolio(name = "DeviceImage", width = 400, height = 350)
    public static View2D getPortofolio() {
        BackgroundImageChart demo = new BackgroundImageChart();
        RoundViewFill viewBackground = new RoundViewFill();
        Shader s = new Shader(new float[] { 0f, 1f }, new Color[] { new Color(32, 39, 55), Color.BLACK });
        viewBackground.setShader(s);
        viewBackground.setOutlineStroke(new BasicStroke(2.5f));
        demo.setBackgroundPainter(viewBackground);
        return demo;
    }

    /**
     * create device image background demo
     */
    public BackgroundImageChart() {

        //setPlaceHolder(100, WindowPart.East,WindowPart.West);
        // window projection
        Window2D window = new Window2D.Linear(1000, 9000, -500, 10500);
        window.setThemeColor(TangoPalette.ALUMINIUM6);
        registerWindow2D(window);

        // device outline plug-in
        window.registerPlugin(new OutlinePlugin(RosePalette.CALYPSOBLUE));

        // create modeled axis plug-in in south part
        AxisMetricsPlugin.ModeledMetrics southMetrics = new AxisMetricsPlugin.ModeledMetrics.S();
        window.registerPlugin(southMetrics);
        southMetrics.setMetricsFont(font);
        southMetrics.registerMetricsModels(MetricsModelRangeCollections.NanoGiga);

        // create modeled axis plug-in in west part
        AxisMetricsPlugin.ModeledMetrics westMetrics = new AxisMetricsPlugin.ModeledMetrics.W();
        window.registerPlugin(westMetrics);
        westMetrics.setMetricsFont(font);
        westMetrics.registerMetricsModels(MetricsModelRangeCollections.NanoGiga);

        // area functions plug-in
        AreaFunction areaFunctions = new AreaFunction();
        window.registerPlugin(areaFunctions);

        // create source function
        double[] xValues1 = { 0, 1000, 2000, 3000, 4000, 5200, 6000, 7000, 8000, 9000, 10000 };
        double[] yValues1 = { 4000,0, 5000, 4000, 2008, 3600, 2000, 3000, 7000, 1000, 6000 };
        UserSourceFunction source = new UserSourceFunction.SplineSource(xValues1, yValues1, 100);

        // area curve functions
        Area areaCurve = new Area(source);
        areaCurve.setAreaFill(new AreaGradientFill());
        areaCurve.setAreaDraw(new AreaDefaultDraw(Color.WHITE, new BasicStroke(1f)));
        areaCurve.setThemeColor(FilPalette.BLUE6);
        areaCurve.setAreaBase(-100);
        areaFunctions.addFunction(areaCurve);

        // glyph on curve function
        GlyphMetric metric = new GlyphMetric();
        metric.setValue(4.3);
        metric.setStylePosition(StylePosition.Tangent);
        metric.setDivergence(10);
        metric.setGlyphMetricFill(new GlyphFill(Color.WHITE, FilPalette.GREEN4));
        metric.setGlyphMetricMarkerPainter(new RoundMarker(FilPalette.GREEN5, Color.white));
        metric.setFont(InputFonts.getFont(InputFonts.NEUROPOL, 14));
        areaCurve.addMetricsLabel(metric);

        metric = new GlyphMetric();
        metric.setValue(1.5);
        metric.setStylePosition(StylePosition.Tangent);
        metric.setDivergence(10);
        metric.setGlyphMetricFill(new GlyphFill(Color.WHITE, FilPalette.GREEN4));
        metric.setGlyphMetricMarkerPainter(new RoundMarker(FilPalette.GREEN5, Color.white));
        metric.setFont(InputFonts.getFont(InputFonts.NEUROPOL, 14));
        areaCurve.addMetricsLabel(metric);

        // stripe plug-in
        StripePlugin stripePlugin = new StripePlugin.MultiplierStripe.H(0, 2.5);
        StripePalette bp = new StripePalette();
        bp.addPaint(new Color(255, 255, 255, 40));
        bp.addPaint(ColorPalette.alpha(TangoPalette.ORANGE3, 40));
        stripePlugin.setStripePalette(bp);
        stripePlugin.setAlpha(0.3f);
        window.registerPlugin(stripePlugin);

        // grids plug-in
        GridPlugin grids = new GridPlugin.MultiplierGrid(0, 2.5, GridOrientation.Horizontal);
        grids.setGridColor(new Color(59, 89, 152, 100));
        window.registerPlugin(grids);

        GridPlugin grids2 = new GridPlugin.MultiplierGrid(0, 2.5, GridOrientation.Vertical);
        grids2.setGridColor(new Color(59, 89, 152, 100));
        window.registerPlugin(grids2);

        // zoom box plug-in
        ZoomBoxPlugin zoomTool = new ZoomBoxPlugin();
        window.registerPlugin(zoomTool);

        // translate plug-in
        TranslatePlugin toolTranslate = new TranslatePlugin();
        window.registerPlugin(toolTranslate);

        // zoom wheel plug-in
        ZoomWheelPlugin zoomWheel = new ZoomWheelPlugin();
        window.registerPlugin(zoomWheel);

        // device image plug-in
        InputStream iis = null;
        try {
            iis = this.getClass().getResourceAsStream("/images/earth.jpg");
            BufferedImage bi = ImageIO.read(iis);
            BackgroundPlugin bgPlugin = new BackgroundPlugin(bi);
            window.registerPlugin(bgPlugin);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.print("loaded image failed :"+e.getMessage());
        }finally{
            if(iis != null)
                try {
                    iis.close();
                } catch (IOException e) {}
        }

    }

}
