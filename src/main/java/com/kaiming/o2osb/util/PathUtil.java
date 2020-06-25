package com.kaiming.o2osb.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    private static String winPath;

    private static String linuxPath;

    private static String shopPath;

    private static String headLinePath;

    private static String shopCategoryPath;

    @Value("${win.base.path}")
    public void setWinPath(String winPath) {
        PathUtil.winPath = winPath;
    }

    @Value("${linux.base.path}")
    public void setlinuxPath(String linuxPath) {
        PathUtil.linuxPath = linuxPath;
    }

    @Value("${shop.relevant.path}")
    public void setShopPath(String shopPath) {
        PathUtil.shopPath = shopPath;
    }

    @Value("${headline.relevant.path}")
    public void setHeadLinePath(String headLinePath) {
        PathUtil.headLinePath = headLinePath;
    }

    @Value("${shopcategory.relevant.path}")
    public void setShopCategoryPath(String shopCategoryPath) {
        PathUtil.shopCategoryPath = shopCategoryPath;
    }

    /**
     * 图片根路径，随着操作系统变化而变化
     * @return
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = winPath;
        }else{
            basePath = linuxPath;
//            basePath = "/home/kaimingcui/image";
//            basePath = "/Users/baidu/work/image";
        }
        basePath.replace("/",seperator);

        return basePath;
    }

    /**
     * 图片在服务器中相对路径，不变化
     * @param shopId
     * @return
     */
    public static String getShopImagePath(long shopId){
        String imagePath = shopPath + shopId + seperator;
        return imagePath.replace("/",seperator);
    }

    public static String getHeadLineImagePath() {
        String imagePath = headLinePath;
        return imagePath.replace("/", seperator);
    }
    public static String getShopCategoryPath() {
        String imagePath = shopCategoryPath;
        return imagePath.replace("/", seperator);
    }
}
