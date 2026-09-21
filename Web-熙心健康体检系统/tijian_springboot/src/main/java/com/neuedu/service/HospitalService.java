package com.neuedu.service;


import com.neuedu.po.Hospital;

import java.util.List;

public interface HospitalService {

    public List<Hospital> listHospital(Integer state);
    public Hospital getHospitalById(Integer hpId);
}
