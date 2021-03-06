package ch.viascom.hipchat.api.api;

import ch.viascom.groundwork.foxhttp.annotation.types.Header;
import ch.viascom.groundwork.foxhttp.annotation.types.POST;
import ch.viascom.groundwork.foxhttp.annotation.types.Path;
import ch.viascom.groundwork.foxhttp.annotation.types.Query;
import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.models.User;

@Path("{host}")
@Header(name = "Content-Type", value = "application/json")
public interface InvitesApi {

    @POST("/invite/user")
    User inviteUserToGroup(@Query("title") String title,
                           @Query("email") String email,
                           @Query("name") String name) throws FoxHttpException;
}

