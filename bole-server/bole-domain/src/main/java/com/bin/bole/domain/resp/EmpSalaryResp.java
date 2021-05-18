package com.bin.bole.domain.resp;

import com.bin.bole.domain.emp.Salary;
import lombok.Data;

/**
 * @author binLi
 * @date 2021/5/17 20:26
 * Description:
 */
@Data
public class EmpSalaryResp {

    private Integer eid;
    private String name;
    private String gender;
    private String workId;
    private Integer baseSalary;
    private Salary salary;
}
