package com.sch.student.service.Impl;

import com.sch.student.entity.AccountEntity;
import com.sch.student.entity.ImgInfomationEntity;
import com.sch.student.repository.ImgInfoRepository;
import com.sch.student.service.ImgService;
import com.sch.student.util.ImageUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgInfoRepository imgInfoRepository;

    @Override
    public ImgInfomationEntity findImgById(Long id){
        Optional<ImgInfomationEntity> img = imgInfoRepository.findById(id);
        return img.get();
    }

    @Override
    public  ImgInfomationEntity findImgByAccountId(Long id){
        return imgInfoRepository.findImgByAccountId(id);
    }

    @Override
    public void uploadImgInFolder(AccountEntity account ,MultipartFile imgFront, MultipartFile imgBack, MultipartFile imgUser) throws IOException {
        ImgInfomationEntity img = ImgInfomationEntity.builder()
                .namePathFront(ImageUtils.compressImage(imgFront.getBytes()))
                .namePathBack(ImageUtils.compressImage(imgBack.getBytes()))
                .namePathUser(ImageUtils.compressImage(imgUser.getBytes()))
                .type(imgFront.getContentType())
                .nameImg(imgFront.getOriginalFilename())
                .account(account)
                .build();
        imgInfoRepository.save(img);
    }

    public void saveImg(ImgInfomationEntity img){
        imgInfoRepository.save(img);
    }

    public ImgInfomationEntity setImgInFolder(AccountEntity account ,MultipartFile imgFront, MultipartFile imgBack, MultipartFile imgUser) throws IOException {
        ImgInfomationEntity img = ImgInfomationEntity.builder()
                .namePathFront(ImageUtils.compressImage(imgFront.getBytes()))
                .namePathBack(ImageUtils.compressImage(imgBack.getBytes()))
                .namePathUser(ImageUtils.compressImage(imgUser.getBytes()))
                .type(imgFront.getContentType())
                .nameImg(imgFront.getOriginalFilename())
                .account(account)
                .build();
        return img;
    }

    @Override
    public byte[] downloadImg(Long id){
        ImgInfomationEntity imgage = findImgById(id);
        byte[] img = ImageUtils.decompressImage(imgage.getNamePathFront());
        return img;
    }

    public byte[] downloadImgAll(Long id , byte[] file){
        ImgInfomationEntity imgage = findImgById(id);
        byte[] img = ImageUtils.decompressImage(imgage.getNamePathFront());
        return img;
    }
}
