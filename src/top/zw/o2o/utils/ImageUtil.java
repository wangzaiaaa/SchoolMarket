package top.zw.o2o.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import top.zw.o2o.dto.ImageHolder;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath = "D:\\projectdev\\image\\watermask.png";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);
    /**
     * 将CommonsMultipartFile转换成File类
     *
     * @param cFile
     * @return
     */
    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile) {
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IllegalStateException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }


    /**
     *
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateThumnail(ImageHolder thumbnail,String targetAddr){
        String readlFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail.getImageName());
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + readlFileName + extension;
        logger.debug("current relativeAddr is:" + PathUtil.getImgBasePath() + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try{
            Thumbnails.of(thumbnail.getImage()).size(200,200).
                    watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath)),0.25f).
                    outputQuality(0.8).toFile(dest);
        }catch (IOException e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 生成随机的文件，当前的年月日小时分秒 + 随机的五位数
     * @return
     */
    public static String getRandomFileName(){
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sdf.format(new Date());
        return nowTimeStr + rannum;
    }

    /**
     * 获取输入流文件的扩展名
     * @param cFile
     * @return
     */
    private static String getFileExtension(String cFile){

        return cFile.substring(cFile.lastIndexOf('.'));
    }

    /**
     * 创建目标目录所涉及的目录
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr){
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
     }








    public static void main(String[] args) throws IOException {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        System.out.println(basePath);
        String path = basePath + "../../src/main/webapp/resources";
//        System.out.println(path);
        Thumbnails.of(new File("C:\\Users\\bonsoirzw\\Pictures\\Camera Roll\\dlam.jpg"))
                .size(200,200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("F:\\SchoolMarket1\\src\\main\\webapp\\resources\\images.jpg")),
                0.5f
                ).outputQuality(0.8f).toFile("C:\\Users\\bonsoirzw\\Pictures\\Camera Roll\\dlam2.jpg");
    }

    /**
     * 判断storePath是文件的路径还是目录的路径
     * 如果storePath是文件路径则删除该文件
     * 如果storePath是目录则删除该目录下的所有文件
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath){
       File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
       if(fileOrPath.exists()){
           if(fileOrPath.isDirectory()){
               File files[] = fileOrPath.listFiles();
               for(File f: files){
                   f.delete();
               }
           }
           fileOrPath.delete();
       }
    }


    /**
     * 处理详情图，并返回新生成图片的相对值路径
     *
     * @param thumbnail
     * @param targetAddr
     * @return
     */
    public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {
        // 获取不重复的随机名
        String realFileName = getRandomFileName();
        // 获取文件的扩展名如png,jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        // 如果目标路径不存在，则自动创建
        makeDirPath(targetAddr);
        // 获取文件存储的相对路径(带文件名)
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is :" + relativeAddr);
        // 获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is :" + PathUtil.getImgBasePath() + relativeAddr);
        // 调用Thumbnails生成带有水印的图片
        try {
            Thumbnails.of(thumbnail.getImage()).size(337, 640)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath)), 0.25f)
                    .outputQuality(0.9f).toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            throw new RuntimeException("创建缩图片失败：" + e.toString());
        }
        // 返回图片相对路径地址
        return relativeAddr;
    }
}
