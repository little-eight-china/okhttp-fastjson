package github.hjg;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * json解析类
 * @author little-eight
 */
public interface FastJsonHelper {

    /**
     * 解析
     * @param content 解析文本
     * @param classType 解析类型
     * @param <T> T
     * @return T
     */
    <T> T parse(String content, Class<T> classType) throws InterfaceException;

    /**
     * 解析
     * @param content
     * @param typeRef
     * @param <T>
     * @return
     */
    <T> T parse(String content, TypeReference<T> typeRef) throws InterfaceException;

    /**
     * 转Json.
     * @param object
     * @return String
     */
    String toString(Object object) throws InterfaceException;

    FastJsonHelper FAST_JSON_HELPER = new FastJsonHelper() {
        @Override
        public <T> T parse(String content, Class<T> classType) throws InterfaceException {
            try {
                return (T) JSON.parseObject(content,classType);
            } catch (Exception e) {
                throw new InterfaceException(e.getMessage(),e);
            }
        }

        @Override
        public <T> T parse(String content, TypeReference<T> typeRef) throws InterfaceException {
            try {
                return (T)JSON.parseObject(content,typeRef);
            } catch (Exception e) {
                throw new InterfaceException(e.getMessage(),e);
            }
        }

        @Override
        public String toString(Object object) throws InterfaceException {
            try {
                return JSON.toJSONString(object);
            } catch (Throwable t) {
                throw new InterfaceException(t);
            }
        }
    };
}
