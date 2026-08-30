package dev.salllesdev.cartservice.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()){
            case 400:
                return new DataNotFoundException("produto não encontrado");
            default:
                return new Exception("erro ao buscar o produto");
        }
    }
}
