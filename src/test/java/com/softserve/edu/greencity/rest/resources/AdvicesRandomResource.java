package com.softserve.edu.greencity.rest.resources;

import java.util.List;

import com.softserve.edu.greencity.rest.dto.RestHttpMethods;
import com.softserve.edu.greencity.rest.dto.RestUrlRepository;
import com.softserve.edu.greencity.rest.engine.RestQueries;
import com.softserve.edu.greencity.rest.entity.AdvicesRandomEntity;
import com.softserve.edu.greencity.rest.entity.ResponseCodeEntity;
import com.softserve.edu.greencity.rest.tools.GenericConverter;

    public class AdvicesRandomResource extends RestQueries<AdvicesRandomEntity,
        ResponseCodeEntity, ResponseCodeEntity,
        ResponseCodeEntity, ResponseCodeEntity> {

    public AdvicesRandomResource() {
        super(RestUrlRepository.getAdvicesRandom());
        initParameters();
    }

    private void initParameters() {
        addEntityParameters(RestHttpMethods.GET, AdvicesRandomEntity.class);
        addEntityParameters(RestHttpMethods.POST, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PUT, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.DELETE, ResponseCodeEntity.class);
        addEntityParameters(RestHttpMethods.PATCH, ResponseCodeEntity.class);
//
        addListEntityParameters(RestHttpMethods.GET, 
            new GenericConverter<List<AdvicesRandomEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.POST, 
            new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.PUT,
            new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.DELETE, 
            new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
        addListEntityParameters(RestHttpMethods.PATCH, 
            new GenericConverter<List<ResponseCodeEntity>>() {}.getGenericType());
}

}
