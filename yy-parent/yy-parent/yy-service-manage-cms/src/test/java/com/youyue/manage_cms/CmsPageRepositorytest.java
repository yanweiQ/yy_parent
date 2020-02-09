package com.youyue.manage_cms;

import com.youyue.framework.domain.cms.CmsPage;
import com.youyue.framework.domain.cms.CmsPageParam;
import com.youyue.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositorytest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    //查询所有
    @Test
    public void testFindAll(){
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);
    }
    //分页查询
    @Test
    public void testPage(){
        //分页参数
        int page = 3;
        int size = 5;
        Pageable pageable = PageRequest.of(page, size);
//        构建条件值对象
        CmsPage cmsPage = new CmsPage();
//        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");站点id
        cmsPage.setPageAliase("课程详情");
//        条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
        .withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
//          定义Example
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
//        of方法第一个参数表示存放条件值对象
//        第二个参数表示条件匹配器
        Page<CmsPage> pages = cmsPageRepository.findAll(example,pageable);
        System.out.println(pages.getContent());
    }
    //修改
    @Test
    public void testSave(){
        //查询对象 optional相当于jdk1.8出现的新特性
        Optional<CmsPage> optional = cmsPageRepository.findById("5e3a6a5787783b1a080f8d46");
        if(optional.isPresent()){//表示判断容器内内容是否为空
            //设置修改的值
            CmsPage cmsPage = optional.get();
            cmsPage.setPageAliase("test01");
            //修改
            cmsPageRepository.save(cmsPage);
        }
    }

    //添加
    @Test
    public void add(){
        //定义实体类
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }



}
