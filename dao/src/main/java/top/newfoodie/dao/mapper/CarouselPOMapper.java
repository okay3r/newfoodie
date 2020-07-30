package top.newfoodie.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.newfoodie.domain.po.CarouselPO;
import top.newfoodie.domain.po.CarouselPOExample;

public interface CarouselPOMapper {
    int countByExample(CarouselPOExample example);

    int deleteByExample(CarouselPOExample example);

    int deleteByPrimaryKey(String id);

    int insert(CarouselPO record);

    int insertSelective(CarouselPO record);

    List<CarouselPO> selectByExample(CarouselPOExample example);

    CarouselPO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CarouselPO record, @Param("example") CarouselPOExample example);

    int updateByExample(@Param("record") CarouselPO record, @Param("example") CarouselPOExample example);

    int updateByPrimaryKeySelective(CarouselPO record);

    int updateByPrimaryKey(CarouselPO record);
}