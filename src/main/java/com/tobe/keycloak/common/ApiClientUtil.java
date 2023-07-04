package com.tobe.keycloak.common;


import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.CannotProceedException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(ApiClientUtil.class);

    private static final String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36";
    private static final int connectionTimeout = 30;
    private static final int socketTimeout = 30;

    /**
     * 설정에 정의된 방식으로 요청
     */
    public String request(String method ,String url ,String json) {


        try {
            Header header = new BasicHeader("User-Agent", userAgent);

            if (url.isEmpty()) {
                throw new RuntimeException("URL not found");
            }

            if ("GET".equals(method)) {
                String query = addQueryToUrl(url, json);
                HttpGet get = new HttpGet(query);
                return connect(get, header);
            } else if ("POST".equals(method)) {
                HttpPost post = new HttpPost(url);
                if (json != null) {
                    post.setEntity(new StringEntity(json, "UTF-8"));
                }
                return connect(post, header);
            } else if ("PUT".equals(method)) {
                HttpPut put = new HttpPut(url);
                if (json != null) {
                    put.setEntity(new StringEntity(json, "UTF-8"));
                }
                return connect(put, header);
            } else if ("DELETE".equals(method)) {
                String query = addQueryToUrl(url, json);
                HttpDelete delete = new HttpDelete(query);
                return connect(delete, header);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * GET 요청일 경우 URL에 파라미터 추가
     */
    public String addQueryToUrl(String url, String json) throws URISyntaxException {

        URIBuilder query = new URIBuilder(url);
        if (json == null) {
            return query.toString();
        }
        int i = json.indexOf("{");
        json = json.substring(i);
        JSONObject jsonObj = new JSONObject(json.trim());
        Iterator<String> keys = jsonObj.keys();
        List<NameValuePair> parameters = new ArrayList<>();
        while (keys.hasNext()) { // only 1 depth supported
            String key = keys.next();
            String value = String.valueOf(jsonObj.get(key));
            if (StringUtils.isEmpty(value)) {
                continue;
            }
            parameters.add(new BasicNameValuePair(key, value));
        }
        query.setParameters(parameters);

        return query.toString();
    }

    /**
     * application/json 요청
     */
    public String connect(HttpRequestBase request, Header... headers) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CannotProceedException {
        request.setHeader(HttpHeaders.ACCEPT, "application/json; charset=UTF-8");
        request.setHeader(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        // header setting
        if (!ArrayUtils.isEmpty(headers)) {
            for (Header h : headers) {
                request.setHeader(h);
            }
        }

        try (CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(connectionTimeout * 1000).setSocketTimeout(socketTimeout * 1000).build())
                .setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContexts.custom().loadTrustMaterial(TrustSelfSignedStrategy.INSTANCE).build(), NoopHostnameVerifier.INSTANCE)).build();
             CloseableHttpResponse apiResponse = httpClient.execute(request);) {

            int code = apiResponse.getStatusLine().getStatusCode();
            logger.info("code : {}",code);

            return EntityUtils.toString(apiResponse.getEntity());
        }

    }



}

