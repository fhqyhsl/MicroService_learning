package zyx.contentservice.Config;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/**
 * 随机负载均衡策略配置类
 */
public class RandomLoadBalancerConfig {

    /**
     * 创建随机负载均衡器
     *
     * @param environment              Spring 环境变量对象
     * @param loadBalancerClientFactory 负载均衡客户端工厂
     * @return 随机负载均衡器
     */
    @Bean
    public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(
            Environment environment,
            LoadBalancerClientFactory loadBalancerClientFactory
    ) {
        // 从环境变量中获取服务名
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);

        // 创建随机负载均衡器并返回
        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name,ServiceInstanceListSupplier.class),name);
    }
}