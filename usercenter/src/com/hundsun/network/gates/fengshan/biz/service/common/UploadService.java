package com.hundsun.network.gates.fengshan.biz.service.common;

import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;

public abstract interface UploadService
{
  public abstract String uploadFile(InputStream paramInputStream, String paramString);

  public abstract String uploadFile(String paramString1, InputStream paramInputStream, String paramString2);

  public abstract String uploadFile(MultipartFile paramMultipartFile);

  public abstract boolean deleteOriginalFile(String paramString);
}

/* Location:           E:\__安装归档\linquan-20161112\deploy14\fengshan\webroot\WEB-INF\classes\
 * Qualified Name:     com.hundsun.network.gates.fengshan.biz.service.common.UploadService
 * JD-Core Version:    0.6.0
 */