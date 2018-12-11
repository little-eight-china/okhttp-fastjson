package github.hjg;


/**
 * 接口入口
 * @author little-eight
 */
public class JsonInterface extends AbstractOkHttpInterface{

    private OkHttpHelper okHttpHelper;

    private FastJsonHelper fastJsonHelper;

    /**
     * 生成一个默认实例
     * @return
     */
    public static OkHttpInterface getInstance(){
        return new JsonInterface();
    }

    public JsonInterface(){
        this.okHttpHelper = new OkHttpHelper();
        this.fastJsonHelper =FastJsonHelper.FAST_JSON_HELPER;

    }

    /**
     * 值映射接口
     * @return
     */
    @Override
    public FastJsonHelper fastJsonHelper() {
        return fastJsonHelper;
    }
    /**
     * 请求对象
     * @return
     */
    @Override
    public OkHttpHelper okHttpHelper(){
        return okHttpHelper;
    }


    /**
     * 请求对象
     * @return
     */
    @Override
    public OkHttpHelper okHttpHelper(OkHttpConfig okhttpConfig){
        this.okHttpHelper = new OkHttpHelper(okhttpConfig);
        return okHttpHelper;
    }
}
