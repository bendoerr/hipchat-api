package ch.viascom.hipchat.api.interceptors;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.groundwork.foxhttp.interceptor.response.FoxHttpResponseInterceptor;
import ch.viascom.groundwork.foxhttp.interceptor.response.context.FoxHttpResponseInterceptorContext;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;


/**
 * @author patrick.boesch@viascom.ch
 */
public class ForbiddenCodeInterceptor implements FoxHttpResponseInterceptor {

    @Getter
    @Setter
    private int weight = 300;

    private Consumer<FoxHttpResponseInterceptorContext> forbiddenCodeCallback;

    public ForbiddenCodeInterceptor(Consumer<FoxHttpResponseInterceptorContext> forbiddenCodeCallback) {
        this.forbiddenCodeCallback = forbiddenCodeCallback;
    }

    @Override
    public void onIntercept(FoxHttpResponseInterceptorContext context) throws FoxHttpException {
        if (context.getResponseCode() == 403) {
            forbiddenCodeCallback.accept(context);
        }
    }
}
