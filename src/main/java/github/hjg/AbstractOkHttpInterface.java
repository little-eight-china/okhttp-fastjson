package github.hjg;

import com.alibaba.fastjson.TypeReference;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * Http请求方法抽象实现
 * 
 * @author little-eight
 */
public abstract class AbstractOkHttpInterface implements OkHttpInterface {
	
	/**
	 * 自定义请求
	 * 
	 * @param request
	 * @param responseType
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T requestForObject(Request request, Class<T> responseType) throws InterfaceException {
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * 自定义请求
     * @param request
     * @param typeRef
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T requestForObject(Request request, TypeReference<T> typeRef) throws InterfaceException {
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }

	/**
	 * 自定义请求
	 * 
	 * @param request
	 * @param responseType
	 * @param okHttpConfig
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T requestForObject(Request request, Class<T> responseType, OkHttpConfig okHttpConfig)
			throws InterfaceException {
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(okHttpConfig, request, extractor);
	}

    /**
     * 自定义请求
     * @param request
     * @param typeRef
     * @param okHttpConfig
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T requestForObject(Request request, TypeReference<T> typeRef, OkHttpConfig okHttpConfig) throws InterfaceException
    {
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }
	
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
	@Override
	public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * GET
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T getForObject(String url, TypeReference<T> typeRef, Object... uriVariables) throws InterfaceException {
        Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }

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
	@Override
	public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables)
			throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * GET
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T getForObject(String url, TypeReference<T> typeRef, Map<String, ?> uriVariables) throws InterfaceException {
        Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }
    
	/**
	 * GET
	 * 
	 * @param url
	 * @param responseType
	 * @param okHttpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T getForObject(String url, Class<T> responseType, OkHttpConfig okHttpConfig, Map<String, ?> uriVariables)
			throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(okHttpConfig, request, extractor);
	}

    /**
     * GET
     * @param url
     * @param typeRef
     * @param okHttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T getForObject(String url, TypeReference<T> typeRef, OkHttpConfig okHttpConfig, Map<String, ?> uriVariables) throws InterfaceException
    {
        Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }

	/**
	 * GET
	 * 
	 * @param url
	 * @param responseType
	 * @param okHttpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T getForObject(String url, Class<T> responseType, OkHttpConfig okHttpConfig, Object... uriVariables)
			throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(okHttpConfig, request, extractor);
	}

    /**
     * GET
     * @param url
     * @param typeRef
     * @param okHttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T getForObject(String url, TypeReference<T> typeRef, OkHttpConfig okHttpConfig, Object... uriVariables) throws InterfaceException
    {
        Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }

	/**
	 * GET
	 * 
	 * @param url
	 * @param responseType
	 * @param uriVariables
	 * @param <T>
	 * @return
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType, Object... uriVariables)
			throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * GET
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     */
    @Override
	public <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
							  Object... uriVariables) throws InterfaceException {
        Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }
	
	/**
	 * GET
	 * 
	 * @param url
	 * @param responseType
	 * @param okHttpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okHttpConfig,
							  Object... uriVariables) throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(okHttpConfig, request, extractor);
	}

    /**
     * GET
     * @param url
     * @param typeRef
     * @param okHttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, OkHttpConfig okHttpConfig,
							  Object... uriVariables) throws InterfaceException {
        Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }

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
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType,
							  Map<String, ?> uriVariables) throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * GET
     * @param url
     * @param typeRef
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef,
							  Map<String, ?> uriVariables) throws InterfaceException {
        Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }

	/**
	 * GET
	 * 
	 * @param url
	 * @param responseType
	 * @param okHttpConfig
	 * @param uriVariables
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T getForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okHttpConfig,
							  Map<String, ?> uriVariables) throws InterfaceException {
		Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables))
				.headers(Headers.of(headers)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(okHttpConfig, request, extractor);
	}

    /**
     * GET
     * @param url
     * @param typeRef
     * @param okHttpConfig
     * @param uriVariables
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T getForObject(String url, Map<String, String> headers, TypeReference<T> typeRef, OkHttpConfig okHttpConfig,
							  Map<String, ?> uriVariables) throws InterfaceException {
        Request request = new Request.Builder().url(StringUriTemplateUtil.expand(url, uriVariables))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }

	/**
	 * POST
	 * 
	 * @param url
	 * @param responseType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T postForObject(String url, Class<T> responseType, RequestBody requestBody) throws InterfaceException {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * POST
     * @param url
     * @param typeRef
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, TypeReference<T> typeRef, RequestBody requestBody) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(requestBody).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }

	/**
	 * POST
	 * 
	 * @param url
	 * @param responseType
	 * @param okHttpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T postForObject(String url, Class<T> responseType, OkHttpConfig okHttpConfig, RequestBody requestBody)
			throws InterfaceException {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(okHttpConfig, request, extractor);
	}

    /**
     * POST
     * @param url
     * @param typeRef
     * @param okHttpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, TypeReference<T> typeRef, OkHttpConfig okHttpConfig, RequestBody requestBody) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(requestBody).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }
    
	/**
	 * POST
	 * 
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, RequestBody requestBody)
			throws InterfaceException {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, Map<String,String> headers, TypeReference<T> typeRef,
							   RequestBody requestBody) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }
	
    /**
	 * POST
	 * 
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param okHttpConfig
	 * @param requestBody
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okHttpConfig,
							   RequestBody requestBody) throws InterfaceException {
		Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(okHttpConfig, request, extractor);
	}

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param okHttpConfig
     * @param requestBody
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, Map<String,String> headers, TypeReference<T> typeRef, OkHttpConfig okHttpConfig,
							   RequestBody requestBody) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(requestBody).headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }

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
	@Override
	public <T> T postForObject(String url, Class<T> responseType, String content, MediaType mediaType)
			throws InterfaceException {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * POST
     * @param url
     * @param typeRef
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, TypeReference<T> typeRef,
							   String content, MediaType mediaType) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }
	
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
    @Override
	public <T> T postForObject(String url, Class<T> responseType,
							   Object content, MediaType mediaType) throws InterfaceException
    {
        Request request = new Request.Builder().url(url).post(
                RequestBody.create(mediaType, fastJsonHelper().toString(content))).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
        return handleResponse(null, request, extractor);
    }

    /**
     * POST
     * @param url
     * @param typeRef
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, TypeReference<T> typeRef,
							   Object content, MediaType mediaType) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(
                RequestBody.create(mediaType, fastJsonHelper().toString(content))).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }
    
	/**
	 * POST
	 * 
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, String content,
							   MediaType mediaType) throws InterfaceException {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(null, request, extractor);
	}

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, Map<String,String> headers, TypeReference<T> typeRef,
							   String content, MediaType mediaType) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }

    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, Map<String,String> headers, Class<T> responseType,
							   Object content, MediaType mediaType) throws InterfaceException
    {
        Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, fastJsonHelper().toString(content)))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
        return handleResponse(null, request, extractor);
    }

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param content
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, Map<String,String> headers, TypeReference<T> typeRef,
							   Object content, MediaType mediaType) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, fastJsonHelper().toString(content)))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(null, request, extractor);
    }
	
	/**
	 * POST
	 * 
	 * @param url
	 * @param headers
	 * @param responseType
	 * @param okHttpConfig
	 * @param mediaType
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	@Override
	public <T> T postForObject(String url, Map<String, String> headers, Class<T> responseType, OkHttpConfig okHttpConfig,
							   String content, MediaType mediaType) throws InterfaceException {
		Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
				.headers(Headers.of(headers)).build();
		ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
		return handleResponse(okHttpConfig, request, extractor);
	}

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param okHttpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, Map<String,String> headers, TypeReference<T> typeRef, OkHttpConfig okHttpConfig,
							   String content, MediaType mediaType) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(RequestBody.create(mediaType, content))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }
    
    /**
     * POST
     * @param url
     * @param headers
     * @param responseType
     * @param okHttpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, Map<String,String> headers, Class<T> responseType, OkHttpConfig okHttpConfig,
							   Object content, MediaType mediaType) throws InterfaceException
    {
        Request request = new Request.Builder().url(url).post(
                RequestBody.create(mediaType, fastJsonHelper().toString(content)))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), responseType);
        return handleResponse(okHttpConfig, request, extractor);
    }

    /**
     * POST
     * @param url
     * @param headers
     * @param typeRef
     * @param okHttpConfig
     * @param mediaType
     * @param <T>
     * @return
     * @throws InterfaceException
     */
    @Override
	public <T> T postForObject(String url, Map<String,String> headers, TypeReference<T> typeRef, OkHttpConfig okHttpConfig,
							   Object content, MediaType mediaType) throws InterfaceException {
        Request request = new Request.Builder().url(url).post(
                RequestBody.create(mediaType, fastJsonHelper().toString(content)))
                .headers(Headers.of(headers)).build();
        ObjectExtractor<T> extractor = new ObjectExtractor<>(fastJsonHelper(), typeRef);
        return handleResponse(okHttpConfig, request, extractor);
    }



	/**
	 * handleResponse
	 * 
	 * @param request
	 * @param extractor
	 * @param <T>
	 * @return
	 * @throws InterfaceException
	 */
	private <T> T handleResponse(OkHttpConfig okHttpConfig, final Request request, final ObjectExtractor<T> extractor)
			throws InterfaceException {
		if (okHttpConfig != null) {
			okHttpHelper(okHttpConfig);
		}
		Response response = null;
		try {
			response = okHttpHelper().execute(request);
		} catch (IOException e) {
			throw new InterfaceException(e.getMessage(), e);
		}
		if (response.isSuccessful()) {
			try {
				return extractor.extractData(response);
			} catch (IOException t) {
				throw new InterfaceException("返回结果失败", t);
			} catch (InterfaceException t) {
				throw new InterfaceException(String.format("转换失败: %s", t.getMessage()), t);
			} catch (Throwable t) {
				throw new InterfaceException(t);
			}
		}
		StringBuilder errorInfo = new StringBuilder(300);
		errorInfo.append("HTTP CODE:").append(response.code()).append(", BODY:");
		try {
			errorInfo.append(response.body().string());
		} catch (Throwable t) {
		}
		throw new InterfaceException(errorInfo.toString());
	}
}
