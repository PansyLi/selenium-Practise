package com.testcase.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class GetTestData {
    public static Stream<List<HashMap<String, Object>>> getUserInfoDataFromYaml() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference=new TypeReference<List<HashMap<String, Object>>>(){};
        List<HashMap<String, Object>> userInfo = objectMapper.readValue(new File("src/main/resources/data/userInfo.yaml"), typeReference);
        return Stream.of(userInfo) ;
    }
    public static Stream<String> getDepartmentName(){
        return Stream.of("dx5_" + System.currentTimeMillis()) ;
    }
}
