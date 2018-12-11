
## 项目介绍

OkHttp-FastJson，一个让网络请求更简单的框架。
* 网络框架使用最热门的OkHttp3，比HttpClient性能更强，引用api更简单！
* 自动帮你解析请求响应的JSON数据，让你专注于处理业务逻辑。JSON解析用阿里的fastJson，速度比gson和fackson更快，引用api更简单！


## 快速入门

* 克隆本项目，并mvn install。
* 在pom.xml引入okhttp-fastjson。
```xml
    <dependency>
        <groupId>github.hjg</groupId>
	<artifactId>okhttp-fastjson</artifactId>
	<version>1.0.0</version>
</dependency>
```
* okhttp-fastjson提供了三种请求方式
```java
     /**
	 * 自定义请求
	 * 
	 * @param request
	 * @param responseType
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	public <T> T requestForObject(Request request, Class<T> responseType) throws InterfaceException {
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}
```
```java
    /**
	 * GET
	 * 
	 * @param url
	 * @param responseType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

```
```java
     /**
     * POST
     * @param url
     * @param responseType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
	public <T> T postForObject(String url, Class<T> responseType, String content, MediaType mediaType)
			throws InterfaceException {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}
```
* 这是get请求的例子。
* 新建web项目，新建JavaBean:ProductVo类和测试类TestController类，然后“../test/getService”模拟Web接口服务端，“../test/get”模拟客户端去调用服务端

```java

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class ProductVo {
    private int id ;
    private String name ;
    private double price ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
```
```java
import github.hjg.FastJsonHelper;
import github.hjg.InterfaceException;
import github.hjg.JsonInterface;
import github.hjg.OkHttpInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
        //模拟服务端
        @GetMapping("/getService")
        public String  getService() {
                return "{\"id\":1,\"name\":\"test\",\"price\":23.01}";
        }
        //模拟客户端
	@GetMapping("/get")
	public String getTest() throws InterfaceException {
	   OkHttpInterface okhttpInterface = new JsonInterface();
	   ProductVo product = okhttpInterface.getForObject("http://localhost:8080/test/getService", ProductVo.class,"");
	   return FastJsonHelper.FAST_JSON_HELPER.toString(product);
	}

```
* 启动项目，访问http://localhost:8080/test/get，可以直观看到结果.
```java
 {
id: 1,
name: "test",
price: 23.01
}
```

* 当然你也能根据具体需求去自定义OkHttpInterface的参数配置
```java
    OkHttpInterface okHttpInterface = new JsonInterface(
        new OkHttpConfig.Builder()
            .connectTimeout(3000) //配置连接超时参数,默认10000
            .readTimeout(3000) //读超时参数,默认10000
            .writeTimeout(3000) //写超时参数,默认10000
            //以及对这些连接的的连接新池参数配置
            .maxIdleConnections(5) //最大空闲连接数,默认5个
            .keepAliveDuration(300000).build()); //,最大存活时间,默认300000
```

