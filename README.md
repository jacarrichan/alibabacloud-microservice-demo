

### Introcution

This is a demo project to showcase running microservices on Alibaba Cloud.

This demo is powered by the following projects and products:

* [Apache Dubbo](https://github.com/apache/dubbo) for Remote Procedure Call
* [Spring Cloud Alibaba](https://github.com/alibaba/spring-cloud-alibaba) for Service to Service Call
* [Nacos](https://github.com/alibaba/nacos) for Service Discovery and Configuration management
* Alibaba Cloud [EDAS](https://www.aliyun.com/product/edas) for deployment and hosting
* Alibaba Cloud [ARMS](https://www.aliyun.com/product/arms) for monitoring
* Alibaba Cloud [SAE](https://www.aliyun.com/product/sae) for deployment and hosting without being aware of the underlying infrastructure.

### Live Demo

You can visit http://123.56.245.71:8080 for an live demo, which is hosted on Alibaba Cloud [SAE](https://www.aliyun.com/product/sae).

### Architecture

This project contains the following applications (more applications are ong the way):

* frontend: A Java application with SpringMVC and thymeleaf as template engine.
* cartservices: A Java application that  provides basic operations to add products to shopping carts, which is powered by [Apache Dubbo](https://github.com/apache/dubbo).
* productservice: A Java application that provies basic operations to list all the products and query product by ID, which is powered by [Spring Cloud Alibaba](https://github.com/alibaba/spring-cloud-alibaba).

### Build

#### Build docker image using docker-compose

You can use docker-compose to build docker images:

```sh
docker-compose build
```

#### Build docker image using scripts

You need to go to the `src` directory, for each sub module, there is a `build.sh`  file, just run it to build the docker image for each module.

```sh
./build.sh
```

### Deploy 

#### Deploy with docker-compose

This project can be deployed to docker with the following command

```sh
docker-compose -f docker-compose.yaml up
```

If you want to undeploy, use the following command

```sh
docker-compose -f docker-compose.yaml down
```

#### Deploy to Kubernetes cluster

This project can be deployed to Kubernetes cluster with the following command:

```sh
cd kubernetes-manifests/
for i in *.yaml; do kubectl apply -f $i; done
```

If you want to delete the deployment, please use the following command:

```sh
for i in *.yaml; do kubectl delete -f $i; done
```

#### Deploy with helm

This project can be deployed to Kubernetes cluster with helm chart:

```sh
helm install ./helm-chart  --name  microservice-demo
```

If you want to delete the deployment with helm, use the following command:

```sh
helm delete microservice-demo
```

### Collaborator
If you are a collaborator, please read the [Collaborator](https://github.com/aliyun/alibabacloud-microservice-demo/doc/Collaborator.md) to prepare for development.

### Credit

This project is originiated from [GoogleCloudPlatform/microservice-demo](https://github.com/GoogleCloudPlatform/microservices-demo)


```
PS C:\Users\jacarrichan\temp\alibabacloud-microservice-demo> kubectl  get  svc
NAME                    TYPE           CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
cart-redis              ClusterIP      10.100.10.212    <none>        6379/TCP         3m21s
checkout-mysql          ClusterIP      10.104.129.23    <none>        3306/TCP         3m21s
kubernetes              ClusterIP      10.96.0.1        <none>        443/TCP          8d
nacos-server            ClusterIP      10.96.233.127    <none>        8848/TCP         3m20s
nacos-server-external   LoadBalancer   10.109.223.142   localhost     8848:32383/TCP   3m20s
product-mysql           ClusterIP      10.108.1.216     <none>        3306/TCP         3m20s
zuul-gateway            ClusterIP      10.104.32.193    <none>        8080/TCP         3m20s
zuul-gateway-external   LoadBalancer   10.97.71.194     localhost     8080:32465/TCP   3m20s

PS C:\Users\jacarrichan\temp\alibabacloud-microservice-demo> kubectl get pods -o wide
NAME                               READY   STATUS    RESTARTS        AGE     IP           NODE             NOMINATED NODE   READINESS GATES
cart-redis-6db7968f49-9thrh        1/1     Running   0               3m47s   10.1.1.151   docker-desktop   <none>           <none>
cartservice-867c967b78-r8pq2       1/1     Running   2 (2m26s ago)   3m47s   10.1.1.152   docker-desktop   <none>           <none>
checkout-mysql-6466b58fb4-676nf    1/1     Running   0               3m47s   10.1.1.150   docker-desktop   <none>           <none>
checkoutservice-57849b8d44-4kkb9   1/1     Running   1 (2m45s ago)   3m47s   10.1.1.154   docker-desktop   <none>           <none>
frontend-7b7f8d9dc6-5nqst          1/1     Running   1 (2m52s ago)   3m47s   10.1.1.153   docker-desktop   <none>           <none>
nacos-server-9cdb779f6-65bb8       1/1     Running   0               3m47s   10.1.1.155   docker-desktop   <none>           <none>
product-mysql-5f9fcdbb94-nkdbn     1/1     Running   0               3m46s   10.1.1.157   docker-desktop   <none>           <none>
productservice-648cb5dccc-wf5x4    1/1     Running   1 (2m45s ago)   3m46s   10.1.1.156   docker-desktop   <none>           <none>
zuul-gateway-694b7f4984-h59p2      1/1     Running   0               3m46s   10.1.1.158   docker-desktop   <none>           <none>


```