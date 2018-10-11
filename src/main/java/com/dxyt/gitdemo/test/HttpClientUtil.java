package com.dxyt.gitdemo.test;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


/**
 * 项目名称：gitdemo
 * 类名称：HttpClientUtil
 * 类描述：httpclient工具类
 * 创建人：安红飞（anhongfei@telecomyt.com.cn）
 * 创建时间：2018/10/11 10:05
 * 修改人：安红飞（anhongfei@telecomyt.com.cn）
 * 修改时间：2018/10/11 10:05
 * 修改备注：
 * 版本号：1.0
 **/
public class HttpClientUtil {

    //日志打印
    private static Logger log= (Logger) LoggerFactory.getLogger(HttpClientUtil.class);
    // 默认字符集
    private static final String ENCODING = "UTF-8";


    /**
     * 方法名称：sendPost
     * 方法描述：发送post请求
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 10:29
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 10:29
     * 修改备注：
     * 方法参数： [url:请求地址, headers：请求头, data：发送的数据, encoding：字符集]
     * 方法返回值： java.lang.String
     **/
    public static String sendPost(String url,Map<String, String> headers, JSONObject data, String encoding) {
        log.info("进入post请求方法...");
        log.info("请求入参：URL= " + url);
        log.info("请求入参：headers=" + JSON.toJSONString(headers));
        log.info("请求入参：data=" + JSON.toJSONString(data));
        // 请求返回结果
        String resultJson = null;
        // 创建Client
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建HttpPost对象
        HttpPost httpPost = new HttpPost();

        try {
            // 设置请求地址
            httpPost.setURI(new URI(url));
            // 设置请求头
            if (headers != null) {
                Header[] allHeader = new BasicHeader[headers.size()];
                int i = 0;
                for (Map.Entry<String, String> entry: headers.entrySet()){
                    allHeader[i] = new BasicHeader(entry.getKey(), entry.getValue());
                    i++;
                }
                httpPost.setHeaders(allHeader);
            }
            // 设置实体
            httpPost.setEntity(new StringEntity(JSON.toJSONString(data)));
            // 发送请求,返回响应对象
            CloseableHttpResponse response = client.execute(httpPost);
            // 获取响应状态
            int status = response.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                // 获取响应结果
                resultJson = EntityUtils.toString(response.getEntity(), encoding);
            } else {
                log.error("响应失败，状态码：" + status);
            }

        } catch (Exception e) {
            log.error("发送post请求失败", e);
        } finally {
            httpPost.releaseConnection();
        }
        return resultJson;
    }


    /**
     * 方法名称：sendPost
     * 方法描述：发送post请求，请求数据默认使用json格式，默认使用UTF-8编码
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 10:31
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 10:31
     * 修改备注：
     * 方法参数： [url:请求地址, data:发送的数据]
     * 方法返回值： java.lang.String
     **/
    public static String sendPost(String url, JSONObject data) {
        // 设置默认请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        return sendPost(url, headers, data, ENCODING);
    }


    /**
     * 方法名称：sendPost
     * 方法描述：发送post请求，请求数据默认使用json格式，默认使用UTF-8编码
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 10:33 
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 10:33
     * 修改备注：
     * 方法参数： [url:请求地址, params:发送数据]
     * 方法返回值： java.lang.String
     **/
    public static String sendPost(String url,Map<String,Object> params){
        // 设置默认请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        // 将map转成json
        JSONObject data = JSONObject.parseObject(JSON.toJSONString(params));
        return sendPost(url,headers,data,ENCODING);
    }

 
    /**
     * 方法名称：sendPost
     * 方法描述：发送post请求，请求数据默认使用UTF-8编码
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 10:45 
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 10:45
     * 修改备注：
     * 方法参数： [url:请求地址, headers:请求头, data:发送的数据]
     * 方法返回值： java.lang.String
     **/
    public static String sendPost(String url, Map<String, String> headers, JSONObject data) {
        return sendPost(url, headers, data, ENCODING);
    }


    /**
     * 方法名称：sendPost
     * 方法描述：发送post请求，请求数据默认使用UTF-8编码
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 10:46 
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 10:46
     * 修改备注：
     * 方法参数： [url:请求地址, headers:请求头, params:发送的数据]
     * 方法返回值： java.lang.String
     **/
    public static String sendPost(String url,Map<String,String> headers,Map<String,String> params){
        // 将map转成json
        JSONObject data = JSONObject.parseObject(JSON.toJSONString(params));
        return sendPost(url,headers,data,ENCODING);
    }


    /**
     * 方法名称：sendGet
     * 方法描述：发送get请求
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 10:48 
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 10:48
     * 修改备注：
     * 方法参数： [url:请求地址, params:发送的数据, encoding：字符集编码]
     * 方法返回值： java.lang.String
     **/
    public static String sendGet(String url,Map<String,Object> params,String encoding){
        log.info("进入get请求方法...");
        log.info("请求入参：URL= " + url);
        log.info("请求入参：params=" + JSON.toJSONString(params));
        // 请求结果
        String resultJson = null;
        // 创建client
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建HttpGet
        HttpGet httpGet = new HttpGet();
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            // 封装参数
            if(params != null){
                for (String key : params.keySet()) {
                    builder.addParameter(key, params.get(key).toString());
                }
            }
            URI uri = builder.build();
            log.info("请求地址："+ uri);
            // 设置请求地址
            httpGet.setURI(uri);
            // 发送请求，返回响应对象
            CloseableHttpResponse response = client.execute(httpGet);
            // 获取响应状态
            int status = response.getStatusLine().getStatusCode();
            if(status == HttpStatus.SC_OK){
                // 获取响应数据
                resultJson = EntityUtils.toString(response.getEntity(), encoding);
            }else{
                log.error("响应失败，状态码：" + status);
            }
        } catch (Exception e) {
            log.error("发送get请求失败",e);
        } finally {
            httpGet.releaseConnection();
        }
        return resultJson;
    }

    
    /**
     * 方法名称：sendGet
     * 方法描述：发送get请求
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 10:52
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 10:52
     * 修改备注：
     * 方法参数： [url:请求地址, params:请求数据]
     * 方法返回值： java.lang.String
     **/
    public static String sendGet(String url,Map<String,Object> params){
        return sendGet(url,params,ENCODING);
    }


    /**
     * 方法名称：sendGet
     * 方法描述：发送get请求
     * 创建人：安红飞（anhongfei@telecomyt.com.cn）
     * 创建时间：2018/10/11 10:53 
     * 修改人：安红飞（anhongfei@telecomyt.com.cn）
     * 修改时间：2018/10/11 10:53
     * 修改备注：
     * 方法参数： [url:请求地址]
     * 方法返回值： java.lang.String
     **/
    public static String sendGet(String url){
        return sendGet(url,null,ENCODING);
    }
}

