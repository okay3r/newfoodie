package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.OrdersPO;
import top.newfoodie.domain.po.OrdersPOExample;

public interface OrdersPOMapper {
    int countByExample(OrdersPOExample example);

    int deleteByExample(OrdersPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrdersPO record);

    int insertSelective(OrdersPO record);

    List<OrdersPO> selectByExample(OrdersPOExample example);

    OrdersPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrdersPO record, @Param("example") OrdersPOExample example);

    int updateByExample(@Param("record") OrdersPO record, @Param("example") OrdersPOExample example);

    int updateByPrimaryKeySelective(OrdersPO record);

    int updateByPrimaryKey(OrdersPO record);
}