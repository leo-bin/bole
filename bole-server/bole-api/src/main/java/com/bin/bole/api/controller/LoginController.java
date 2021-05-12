package com.bin.bole.api.controller;


import com.bin.bole.api.config.VerificationCode;
import com.bin.bole.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：login api
 **/
@RestController
public class LoginController {

    @GetMapping("/login")
    public Result login() {
        return Result.error("尚未登录，请登录!");
    }

    /**
     * 随机获取一张验证码图片
     */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession(true);
        session.setAttribute("verify_code", text);
        VerificationCode.output(image, resp.getOutputStream());
    }
}
