package com.youyue.manage_cms.dao;

import com.youyue.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 页面查询dao
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

    //根据页面名称查询
    CmsPage findByPageName(String pageName);
        //我们在controller调用接口的时候 封装了查询条件 最终查询条件会传递到dao
        //因为我们应该在dao中定义一个可以根据分页和条件同时区查询的方法 但是如果没有查询条件那么直接按照查询

    //根据页面名称 站点id 页面webpath查询
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);
}
