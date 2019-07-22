package top.zw.o2o.service;

import org.springframework.stereotype.Service;
import top.zw.o2o.entity.Area;

import java.util.List;
@Service
public interface AreaService {
    List<Area> getAreaList();

}
