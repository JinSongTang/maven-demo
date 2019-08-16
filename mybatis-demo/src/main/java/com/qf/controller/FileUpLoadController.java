package com.qf.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by DELL on 2019/8/7.
 */
@Controller
@RequestMapping("fileUpAndDown")
public class FileUpLoadController {

    @RequestMapping("fileUploadController")
    @ResponseBody
    public String fileUploadController(@RequestParam("file") CommonsMultipartFile file) throws Exception {
        //1.创建一个新文件
        File destFile = new File("D:\\" + new Date().getTime() + file.getOriginalFilename());

        //2.将file中的内容通过transferTo方法保存到新文件中
        file.transferTo(destFile);
        System.out.println(destFile.getAbsolutePath());
        return "upload success";
    }


    @RequestMapping("testDownLoad")
    public ResponseEntity<byte[]> testDownLoad(@RequestParam(required = false,value = "fileName")String fileName) throws IOException {
        File srcFile = new File("d://"+fileName);
        if(!srcFile.exists()){
            throw new FileNotFoundException("无法找到文件"+srcFile.getAbsolutePath());
        }
        FileInputStream fis = new FileInputStream(srcFile);
        byte[] destByteArray = new byte[fis.available()];
        //?
        fis.read(destByteArray);
        //定义一个响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename="+fileName);
        //设置响应状态
        int status = 200;
        HttpStatus statusCode = HttpStatus.OK;

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(destByteArray, headers, statusCode);

        return responseEntity;
    }

    @RequestMapping("upload")
    @ResponseBody
    public Map<String, Object> upload(MultipartFile dropzFile, HttpServletRequest request) throws IOException {
        System.out.println("inner upload");
        Map<String, Object> result = new HashMap<String, Object>();

        //创建文件需要存储的路径
        String destPathName = request.getSession().getServletContext().getRealPath("/static/upload");
        File destPath = new File(destPathName);
        //如果目标文件夹不存在我就创建它
        if(!destPath.exists()){
            destPath.mkdirs();
        }
        //获取文件的后缀名
        String fileSuffix = dropzFile.getOriginalFilename().substring(dropzFile.getOriginalFilename().lastIndexOf("."));

        String destFileName = UUID.randomUUID()+fileSuffix;
        System.out.println(destFileName);
        File destFile = new File(destPath,destFileName);
        System.out.println(destFile);
        if(!destFile.exists()){
            destFile.createNewFile();
        }
        dropzFile.transferTo(destFile);
        result.put("status",200);
        //http://localhost:8080/xxxxx/xxxx.jpg
        result.put("filePath","http://localhost:8080/static/upload/"+destFileName);
        return result;
    }

    //wangeditor示例
    static String UPLOAD_PATH = "/static/upload/";
    @ResponseBody
    @RequestMapping(value = "upload1", method = RequestMethod.POST)
    public Map<String, Object> upload1(MultipartFile editorFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();

        // 获取文件后缀
        String fileName = editorFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        System.out.println(filePath);
        InetAddress ia=null;
        try {
            ia = ia.getLocalHost();
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 判断路径是否存在，不存在则创建文件夹
        File file = new File(filePath);


        if (!file.exists()) {
            file.mkdir();
        }
        UUID uid=UUID.randomUUID();
        // 将文件写入目标
        file = new File(filePath, uid + fileSuffix);
        try {
            editorFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取服务端路径
        //%s  占位符
        String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
       System.out.println(serverPath+uid+fileSuffix);
        // 返回给 wangEditor 的数据格式
        result.put("errno", 0);
        result.put("data", new String[]{serverPath + file.getName()});
        System.out.println(result);
        return result;
    }

    @ResponseBody
    @RequestMapping("upload3")
    public String getPath(@RequestParam("src")String src){

        System.out.println(src);

        return src;
    }

}