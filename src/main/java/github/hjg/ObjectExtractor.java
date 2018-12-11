package github.hjg;

import com.alibaba.fastjson.TypeReference;
import okhttp3.Response;

import java.io.IOException;

/**
 * 实体请求结果抓取器
 * @author little-eight
 */
public class ObjectExtractor<T> {

    private FastJsonHelper fastJsonHelper;

    private Class<T> responseType;

    private TypeReference<T> typeRef;

    public ObjectExtractor(FastJsonHelper fastJsonHelper, Class<T> responseType) {
        this.fastJsonHelper = fastJsonHelper;
        this.responseType = responseType;
    }

    public ObjectExtractor(FastJsonHelper fastJsonHelper, TypeReference<T> typeRef) {
        this.fastJsonHelper = fastJsonHelper;
        this.typeRef = typeRef;
    }

    T extractData(Response response) throws IOException, InterfaceException {
        String resp = response.body().string();

        if(responseType == null) {
            return (T) fastJsonHelper.parse(resp, typeRef);
        }
        return (T)fastJsonHelper.parse(resp,responseType);
    }
}
