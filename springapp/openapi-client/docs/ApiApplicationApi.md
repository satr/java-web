# ApiApplicationApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**healthz**](ApiApplicationApi.md#healthz) | **GET** /healthz |  |



## healthz

> String healthz()



### Example

```java
// Import classes:
import io.github.satr.springapp.invoker.ApiClient;
import io.github.satr.springapp.invoker.ApiException;
import io.github.satr.springapp.invoker.Configuration;
import io.github.satr.springapp.invoker.models.*;
import io.github.satr.springapp.api.ApiApplicationApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        ApiApplicationApi apiInstance = new ApiApplicationApi(defaultClient);
        try {
            String result = apiInstance.healthz();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ApiApplicationApi#healthz");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

