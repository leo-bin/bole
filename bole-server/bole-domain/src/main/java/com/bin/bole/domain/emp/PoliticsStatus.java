package com.bin.bole.domain.emp;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author leo-bin
 * @date 2021/5/11 15:23
 * @apiNote 政治状态
 */
public class PoliticsStatus implements Serializable {

    private Integer id;
    /**
     * 公民，党员，共青团员
     */
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PoliticsStatus that = (PoliticsStatus) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public PoliticsStatus() {
    }

    public PoliticsStatus(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}