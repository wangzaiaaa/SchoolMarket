package top.zw.o2o.dao;

import org.springframework.stereotype.Repository;
import top.zw.o2o.entity.Area;

import java.util.List;
@Repository
public interface AreaDao {
    /**
     * 列出区域列表
     * @return list
     */
    List<Area> queryArea();

}
