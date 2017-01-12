package com.gdut.vo;

import com.gdut.utils.Invisible;

/**
 * Created by huang on 2017/1/7.
 */
public class AttributeVo {
    private Long id;
    private Long finishedId;
    private String attributeName;
    private Long materialId;

    private String url;



    private MaterialVo materialVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinishedId() {
        return finishedId;
    }

    public void setFinishedId(Long finishedId) {
        this.finishedId = finishedId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MaterialVo getMaterialVo() {
        return materialVo;
    }

    public void setMaterialVo(MaterialVo materialVo) {
        this.materialVo = materialVo;
    }

}
