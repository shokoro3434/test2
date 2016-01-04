package jp.co.eitan.cloud.itool.api.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lombok.Data;

@Data
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS,
        value = WebApplicationContext.SCOPE_SESSION)
public class ApiProfile {
	private String accessKey;
	private String secretKey;
}
