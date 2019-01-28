package top.nikochen.officialwebsite.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class HomeControl {



    @RequestMapping("/")
    public String getHome(){
      return "index.html";
    }



    @RequestMapping("/compositeImage")
    public String getImage(){

        File file  = new File("src/main/resources/static/images/year-image.jpg");
        File outputFile  = new File("src/main/resources/static/images/year-out-image.jpg");
        try {
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();

     //       BufferedImage tag = new BufferedImage(width,height,)

            Graphics2D graphics2D = image.createGraphics();
            graphics2D.setColor(new Color(253,242,191));
            graphics2D.setFont(new Font("宋体",Font.BOLD,50));
            graphics2D.drawString("现年快乐",width/2-50,height/2+100);
            graphics2D.dispose();

            ImageOutputStream imageOutputStream = ImageIO
                    .createImageOutputStream(new FileOutputStream(outputFile));
            ImageIO .write(image, "JPEG", imageOutputStream);


        } catch (IOException e) {
            e.printStackTrace();
        }


        return "imageSuccess.html";
    }


}
