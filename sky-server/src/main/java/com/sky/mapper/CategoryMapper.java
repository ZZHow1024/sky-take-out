package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.Autofill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZZHow
 * @date 2024/8/18
 */
@Mapper
public interface CategoryMapper {

    /**
     * 新增分类
     *
     * @param category
     */
    @Autofill(value = OperationType.INSERT)
    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user)" +
            " values (#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Category category);

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类
     *
     * @param category
     */
    @Autofill(value = OperationType.UPDATE)
    void update(Category category);

    /**
     * 根据 ID 删除分类
     *
     * @param id
     */
    @Delete("delete from category where id = #{id}")
    void delete(Long id);

    /**
     * 根据类型查询分类
     *
     * @param type
     * @return
     */
    // `id`, `type`, `name`, `sort`, `status`, `create_time`, `update_time`, `create_user`, `update_user`
    @Select("select `id`, `type`, `name`, `sort`, `status`, `create_time`, `update_time`, `create_user`, `update_user`" +
            " from `category` where type = #{type}")
    List<Category> select(Integer type);
}
