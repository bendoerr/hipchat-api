package ch.viascom.hipchat.api.models.capability;

import lombok.Data;

import java.io.Serializable;

@Data
public class CapabilityCapabilities implements Serializable {
    /**
     * The capability of providing and accepting OAuth 2 tokens for authentication
     */
    private CapabilityOauth2Provider oauth2Provider;

    /**
     * The ability to provide the HipChat API
     */
    private CapabilityHipchatApiProvider hipchatApiProvider;
}
