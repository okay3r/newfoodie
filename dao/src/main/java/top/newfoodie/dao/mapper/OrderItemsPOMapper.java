package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.OrderItemsPO;
import top.newfoodie.domain.po.OrderItemsPOExample;

public interface OrderItemsPOMapper {
    int countByExample(OrderItemsPOExample example);

    int deleteByExample(OrderItemsPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderItemsPO record);

    int insertSelective(OrderItemsPO record);

    List<OrderItemsPO> selectByExample(OrderItemsPOExample example);

    OrderItemsPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderItemsPO record, @Param("example") OrderItemsPOExample example);

    int updateByExample(@Param("record") OrderItemsPO record, @Param("example") OrderItemsPOExample example);

    int updateByPrimaryKeySelective(OrderItemsPO record);

    int updateByPrimaryKey(OrderItemsPO record);
}