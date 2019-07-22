package top.zw.o2o.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.zw.o2o.BaseTest;
import top.zw.o2o.entity.Area;
import org.junit.Assert;

import java.util.List;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        for(Area area: areaList){
            System.out.println(area);
        }
        Assert.assertEquals(2,areaList.size());
    }

}
