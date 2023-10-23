/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.service.impl;


import com.myproject.pojo.Banner;
import com.myproject.repository.BannerRepository;
import com.myproject.service.BannerService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vbmho
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerRepository bannerRepo;

    @Override
    public List<Banner> getBanners() {
        return this.bannerRepo.getBanners();
    }

    @Override
    public boolean addOrUpdateBanner(Banner b) {
        return this.bannerRepo.addOrUpdateBanner(b);
    }

    @Override
    public int countBanners() {
        return this.bannerRepo.countBanners();
    }

    @Override
    public List<Banner> getBanners(Map<String, String> params) {
        return this.bannerRepo.getBanners(params);
    }

    @Override
    public Banner getBannerById(int id) {
        return this.bannerRepo.getBannerById(id);
    }

    @Override
    public boolean deleteBanner(int id) {
        return this.bannerRepo.deleteBanner(id);
    }

    @Override
    public List<Banner> getBannersApi() {
       return this.bannerRepo.getBannersApi();
    }
    
    
    
}
