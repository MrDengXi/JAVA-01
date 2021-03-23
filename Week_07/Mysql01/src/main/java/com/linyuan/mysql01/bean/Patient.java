package com.linyuan.mysql01.bean;

import java.time.LocalDateTime;

/**
 * @Author DengXi
 * @Date 2021/3/15 2:45 下午
 * @desc:描述
 */
public class Patient {
    public Long id;

    public LocalDateTime createTime;
    public LocalDateTime modifyTime;
    /**
     * 手机号
     */
    private String mobile;

    private String name;

    private String idNo;
    /**
     * 性别，1-男，0-女
     */
    private Integer gender;
    /**
     * 年龄
     */
    private Integer ages;
    private Double weight;
    private String symptom;
    private String illness;
    private Long storeId;

    /**
     * 患者类型，1成人，2儿童
     */
    private Integer patientType;
    /**
     * 监护人手机号
     */
    private String guardianMobile;
    /**
     * 监护人姓名
     */
    private String guardianName;

    private  String idCardKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAges() {
        return ages;
    }

    public void setAges(Integer ages) {
        this.ages = ages;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    public String getGuardianMobile() {
        return guardianMobile;
    }

    public void setGuardianMobile(String guardianMobile) {
        this.guardianMobile = guardianMobile;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getIdCardKey() {
        return idCardKey;
    }

    public void setIdCardKey(String idCardKey) {
        this.idCardKey = idCardKey;
    }
}
