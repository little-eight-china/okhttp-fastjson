package github.hjg;

import com.alibaba.fastjson.TypeReference;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.Map;

/**
 * Http请求接口
 * @author little-eight
 */
public interface OkHttpInterface {



    FastJsonHelper fastJsonHelper();
    /**
     * 请求对象
     * @return
     */
    OkHttpHelper okHttpHelper();


    /**
     * 请求对象
     * @param okhttpConfig
     * @return
     */
    OkHttpHelper okHttpHelper(OkHttpConfig okhttpConfig);


    /**
     * 自定义请求
     * @param request
     * @param responseType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T requestForObject(Request request, Class<T> responseType) throws InterfaceException;

    /**
     * 自定义请求
     * @param request
     * @param typeRef
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T requestForObject(Request request, TypeReference<T> typeRef) throws InterfaceException;

    /**
     * 自定义请求
     * @param request
     * @param responseType
     * @param okhttpConfig
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T requestForObject(Request request, Class<T> responseType, OkHttpConfig okhttpConfig) throws InterfaceException;

    /**
     * 自定义请求
     * @param request
     * @param typeRef
     * @param okhttpConfig
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T requestForObject(Request request, TypeReference<T> typeRef, OkHttpConfig okhttpConfig) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, TypeReference<T> typeRef, Object... uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param responseType
     * @param httpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Class<T> responseType, OkHttpConfig httpConfig, Object... uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param typeRef
     * @param okhttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, TypeReference<T> typeRef, OkHttpConfig okhttpConfig, Object... uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     */
    <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType,
                       Object... uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     */
    <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                       Object... uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param responseType
     * @param okhttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okhttpConfig,
                       Object... uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param typeRef
     * @param okhttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, OkHttpConfig okhttpConfig,
                       Object... uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, TypeReference<T> typeRef, Map<String, ?> uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param responseType
     * @param okhttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Class<T> responseType, OkHttpConfig okhttpConfig, Map<String, ?> uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param typeRef
     * @param okhttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, TypeReference<T> typeRef, OkHttpConfig okhttpConfig, Map<String, ?> uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param responseType
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType,
                       Map<String, ?> uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                       Map<String, ?> uriVariables) throws InterfaceException;


    /**
     * GET请求
     * @param url
     * @param responseType
     * @param okhttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okhttpConfig,
                       Map<String, ?> uriVariables) throws InterfaceException;

    /**
     * GET请求
     * @param url
     * @param typeRef
     * @param okhttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, OkHttpConfig okhttpConfig,
                       Map<String, ?> uriVariables) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param responseType
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Class<T> responseType, RequestBody requestBody) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param typeRef
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, TypeReference<T> typeRef, RequestBody requestBody) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param responseType
     * @param okhttpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Class<T> responseType, OkHttpConfig okhttpConfig, RequestBody requestBody) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param typeRef
     * @param okhttpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, TypeReference<T> typeRef, OkHttpConfig okhttpConfig, RequestBody requestBody) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param responseType
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType,
                        RequestBody requestBody) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param typeRef
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                        RequestBody requestBody) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param responseType
     * @param okhttpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okhttpConfig,
                        RequestBody requestBody) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param typeRef
     * @param okhttpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, OkHttpConfig okhttpConfig,
                        RequestBody requestBody) throws InterfaceException;


    /**
     * POST请求
     * @param url
     * @param responseType
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Class<T> responseType,
                        String content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param typeRef
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, TypeReference<T> typeRef,
                        String content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param responseType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Class<T> responseType,
                        Object content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param typeRef
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, TypeReference<T> typeRef,
                        Object content, MediaType mediaType) throws InterfaceException;


    /**
     * POST请求
     * @param url
     * @param headers
     * @param responseType
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType,
                        String content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param typeRef
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                        String content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param responseType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType,
                        Object content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param typeRef
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
                        Object content, MediaType mediaType) throws InterfaceException;


    /**
     * POST请求
     * @param url
     * @param headers
     * @param responseType
     * @param okhttpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okhttpConfig,
                        String content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param typeRef
     * @param okhttpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, OkHttpConfig okhttpConfig,
                        String content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param responseType
     * @param okhttpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okhttpConfig,
                        Object content, MediaType mediaType) throws InterfaceException;

    /**
     * POST请求
     * @param url
     * @param headers
     * @param typeRef
     * @param okhttpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    <T> T postForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, OkHttpConfig okhttpConfig,
                        Object content, MediaType mediaType) throws InterfaceException;
}
