package com.bin.bole.domain.req;

import com.bin.bole.domain.hr.Hr;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotNull;

/**
 * @author binLi
 * @date 2021/5/17 0:37
 * Description:
 */
@Data
public class AddHrReq {

    private String name;
    @NotNull(message = "username不能为空")
    private String username;
    @NotNull(message = "phone不能为空")
    private String phone;
    @NotNull(message = "telephone不能为空")
    private String telephone;


    public Hr transfer2Hr() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Hr hr = new Hr();
        hr.setName(this.username);
        hr.setUsername(this.username);
        hr.setPhone(this.phone);
        hr.setTelephone(this.telephone);
        hr.setEnabled(true);
        hr.setPassword(encoder.encode("123"));
        hr.setUserface("https://bins-pic.oss-cn-shanghai.aliyuncs.com/mypic/bole-hr-default-logo.png");
        return hr;
    }
}
