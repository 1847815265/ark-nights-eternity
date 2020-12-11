package com.arknights.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.arknights.pojo.UploadedImageFile;
 
@Controller
public class UploadController {
 
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file)
            throws IllegalStateException, IOException {
    	//起随机名
        String name = RandomStringUtils.randomAlphanumeric(10);
        String newFileName =name + ".jpg";
        //连接文件存放路径并新建文件夹之后复制文件到指定文件夹
        File newFile = new File(request.getServletContext().getRealPath("/static/img/gameing"), newFileName);
        newFile.getParentFile().mkdirs();
        file.getImage().transferTo(newFile);
        //跳转到指定页面并展示图片
        ModelAndView mav = new ModelAndView("showUploadedFile");
        mav.addObject("imageName", newFileName);
        return mav;
    }
    
	@RequestMapping("uploadImg")
	public ModelAndView listcustomer() {
		ModelAndView mav = new ModelAndView("uploadImg");
		return mav;
	}
}