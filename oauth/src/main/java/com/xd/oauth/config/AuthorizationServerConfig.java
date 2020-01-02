package com.xd.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.URI;

/**
 * @author huboxin
 * @title: AuthorizationServiceConfig
 * @projectName bk
 * @description: 认证服务器配置
 * @date 2019/12/3110:56
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * redis连接工厂
     */
    private  RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private  AuthenticationManager authenticationManager;

    /**
     * 数据源
     */
    private  DataSource dataSource;

    /**
     * key配置信息
     */
    private  KeyProperties keyProperties;

    @Autowired
    public AuthorizationServerConfig(RedisConnectionFactory redisConnectionFactory,
                                               DataSource dataSource,
                                               KeyProperties keyProperties) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.dataSource = dataSource;
        this.keyProperties = keyProperties;
    }
    /**
     * JwtAccessTokenConverter是用来生成token的转换器，
     * 而token令牌默认是有签名的，且资源服务器需要验证这个签名。此处的加密及验签包括两种方式
     * @return
     */
    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() throws IOException {
        KeyStoreKeyFactory keyStoreKeyFactory=new KeyStoreKeyFactory(keyProperties.getKeyStore().getLocation()
                , keyProperties.getKeyStore().getPassword().toCharArray());
        JwtAccessToken jwtAccessTokenConverter = new JwtAccessToken();
        //导入证书
        jwtAccessTokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair(keyProperties.getKeyStore().getAlias()));
        return jwtAccessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }


    /**
     * AuthorizationServerSecurityConfigurer 在令牌端点上定义了安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.passwordEncoder(new BCryptPasswordEncoder())
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 开启/oauth/check_token验证端口认证权限访问
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }
    /**
     * ClientDetailsServiceConfigurer 定义了客户端细节服务。客户详细信息可以被初始化
     *用来配置客户端详情服务（ClientDetailsService），
     * 客户端详情信息在这里进行初始化，你能够把客户端详情信息写
     * 死在这里或者是通过数据库来存储调取详情信息
     *  @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails());
    }

    /**
     *AuthorizationServerEndpointsConfigurer 定义了授权和令牌端点和令牌服务
     *配置认证规则，哪些需要认证哪些不需要
     *用来配置令牌端点(Token Endpoint)的安全约束.
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //设置令牌
        endpoints.tokenStore(tokenStore())
                .authenticationManager(authenticationManager)
                .tokenEnhancer(jwtTokenEnhancer())
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }
}
