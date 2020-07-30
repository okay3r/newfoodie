package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.CategoryPO;
import top.newfoodie.domain.po.CategoryPOExample;

public interface CategoryPOMapper {
    int countByExample(CategoryPOExample example);

    int deleteByExample(CategoryPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryPO record);

    int insertSelective(CategoryPO record);

    List<CategoryPO> selectByExample(CategoryPOExample example);

    CategoryPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryPO record, @Param("example") CategoryPOExample example);

    int updateByExample(@Param("record") CategoryPO record, @Param("example") CategoryPOExample example);

    int updateByPrimaryKeySelective(CategoryPO record);

    int updateByPrimaryKey(CategoryPO record);
}