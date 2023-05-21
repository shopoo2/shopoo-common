package com.shopoo.common.app.file;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import jakarta.annotation.Resource;

import com.shopoo.common.app.file.converter.AppConverter;
import com.shopoo.common.file.api.ImageService;
import com.shopoo.common.file.dto.cqe.ImageAddCmd;
import com.shopoo.common.infrastructure.file.repository.database.dataobject.Image;
import com.shopoo.common.infrastructure.file.repository.database.mapper.ImageMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @Package com.szmengran.file.service.impl
 * @Description: 图片服务
 * @date Feb 21, 2019 6:35:51 PM
 * @author <a href="mailto:android_li@sina.cn">Joe</a>
 */
@Service
public class ImageServiceImpl implements ImageService {

    private final static ExecutorService executor = new ThreadPoolExecutor(20, 200, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    private final static Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);
    
    @Resource
    private ImageMapper imageMapper;
    
    @SneakyThrows
    @Override
    public Boolean save(ImageAddCmd[] images) {
        LocalDateTime createstamp = LocalDateTime.now();
        Set<Future<Boolean>> set = new HashSet<>();
        for (int i=0; i<images.length; i++) {
            Image image = AppConverter.INSTANCE.toImage(images[i]);
            image.setCreatestamp(createstamp);
            image.setValidstatus("1");
            Future<Boolean> future = executor.submit(() -> {
                try {
                    return imageMapper.insert(image) > 0;
                } catch (DuplicateKeyException e) {
                    logger.error("文件已存在：", e);
                    return true;
                } catch (Exception e) {
                    logger.error("文件保存失败：", e);
                    return false;
                }
            });
            set.add(future);
        }
        Iterator<Future<Boolean>> iter = set.iterator();
        while (iter.hasNext()) {
            Future<Boolean> flagFuture = iter.next();
            if (!flagFuture.get()) {
                return false;
            }
        }
        return true;
    }
}
