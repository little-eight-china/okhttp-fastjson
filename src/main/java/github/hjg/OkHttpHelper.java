package github.hjg;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Http请求工具
 * 
 * @author little-eight
 */
public class OkHttpHelper {

	public final static MediaType JSON_UTF8 = MediaType.parse("application/json;charset=utf-8");
	public final static MediaType JSON_GBK = MediaType.parse("application/json;charset=gbk");

	private static final OkHttpClient uwOkHttpClient = new OkHttpClient.Builder().build();

	private final OkHttpClient okHttpClient;

	private final boolean defaultClient;

	public OkHttpHelper() {
		okHttpClient = uwOkHttpClient;
		this.defaultClient = true;
	}

	public final OkHttpClient okHttpClient() {
		return uwOkHttpClient;
	}

	/**
	 * 自定义OkHttpClient配置
	 * 
	 * @return
	 */
	public OkHttpHelper(OkHttpConfig httpConfig) {
		this.okHttpClient = uwOkHttpClient.newBuilder()
				.connectTimeout(httpConfig.connectTimeout(), TimeUnit.MILLISECONDS)
				.readTimeout(httpConfig.readTimeout(), TimeUnit.MILLISECONDS)
				.writeTimeout(httpConfig.writeTimeout(), TimeUnit.MILLISECONDS).build();
		this.defaultClient = false;
	}

	/**
	 * 执行请求
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public Response execute(Request request) throws IOException {
		return okHttpClient.newCall(request).execute();
	}
}
