package com.youyue.manage_cms.dao;

import com.youyue.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 页面查询dao
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {

}
