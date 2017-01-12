package com.gdut.vo;

import java.util.List;

/**
 * Created by huang on 2017/1/7.
 */
public class FinishedProductVo {
    private Long id;
    private Integer num;
    private String url;
    private List<AttributeVo> attributeVos;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public List<AttributeVo> getAttributeVos() {
        return attributeVos;
    }

    public void setAttributeVos(List<AttributeVo> attributeVos) {
        this.attributeVos = attributeVos;
    }
}
