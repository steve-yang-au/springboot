package com.steve.boot.launch.utils;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.Collection;
import java.util.List;

public class DozerUtils {

    static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClazz){
        return sourceList.stream()
                .map((s) -> mapper.map(s, destinationClazz))
                .toList();
    }
}
