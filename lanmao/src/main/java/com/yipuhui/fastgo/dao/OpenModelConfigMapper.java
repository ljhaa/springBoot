package com.yipuhui.fastgo.dao;


import com.yipuhui.fastgo.enty.OpenModelConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * class
 *
 * @author 刘俊汉
 * @date 2018/5/14 14:38
 */
@Mapper
public interface OpenModelConfigMapper extends BaseMapper<OpenModelConfig> {
	
    /**
     * 
     * Description: 根据模式类别获取信息
     *
     * @param modelType
     * @return
     * @Author chengzhichao
     * @Create Date: 2016年1月7日 下午5:15:23
     */
	Map<String, Object> getByModelType(String modelType);
}