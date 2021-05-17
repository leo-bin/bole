package com.bin.bole.api.controller;

import com.bin.bole.common.result.Result;
import com.bin.bole.common.utils.FastDFSUtils;
import com.bin.bole.domain.hr.Hr;
import com.bin.bole.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author binLi
 * @date 2021/5/10 5:31 下午
 * Description：hr info api
 **/
@RestController
public class HrInfoController {

    @Autowired
    HrService hrService;

    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication) {
        return ((Hr) authentication.getPrincipal());
    }

    @PutMapping("/hr/info")
    public Result updateHr(@RequestBody Hr hr, Authentication authentication) {
        if (hrService.updateHr(hr) == 1) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(), authentication.getAuthorities()));
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }

    @PutMapping("/hr/pass")
    public Result updateHrPasswd(@RequestBody Map<String, Object> info) {
        String oldpass = (String) info.get("oldpass");
        String pass = (String) info.get("pass");
        Integer hrid = (Integer) info.get("hrId");
        if (hrService.updateHrPasswd(oldpass, pass, hrid)) {
            return Result.success("更新成功!");
        }
        return Result.error("更新失败!");
    }

    @PostMapping("/hr/userface")
    public Result updateHrUserface(MultipartFile file, Integer id, Authentication authentication) {
        String fileId = FastDFSUtils.upload(file);
        String url = nginxHost + fileId;
        if (hrService.updateUserface(url, id) == 1) {
            Hr hr = (Hr) authentication.getPrincipal();
            hr.setUserface(url);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr, authentication.getCredentials(), authentication.getAuthorities()));
            return Result.success(url);
        }
        return Result.error("更新失败!");
    }


}