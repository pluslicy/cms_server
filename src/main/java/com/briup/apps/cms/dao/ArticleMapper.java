package com.briup.apps.cms.dao;

import com.briup.apps.cms.bean.Article;
import com.briup.apps.cms.bean.ArticleExample;
import com.briup.apps.cms.bean.ArticleWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ArticleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    long countByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int deleteByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int insert(ArticleWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int insertSelective(ArticleWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    List<ArticleWithBLOBs> selectByExampleWithBLOBs(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    List<Article> selectByExample(ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    ArticleWithBLOBs selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int updateByExampleSelective(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") ArticleWithBLOBs record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int updateByPrimaryKeySelective(ArticleWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(ArticleWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cms_article
     *
     * @mbg.generated Wed Sep 26 13:18:10 CST 2018
     */
    int updateByPrimaryKey(Article record);
}