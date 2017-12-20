package github.hjg;


import java.util.Map;

/**
 * 常用的访问方法.
 * @author little-eight
 */
public class OkHttpClientUtils {


    /**
     * get请求.
     *
     * @param requestMap 请求体
     * @param cla 返回体的class
     * @param url 请求地址
     * @return responseVo
     * @throws Exception
     */
    public static  <T> T getApiGoBack(Map<String, String> requestMap, Class<T> cla, String url) throws Exception {
        OkHttpInterface httpInterface = new JsonInterface();
        T responseVo;
        try {
            responseVo = httpInterface.getForObject(url, cla, requestMap);
        } catch (InterfaceException e) {
            throw new Exception("访问异常,异常信息："+e.getMessage(),e);
        } catch (Exception e) {
            throw new Exception("请求参数错误异常,异常信息："+e.getMessage(),e);
        }
        return responseVo;
    }

    /**
     * get请求.（有头部要求）
     *
     * @param requestMap 请求体
     * @param headers 头部
     * @param cla 返回体的class
     * @param url 请求地址
     * @return responseVo
     * @throws Exception
     */
    public static <T> T getApiWithHeadersGoBack(Map<String, String> requestMap, Map<String, String> headers, Class<T> cla, String url) throws Exception {
        OkHttpInterface httpInterface = new JsonInterface();
        T responseVo;
        try {
            responseVo = httpInterface.getForObject(url, headers, cla, requestMap);
        } catch (InterfaceException e) {
            throw new Exception("访问异常,异常信息："+e.getMessage(),e);
        } catch (Exception e) {
            throw new Exception("请求参数错误异常,异常信息："+e.getMessage(),e);
        }
        return responseVo;
    }


    /**
     * post请求.（请求体为生成类的字符串化）
     *
     * @param requestVo 请求体
     * @param cla 返回体的class
     * @param url 请求地址
     * @return responseVo
     * @throws Exception
     */
    public static <T> T postApiWithVoGoBack(String requestVo, Class<T> cla, String url) throws Exception {
        OkHttpInterface httpInterface = new JsonInterface();
        T responseVo;
        try {
            responseVo = httpInterface.postForObject(url, cla, requestVo, OkHttpHelper.JSON_UTF8);
        }  catch (InterfaceException e) {
            throw new Exception("访问异常,异常信息："+e.getMessage(),e);
        } catch (Exception e) {
            throw new Exception("请求参数错误异常,异常信息："+e.getMessage(),e);
        }
        return responseVo;
    }

    /**
     * post请求.（请求体为生成类的字符串化，且有头部请求）
     *
     * @param requestVo 请求体
     * @param headers 头部
     * @param cla 返回体的class
     * @param url 请求地址
     * @return responseVo
     * @throws Exception
     */
    public static <T> T postApiWithVoHeadersGoBack(String requestVo, Map<String, String> headers, Class<T> cla, String url) throws Exception {
        OkHttpInterface httpInterface = new JsonInterface();
        T responseVo;
        try {
            responseVo = httpInterface.postForObject(url, headers, cla, requestVo, OkHttpHelper.JSON_UTF8);
        }  catch (InterfaceException e) {
            throw new Exception("访问异常,异常信息："+e.getMessage(),e);
        } catch (Exception e) {
            throw new Exception("请求参数错误异常,异常信息："+e.getMessage(),e);
        }
        return responseVo;
    }

    /**
     * post请求.（请求体为封装进Map里的集合）
     *
     * @param requestMap 请求体
     * @param cla 返回体的class
     * @param url 请求地址
     * @return responseVo
     * @throws Exception
     */
    public static <T> T postApiWithMapGoBack(Map<String,String> requestMap, Class<T> cla, String url) throws Exception {
        OkHttpInterface httpInterface = new JsonInterface();
        T responseVo;
        try {
            responseVo = httpInterface.postForObject(url, cla, requestMap, OkHttpHelper.JSON_UTF8);
        }  catch (InterfaceException e) {
            throw new Exception("访问异常,异常信息："+e.getMessage(),e);
        } catch (Exception e) {
            throw new Exception("请求参数错误异常,异常信息："+e.getMessage(),e);
        }
        return responseVo;
    }

    /**
     * post请求.（请求体为封装进Map里的集合且有头部请求）
     *
     * @param requestMap 请求体
     * @param headers 头部
     * @param cla 返回体的class
     * @param url 请求地址
     * @return responseVo
     * @throws Exception
     */
    public static <T> T postApiWithMapHeadersGoBack(Map<String,String> requestMap, Map<String, String> headers, Class<T> cla, String url) throws Exception {
        OkHttpInterface httpInterface = new JsonInterface();
        T responseVo;
        try {
            responseVo = httpInterface.postForObject(url, headers, cla, requestMap, OkHttpHelper.JSON_UTF8);
        }  catch (InterfaceException e) {
            throw new Exception("访问异常,异常信息："+e.getMessage(),e);
        } catch (Exception e) {
            throw new Exception("请求参数错误异常,异常信息："+e.getMessage(),e);
        }
        return responseVo;
    }
}
