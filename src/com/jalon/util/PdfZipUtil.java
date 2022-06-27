package com.jalon.util;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.PathUtil;
import cn.hutool.core.util.ZipUtil;

import java.io.File;

/**
 * <p>
 *  压缩、解压，用hutool工具
 * </p>
 *
 * @author: JavaLover
 * @Time: 2021-08-07 11:11
 **/
public class PdfZipUtil {
    public static void main(String[] args) {
        String root = "F:\\StudyData\\Java书单";
        String txt = "解压密码公众号回复【密码】即可获取.txt";
        String png = "公众号：汤圆学Java.png";
        // 1. 遍历所有的文件夹：找到所有的PDF文件
        File[] files = FileUtil.ls(root);
        for (File file2 : files) {
            if(!file2.isFile()){
               File[] files1 = FileUtil.ls(file2.getAbsolutePath());
                for (File file : files1) {
                    if(file.isFile()){
                        String type = FileTypeUtil.getType(file);
                        if("pdf".equalsIgnoreCase(type)){
                            // 2. 压缩所有 PDF 文件到同名 rar：加密(这一步做不了，自动无法加密，需手动操作）
                            // 3. 为每一个 PDF 文件都创建一个单独文件夹
                            String folderPath = file.getAbsolutePath().replace(".pdf", "").trim();
                            File file1 = FileUtil.mkdir(folderPath);
                            System.out.println("=== 1. 创建目录：" + folderPath);
                            // 4. 复制txt和二维码到文件夹，并把zip也移动过去
                            FileUtil.copy(root+"\\"+txt, folderPath, true);
                            FileUtil.copy(root+"\\"+png, folderPath, true);
                            // PDF压缩文件：带密码
                            String rarPath = folderPath+".rar";
                            if(!FileUtil.exist(rarPath))
                                continue;
                            // 复制到PDF目录
                            FileUtil.copy(rarPath, folderPath, true);
                            // 删除带密码的PDF压缩文件
                            FileUtil.del(rarPath);
                            System.out.println("=== 2. 复制文件");
                            // 3. 将上面创建的文件夹挨个单独压缩，压缩文件与PDF同名，zip格式
                            File zip = ZipUtil.zip(folderPath, folderPath+".zip",true);
                            System.out.println("=== 3. 压缩目录");
                        }
                    }
                }

            }
        }

    }
}
