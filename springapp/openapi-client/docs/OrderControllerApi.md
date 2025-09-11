# OrderControllerApi

All URIs are relative to *http://localhost:8081*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createOrder**](OrderControllerApi.md#createOrder) | **POST** /orders |  |
| [**getOrder**](OrderControllerApi.md#getOrder) | **GET** /orders/{id} |  |
| [**getOrders**](OrderControllerApi.md#getOrders) | **GET** /orders | Get all orders |



## createOrder

> createOrder(order)



### Example

```java
// Import classes:
import io.github.satr.springapp.invoker.ApiClient;
import io.github.satr.springapp.invoker.ApiException;
import io.github.satr.springapp.invoker.Configuration;
import io.github.satr.springapp.invoker.models.*;
import io.github.satr.springapp.api.OrderControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        OrderControllerApi apiInstance = new OrderControllerApi(defaultClient);
        Order order = new Order(); // Order | 
        try {
            apiInstance.createOrder(order);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrderControllerApi#createOrder");
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
| **order** | [**Order**](Order.md)|  | |

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


## getOrder

> Order getOrder(id)



### Example

```java
// Import classes:
import io.github.satr.springapp.invoker.ApiClient;
import io.github.satr.springapp.invoker.ApiException;
import io.github.satr.springapp.invoker.Configuration;
import io.github.satr.springapp.invoker.models.*;
import io.github.satr.springapp.api.OrderControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        OrderControllerApi apiInstance = new OrderControllerApi(defaultClient);
        String id = "id_example"; // String | 
        try {
            Order result = apiInstance.getOrder(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrderControllerApi#getOrder");
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

[**Order**](Order.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getOrders

> List&lt;Order&gt; getOrders()

Get all orders

### Example

```java
// Import classes:
import io.github.satr.springapp.invoker.ApiClient;
import io.github.satr.springapp.invoker.ApiException;
import io.github.satr.springapp.invoker.Configuration;
import io.github.satr.springapp.invoker.models.*;
import io.github.satr.springapp.api.OrderControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8081");

        OrderControllerApi apiInstance = new OrderControllerApi(defaultClient);
        try {
            List<Order> result = apiInstance.getOrders();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling OrderControllerApi#getOrders");
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

[**List&lt;Order&gt;**](Order.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of orders |  -  |

