package com.itheima.client;

import com.itheima.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * http客户端Feign 第三步：创建声明式接口 实现远程调用<br>
 *   思路：实际就是将http://itheima-user/user/1 变为UserClient接口<br>
 *   1.@FeignClient(value = "itheima-user")  指定被调用微服务服务名称<br>
 *   2.创建被调用微服务方法(可以从被调用微服务控制层的方法直接copy过来)<br>
 *      2.1. 保证被调用的路径是完整的<br>
 *      2.2. @PathVariable(value = "id") 一定要加上参数名称<br>
 */
@FeignClient(value = "itheima-user")
public interface UserClient {

    /***
     * 根据id查询用户详情
     */
    @GetMapping(value = "user/{id}")
    public User one(@PathVariable(value = "id") Long id);


}
