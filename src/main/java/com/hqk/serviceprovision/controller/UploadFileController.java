package com.hqk.serviceprovision.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class UploadFileController {


    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping("/upload")
    public  String  uploadfile(@RequestParam("fileName")MultipartFile file){
        //判断文件是否为空
        if (file.isEmpty()) {
            return "-1";
        }
        //获取文件名字
        String fileName=file.getOriginalFilename();
        // 获取后缀
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传的路径
        String filePath = "d:/upload/";
       // fileName处理 避免重复
        fileName = filePath+ UUID.randomUUID()+"/"+fileName;
        // 文件对象
        File dest = new File(fileName);

        //判断文件是否已经存在
        if (dest.exists()) {
            return "-2";
        }
        // 判断文件父目录是否存在 不存在 创建路径
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            // 保存文件
            file.transferTo(dest);
            return "上传成功";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "上传失败";
    }

    /**
     * 上传下载
     * @param
     * @return
     */
    @RequestMapping("/download")
    public  String  download(@RequestParam("fileName") String filePathName ,HttpServletResponse response){
        //文件是否存在
        System.out.println("start");
        File file = new File(filePathName);
        if (!file.exists()) {
            return "-1";
        }

        response.reset();
        // 设置被第三方工具打开,设置下载的文件名
       // response.addHeader("Content-Disposition", "attachment;fileName=" + filePathName);
        response.setHeader("Content-Disposition", "attachment;fileName=" + filePathName);
        try {

            InputStream inStream = new FileInputStream(filePathName);
            OutputStream os = response.getOutputStream();

            byte[] buff = new byte[1024];
            int len = -1;
            while ((len = inStream.read(buff)) > 0) {
                os.write(buff, 0, len);
            }
            os.flush();
            os.close();
            inStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "-2";
        }

        return "下载成功";
    }


    @RequestMapping("download1")
    public String download1(String filePathName,HttpServletResponse response) throws Exception {

        System.out.println("filePathName:"+filePathName);
        File file =new File("D:\\upload\\97a19bb4-f591-4479-9bcf-e930ba248abc2.png");

        if (!file.exists()) {
            return "不存在";

        }

        FileInputStream fileInputStream=new FileInputStream(file);
        // 设置被下载而不是被打开
        response.setContentType("application/gorce-download");
        // 设置被第三方工具打开,设置下载的文件名
        response.addHeader("Content-disposition","attachment;fileName="+file.getName());
        try {
            OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }

}
