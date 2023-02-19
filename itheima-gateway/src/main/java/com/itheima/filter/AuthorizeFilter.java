package com.itheima.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器-实现统一认证处理
 * 1.当前类实现GlobalFilter接口
 * 2.@Order(-1) 可以有很多过滤器 指定值表示执行顺序 值越小优先级越高
 *   方式一：注解方式@Order(-1)
 *   方式二：实现Ordered接口
 */
//@Order(-1)
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    /**
     * 实现统一认证处理（token校验）
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求对象 响应对象
        ServerHttpResponse response = exchange.getResponse();
        ServerHttpRequest request = exchange.getRequest();
        //2.获取请求路径中参数
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //2.1获取请求路径中参数名称为authorization参数值
        String token = queryParams.getFirst("authorization");
        //2.2调用JwtUtils工具类进行token校验（判断值是否为admin）
        if(token.equals("admin")){
            //如果是则放行
            return chain.filter(exchange);
        }
        //如果不是则拦截，返回401
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        //请求完成
        return response.setComplete();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
