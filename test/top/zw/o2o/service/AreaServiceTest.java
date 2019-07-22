package top.zw.o2o.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.zw.o2o.BaseTest;
import top.zw.o2o.entity.Area;
import org.junit.Assert;

import java.util.List;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList(){
        List<Area> areaList = areaService.getAreaList();
        Assert.assertEquals("三期",areaList.get(0).getAreaName());
    }
}
