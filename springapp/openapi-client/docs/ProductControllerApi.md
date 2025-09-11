# ProductControllerApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createProduct**](ProductControllerApi.md#createProduct) | **POST** /products |  |
| [**getProduct**](ProductControllerApi.md#getProduct) | **GET** /products/{id} |  |
| [**getProducts**](ProductControllerApi.md#getProducts) | **GET** /products | Get all products |



## createProduct

> createProduct(product)



### Example

```java
// Import classes:
import io.github.satr.springapp.invoker.ApiClient;
import io.github.satr.springapp.invoker.ApiException;
import io.github.satr.springapp.invoker.Configuration;
import io.github.satr.springapp.invoker.models.*;
import io.github.satr.springapp.api.ProductControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
        Product product = new Product(); // Product | 
        try {
            apiInstance.createProduct(product);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductControllerApi#createProduct");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **product** | [**Product**](Product.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getProduct

> Product getProduct(id)



### Example

```java
// Import classes:
import io.github.satr.springapp.invoker.ApiClient;
import io.github.satr.springapp.invoker.ApiException;
import io.github.satr.springapp.invoker.Configuration;
import io.github.satr.springapp.invoker.models.*;
import io.github.satr.springapp.api.ProductControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
        String id = "id_example"; // String | 
        try {
            Product result = apiInstance.getProduct(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductControllerApi#getProduct");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getProducts

> List&lt;Product&gt; getProducts()

Get all products

### Example

```java
// Import classes:
import io.github.satr.springapp.invoker.ApiClient;
import io.github.satr.springapp.invoker.ApiException;
import io.github.satr.springapp.invoker.Configuration;
import io.github.satr.springapp.invoker.models.*;
import io.github.satr.springapp.api.ProductControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        ProductControllerApi apiInstance = new ProductControllerApi(defaultClient);
        try {
            List<Product> result = apiInstance.getProducts();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProductControllerApi#getProducts");
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

[**List&lt;Product&gt;**](Product.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of products |  -  |

