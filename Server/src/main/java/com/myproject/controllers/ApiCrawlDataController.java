/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.myproject.pojo.MobileItems;
import com.google.gson.Gson;
import com.myproject.pojo.PostByCrawl;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thanh
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiCrawlDataController {

    @GetMapping("/slide")
    public ResponseEntity<Object> listSlide() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/").get();
        Elements elements = doc.select(".ms-slide");

        ArrayList<PostByCrawl> listPosts = new ArrayList<>();
        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(null);
            item.setDetailUrl(e.select(".ms-slide a").attr("href"));
            item.setImageUrl(e.select(".ms-slide img").attr("data-src"));
            System.out.println(item.getImageUrl());
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/post_tintuc")
    public ResponseEntity<Object> listPostsTintuc() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/tin-tuc/").get();

        Elements elements = doc.select(".content");

        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".small > a").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select("a.loadmore").attr("href"));
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/post_lichthi")
    public ResponseEntity<Object> listPostsLichthi() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/lich-thi/").get();

        Elements elements = doc.select(".content");

        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".small > a").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select("a.loadmore").attr("href"));
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/post_hoatdong_sinhvien")
    public ResponseEntity<Object> listPostsHDSV() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/hoat-dong-sinh-vien/").get();

        Elements elements = doc.select(".content");

        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".small > a").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select("a.loadmore").attr("href"));
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/chinhquy")
    public ResponseEntity<Object> listChinhQuy() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/tuyen_sinh_cat/daihoc_caodang/").get();

        Elements elements = doc.select(".list-tuyensinh .col.span_6");

        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".title").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select(".thumb").attr("href"));
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/saudaihoc")
    public ResponseEntity<Object> listSauDaiHoc() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/tuyen_sinh_cat/sau-dai-hoc/").get();

        Elements elements = doc.select(".list-tuyensinh .col.span_6");
        System.out.println(elements.size());
        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".title").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select(".thumb").attr("href"));
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);
        System.out.println("Sau đại học: ");
        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/daotaotuxa")
    public ResponseEntity<Object> listDaoTaoTuXa() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/tuyen_sinh_cat/trung-tam-dao-tao-tu-xa/").get();

        Elements elements = doc.select(".list-tuyensinh .col.span_6");

        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".title").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select(".thumb").attr("href"));
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/post_hoatdong_khoahoc")
    public ResponseEntity<Object> listHDKH() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/hoat-dong-khoa-hoc/").get();

        Elements elements = doc.select(".content");

        ArrayList<PostByCrawl> listPosts = new ArrayList<>();
        System.out.println(elements.size());
        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".small > a").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select("a.loadmore").attr("href"));
            item.setDate(e.select(".small > a > .date").text());
            if (item.getDate() != null && !item.getDate().isEmpty()) {
                String catDau = item.getDate().substring(1);
                System.out.println(catDau);
                String catDuoi = catDau.substring(0, 10);
                System.out.println(catDuoi);
                item.setDate(catDuoi);
            }
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/post_hoptac_quocte")
    public ResponseEntity<Object> listHTQT() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/hop-tac-quoc-te/").get();

        Elements elements = doc.select(".content");

        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".small > a").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select("a.loadmore").attr("href"));
            item.setDate(e.select(".small > a > .date").text());
            if (item.getDate() != null && !item.getDate().isEmpty()) {
                String catDau = item.getDate().substring(1);
                System.out.println(catDau);
                String catDuoi = catDau.substring(0, 10);
                System.out.println(catDuoi);
                item.setDate(catDuoi);
            }
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/post_tuyendung")
    public ResponseEntity<Object> listTD() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/tuyen-dung/").get();

        Elements elements = doc.select(".content");
        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".small > a").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select("a.loadmore").attr("href"));
            item.setDate(e.select(".small > a > .date").text());
            if (item.getDate() != null && !item.getDate().isEmpty()) {
                String catDau = item.getDate().substring(1);
                System.out.println(catDau);
                String catDuoi = catDau.substring(0, 10);
                System.out.println(catDuoi);
                item.setDate(catDuoi);
            }
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println(jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/post_center")
    public ResponseEntity<Object> listPostCenter() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/").get();

        Elements elements = doc.select(".list-getnews-khoa.col.span_12 > .col.span_4");
        System.out.println(elements.size());
        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst(".content > h3").text());
            item.setImageUrl(e.select(".thumb img").attr("src"));
            item.setDetailUrl(e.select(".thumb").attr("href"));
            item.setDate(e.select(".content > a.small").text());
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println("postCenter"+jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }

    @GetMapping("/list_categories")
    public ResponseEntity<Object> listCategories() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/").get();

        Elements elements = doc.select(".list_categories > .col.span_4");
        System.out.println(elements.size());
        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setTitle(e.selectFirst("a.title").text());
            item.setDetailUrl(e.select("a").attr("href"));
            item.setDate(e.select("p").text());
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);

        System.out.println("Cates"+jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }
    
    @GetMapping("/website")
    public ResponseEntity<Object> listWeb() throws IOException {
        Document doc = Jsoup.connect("https://ou.edu.vn/").get();

        Elements elements = doc.select(".vc_col-sm-6.wpb_column.no-extra-padding > .wpb_wrapper");
        System.out.println(elements.size());
        ArrayList<PostByCrawl> listPosts = new ArrayList<>();

        for (Element e : elements) {
            PostByCrawl item = new PostByCrawl();
            item.setImageUrl(e.selectFirst("a > img.img-with-animation").attr("src"));
            item.setDetailUrl(e.select("a").attr("href"));
            listPosts.add(item);
        }

        Gson gson = new Gson();
        String jsonData = gson.toJson(listPosts);
        
        System.out.println("Web"+jsonData);

        for (int i = 0; i < listPosts.size(); ++i) {
            System.out.println(i + " Title: " + listPosts.get(i).getTitle());
        }

        return new ResponseEntity<>(jsonData, HttpStatus.OK);
    }
}
