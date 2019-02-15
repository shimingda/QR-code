package com.dome.QRcode;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

/**
 * @author Simon
 * @create 2018-11-01 11:04
 * @desc
 **/
public class ImageQRUtils {

    /**
     * 绘制背景图
     *
     * @param source       二维码图
     * @param bgImgOptions 背景图信息
     * @return
     */
    public static BufferedImage drawBackground(BufferedImage source, QrCodeOptions.BgImgOptions bgImgOptions) {
        int sW = source.getWidth();
        int sH = source.getHeight();

        // 背景的图宽高不应该小于原图
        int bgW = bgImgOptions.getBgW() < sW ? sW : bgImgOptions.getBgW();
        int bgH = bgImgOptions.getBgH() < sH ? sH : bgImgOptions.getBgH();


        // 背景图缩放
        BufferedImage bg = bgImgOptions.getBgImg();
        if (bg.getWidth() != bgW || bg.getHeight() != bgH) {
            BufferedImage temp = new BufferedImage(bgW, bgH, BufferedImage.TYPE_INT_ARGB);
            temp.getGraphics().drawImage(bg.getScaledInstance(bgW, bgH, Image.SCALE_SMOOTH)
                    , 0, 0, null);
            bg = temp;
        }

        Graphics2D g2d = bg.createGraphics();
        if (bgImgOptions.getBgImgStyle() == QrCodeOptions.BgImgStyle.FILL) {
            // 选择一块区域进行填充
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawImage(source, bgImgOptions.getStartX(), bgImgOptions.getStartY(), sW, sH, null);
        } else {
            // 覆盖方式
            int x = (bgW - sW) >> 1;
            int y = (bgH - sH) >> 1;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, bgImgOptions.getOpacity())); // 透明度， 避免看不到背景
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawImage(source, x, y, sW, sH, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
        }
        g2d.dispose();
        bg.flush();
        return bg;
    }

    /**
     * 生成圆角图片
     *
     * @param image        原始图片
     * @param cornerRadius 圆角的弧度
     * @return 返回圆角图
     */
    public static BufferedImage makeRoundedCorner(BufferedImage image,
                                                  int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h,
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();

        // This is what we want, but it only does hard-clipping, i.e. aliasing
        // g2.setClip(new RoundRectangle2D ...)

        // so instead fake soft-clipping by first drawing the desired clip shape
        // in fully opaque white with antialiasing enabled...
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius,
                cornerRadius));

        // ... then compositing the image on top,
        // using the white shape from above as alpha source
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);

        g2.dispose();

        return output;
    }
    /**
     * <p>
     * 生成圆角图片 & 圆角边框
     *
     * @param image     原图
     * @param logoStyle 圆角的角度
     * @param size      边框的边距
     * @param color     边框的颜色
     * @return 返回带边框的圆角图
     */
    public static BufferedImage makeRoundBorder(BufferedImage image,
                                                QrCodeOptions.LogoStyle logoStyle,
                                                int size, Color color) {
        // 将图片变成圆角
        int cornerRadius = 0;
        if (logoStyle == QrCodeOptions.LogoStyle.ROUND) {
            cornerRadius = image.getWidth() / 4;
            image = makeRoundedCorner(image, cornerRadius);
        }

        int w = image.getWidth() + size;
        int h = image.getHeight() + size;
        BufferedImage output = new BufferedImage(w, h,
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(color == null ? Color.WHITE : color);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius,
                cornerRadius));

        // ... then compositing the image on top,
        // using the white shape from above as alpha source
//        g2.setComposite(AlphaComposite.SrcAtop);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 1.0f));
        g2.drawImage(image, size / 2, size / 2, null);
        g2.dispose();

        return output;
    }
}
