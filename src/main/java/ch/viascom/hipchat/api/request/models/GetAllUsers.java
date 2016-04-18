package ch.viascom.hipchat.api.request.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by patrickboesch on 18.04.16.
 */
@Data
public class GetAllUsers {
    @SerializedName("start-index")
    private int	start_index = 0;
    @SerializedName("max-results")
    private int	max_results = 100;
    @SerializedName("include-guests")
    boolean	include_guests = false;
    @SerializedName("include-deleted")
    boolean	include_deleted = false;
}
