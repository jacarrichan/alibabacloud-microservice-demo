package com.alibabacloud.mse.demo.service;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.InetUtils;

import static com.alibabacloud.mse.demo.BApplication.SERVICE_TAG;

@Service(version = "1.0.0")
public class HelloServiceBImpl implements HelloServiceB {

    @Autowired
    InetUtils inetUtils;

    @Reference(application = "${dubbo.application.id}", version = "1.0.0",check = false)
    private HelloServiceC helloServiceC;

    @Override
    public String hello(String name) {
        return "B" + SERVICE_TAG + "[" + inetUtils.findFirstNonLoopbackAddress().getHostAddress() + "]" + " -> " +
                helloServiceC.hello(name);
    }

}
