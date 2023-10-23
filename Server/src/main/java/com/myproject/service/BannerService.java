/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.service;

import com.myproject.pojo.Banner;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vbmho
 */
public interface BannerService {
    List<Banner> getBanners();
    boolean addOrUpdateBanner(Banner b);
    Banner getBannerById(int id);
    int countBanners();
    List<Banner> getBanners(Map<String, String> params);
    boolean deleteBanner(int id);
    List<Banner> getBannersApi();
}

