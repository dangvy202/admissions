package com.sch.student.service;

import com.sch.student.entity.AccountEntity;
import com.sch.student.entity.ImgInfomationEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImgService {
    ImgInfomationEntity findImgById(Long id);
    ImgInfomationEntity findImgByAccountId(Long id);
    void uploadImgInFolder(AccountEntity account,MultipartFile imgFront, MultipartFile imgBack, MultipartFile imgUser) throws IOException;
    byte[] downloadImg(Long id);

}
