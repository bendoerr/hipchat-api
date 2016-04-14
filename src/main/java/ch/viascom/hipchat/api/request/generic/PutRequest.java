package ch.viascom.hipchat.api.request.generic;

import ch.viascom.hipchat.api.response.generic.Response;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

/**
 * Created by patrickboesch on 11.04.16.
 */
public abstract class PutRequest<T extends Response> extends Request<T> {
    private static final Logger log = LogManager.getLogger(PostRequest.class);

    protected PutRequest(String accessToken, String baseUrl, HttpClient httpClient, ExecutorService executorService) {
        super(accessToken, baseUrl, httpClient, executorService);
    }

    @Override
    protected HttpResponse request() throws IOException {
        String jsonBody = getJsonBody();
        String encodedPath = getEncodedPath();
        log.debug("POST - path: {}", encodedPath);

        HttpPut httpPut = new HttpPut(baseUrl + encodedPath);
        httpPut.addHeader(new BasicHeader("Authorization", "Bearer " + accessToken));
        httpPut.addHeader(new BasicHeader("Content-Type", "application/json"));
        httpPut.setEntity(new StringEntity(jsonBody, Consts.UTF_8));
        return httpClient.execute(httpPut, HttpClientContext.create());
    }
}
