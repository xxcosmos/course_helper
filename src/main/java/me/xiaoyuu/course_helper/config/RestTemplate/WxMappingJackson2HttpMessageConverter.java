package me.xiaoyuu.course_helper.config.RestTemplate;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

class WxMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
    WxMappingJackson2HttpMessageConverter() {
        List<MediaType> mediaTypes = new ArrayList<>();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        mediaTypes.add(type);
        mediaTypes.add(MediaType.ALL);
        setSupportedMediaTypes(mediaTypes);
    }
}
