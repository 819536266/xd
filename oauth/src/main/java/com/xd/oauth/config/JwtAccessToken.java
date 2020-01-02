package com.xd.oauth.config;

import com.xd.oauth.security.SecurityUserDetails;
import com.xd.user.api.entity.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author huboxin
 * @title: JwtAccessToken
 * @projectName bk
 * @description:  装配jwt内容
 * @date 2019/12/3114:50
 */
public class JwtAccessToken extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
        User user = ((SecurityUserDetails) authentication.getPrincipal()).getUser();
        defaultOAuth2AccessToken.getAdditionalInformation().put("user",user.getUsername());
        return super.enhance(accessToken, authentication);
    }
}
