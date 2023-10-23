/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.repository;

import com.myproject.pojo.Banner;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vbmho
 */
public interface BannerRepository {
    List<Banner> getBanners();
    boolean addOrUpdateBanner(Banner b);
    int countBanners();
    List<Banner> getBanners(Map<String, String> params);
    Banner getBannerById(int id);
    boolean deleteBanner(int id);
    List<Banner> getBannersApi();
}
