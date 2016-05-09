package com.zzh.retrofit.service;

import com.zzh.ZZHConstants;
import com.zzh.retrofit.model.HospitalAndDepartment;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by ZZH on 16/4/27.
 */
public interface ZZHService {

    @GET(ZZHConstants.URL_TEST_JSON)
    HospitalAndDepartment getDataFromNet(@Query("type") String type);
}
