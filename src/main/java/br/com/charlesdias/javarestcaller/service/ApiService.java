package br.com.charlesdias.javarestcaller.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.ProxyAuthenticationStrategy;

@Component
public class ApiService {
    private static final Boolean USE_PROXY = false;
    private static final String PROXY_HOST = "127.0.0.1";
    private static final int PROXY_PORT = 8888;
    private static final String PROXY_USER = "1";
    private static final String PROXY_PASSWORD = "1";

    public RestTemplate api;

    protected RestTemplate createInstance(Boolean useProxy) throws Exception {
        if (!useProxy)
            this.api = new RestTemplate();

        if (api == null) {
            CredentialsProvider credentialsProvider;
            credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(
                    new AuthScope(PROXY_HOST, PROXY_PORT),
                    new UsernamePasswordCredentials(PROXY_USER, PROXY_PASSWORD));

            HttpClientBuilder clientBuilder = HttpClientBuilder.create();

            clientBuilder.useSystemProperties();
            clientBuilder.setProxy(new HttpHost(PROXY_HOST, PROXY_PORT));
            clientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            clientBuilder.setProxyAuthenticationStrategy(new ProxyAuthenticationStrategy());

            CloseableHttpClient client = clientBuilder.build();

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setHttpClient(client);

            api = new RestTemplate();
            api.setRequestFactory(factory);
        }
        return api;
    }
}
