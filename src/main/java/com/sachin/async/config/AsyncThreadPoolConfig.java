package com.sachin.async.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncThreadPoolConfig
{
    @Bean(name = "asyncTaskPool")
    public Executor asyncTasks()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50);
        executor.setMaxPoolSize(100);
        executor.setThreadNamePrefix("asyncTask-");
        executor.setThreadGroupName("AsyncThreads");
        executor.initialize();
        return executor;
    }
}
