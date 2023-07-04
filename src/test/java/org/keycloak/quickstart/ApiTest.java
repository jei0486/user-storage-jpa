//package org.keycloak.quickstart;
//
//import com.tobe.keycloak.common.ApiClientUtil;
//import com.tobe.keycloak.common.CustomObjectMapper;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.junit.Test;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.Timestamp;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ApiTest {
//
///*
//https://jsonplaceholder.typicode.com/guide/
//
////ResteasyWebTarget target = client.target("https://jsonplaceholder.typicode.com/posts");
//
// */
//
//    CustomObjectMapper mapper = new CustomObjectMapper();
//    ApiClientUtil apiClientUtil = new ApiClientUtil();
//
//    @Test
//    public void apiTest1() throws IOException {
//
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//
//        HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/posts");
//
//        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//
//        System.out.println(httpResponse.getStatusLine().getStatusCode());
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                httpResponse.getEntity().getContent()));
//
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//
//        while ((inputLine = reader.readLine()) != null) {
//            response.append(inputLine);
//        }
//
//        reader.close();
//
//        //Print result
//        System.out.println(response.toString());
//        httpClient.close();
//    }
//
//    @Test
//    public void apiTest2() throws IOException {
//
//        Map<String,Object> request = new HashMap<>();
//        request.put("postId",1);
//        String str = mapper.writeValueAsString(request);
//        System.out.println(str);
//        String response =  apiClientUtil.request("GET","https://jsonplaceholder.typicode.com/comments",str);
//        System.out.println(response);
//    }
//
//    /**
//     *
//     GET	/posts
//     GET	/posts/1
//     GET	/posts/1/comments
//     GET	/comments?postId=1
//     POST	/posts
//     PUT	/posts/1
//     PATCH	/posts/1
//     DELETE	/posts/1
//     * @throws IOException
//     */
//    @Test
//    public void apiTest3() throws IOException {
//        String response =  apiClientUtil.request("GET","https://jsonplaceholder.typicode.com/posts/1/comments",null);
//        System.out.println(response);
//    }
//
//    @Test
//    public void apiTest4() throws IOException {
//        Map<String,Object> request = new HashMap<>();
//        request.put("title","foo");
//        request.put("body","bar");
//        request.put("userId",1);
//        String str = mapper.writeValueAsString(request);
//        System.out.println(str);
//        String response =  apiClientUtil.request("POST","https://jsonplaceholder.typicode.com/posts",str);
//        System.out.println(response);
//    }
//
//    @Test
//    public void test11(){
//        //select TO_CHAR(TO_TIMESTAMP(1688356183340 / 1000), 'DD/MM/YYYY HH24:MI:SS');
//        // 03/07/2023 12:49:43
//
//
//
//
//        String currentTimestampToString = "2022/12/12 08:03:15";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//        System.out.println(dateFormat.format(new Date(1688356183340L)));
////  String to Timestamp
//
//        dateFormat.setLenient(false);// 날짜와 시간을 엄격하게 확인
//        try {
//            Date stringToDate = dateFormat.parse(currentTimestampToString);
//
//            Timestamp stringToTimestamp = new Timestamp(stringToDate.getTime());
//
//            System.out.println(stringToTimestamp);
//
//            System.out.println(stringToTimestamp.getTime());
//
//            System.out.println(stringToTimestamp.getTime());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Test
//    public void setCreatedTimestamp() throws Exception{
//        String currentTimestampToString = "2023-07-03 13:09:14.000";
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date stringToDate = dateFormat.parse(currentTimestampToString);
//        Timestamp stringToTimestamp = new Timestamp(stringToDate.getTime());
//        System.out.println(stringToTimestamp.getTime());
//
//    }
//
//
//    @Test
//    public void getCreatedTimestamp() throws Exception{
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Long timestamp = 1688357354000L;
//
//
//
//        String str = dateFormat.format(new Date(timestamp));
//
//        System.out.println(str);
//
//
//        Timestamp stringToTimestamp = new Timestamp(dateFormat.parse(str).getTime());
//        System.out.println(stringToTimestamp);
//    }
//
//}
