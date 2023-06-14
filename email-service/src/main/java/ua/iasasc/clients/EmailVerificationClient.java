package ua.iasasc.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "emailVerificationClient", url = "")
public interface EmailVerificationClient {

}
