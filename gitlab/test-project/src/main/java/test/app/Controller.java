//package test.app;
//
//import org.springframework.web.bind.annotation.*;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//import java.io.IOException;
//import java.util.Objects;
//
//@RestController
//@RequestMapping("/service")
//public class Controller {
//
//    private static final ObjectMapper mapper = new ObjectMapper();
//
//
//    @GetMapping("/test-get")
//    public String testGet() {
//        return "Get works!";
//    }
//
//    @GetMapping("/test-get-second-service")
//    public String testGetSecondService() throws IOException {
//
////        OkHttpClient client = new OkHttpClient();
////
////        Request request = new Request.Builder()
////                .url("https://uat-external.ddosrebuff.com/service/test-get")
////                .build(); // defaults to GET
////
////        Response response = client.newCall(request).execute();
////        System.out.println(response);
////        System.out.println(response.body().string());
////        System.out.println(response.message());
////
////        String serviceResponse = mapper.readValue(Objects.requireNonNull(response.body()).byteStream(), String.class);
////
////        System.out.println(serviceResponse);
//
//
//
//        return "Get works!";
//    }
//
//    @PostMapping("/test-post")
//    public String testPost(@RequestBody TestReq testReq) {
//        System.out.println(testReq);
//        return testReq.toString();
//    }
//
//}
