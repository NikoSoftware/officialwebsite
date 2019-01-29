package top.nikochen.officialwebsite.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Controller
public class HomeControl {



    @RequestMapping("/")
    public String getHome(){
      return "index";
    }



    @RequestMapping("/compositeImage")
    public ModelAndView getImage(){

        File file  = new File("src/main/resources/static/images/year-image.jpg");
        File qrFile  = new File("src/main/resources/static/images/qrimage.png");

        Date date = new Date();
        File outputFile  = new File("src/main/resources/static/cacheImage/"+date.getTime()+"image.jpeg");
      //  File outputFile  = new File("C:/Users/niko/Desktop/cacheImage/"+date.getTime()+"image.jpeg");

        try {
            outputFile.createNewFile();
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            Graphics2D graphics2D = image.createGraphics();
            graphics2D.setColor(new Color(253,242,191));
            Font font = new Font("宋体",Font.BOLD,50);
            graphics2D.setFont(font);
            FontMetrics  fm=new JLabel().getFontMetrics(font);
            graphics2D.drawString("新年快乐",width/2-fm.stringWidth("新年快乐")/2,height/2+100);
            String content = "除夕夜祝大家新年快乐，万事如意，阖家幸福 除夕夜祝大家新年快乐，万事如意，阖家幸福";

            int size =  fm.stringWidth("新");
            int lineSize = (width-400)/size;
            for (int i = 0; i < content.length(); i = i+lineSize) {
                graphics2D.drawString(content.substring(i,i+lineSize>content.length()? content.length():i+lineSize),200,
                        height/2+100+(fm.getHeight()*(i/lineSize+1)));
            }
            BufferedImage qrImage = ImageIO.read(qrFile);

            graphics2D.drawImage(qrImage, width - 200, height - 200,
                    width, height, new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });
            graphics2D.dispose();
            FileOutputStream os = new FileOutputStream(outputFile);
            ImageOutputStream imageOutputStream = ImageIO
                    .createImageOutputStream(os);
            ImageIO.write(image, "JPEG", imageOutputStream);
            imageOutputStream.flush();
            os.flush();
            imageOutputStream.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String cacheImagePath = outputFile.getName();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("imageSuccess");
        modelAndView.addObject("cacheImagePath",cacheImagePath);
        return modelAndView;
    }


}
