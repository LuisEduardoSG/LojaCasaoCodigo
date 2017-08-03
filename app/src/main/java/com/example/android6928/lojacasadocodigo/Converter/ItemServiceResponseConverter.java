package com.example.android6928.lojacasadocodigo.Converter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class ItemServiceResponseConverter implements Converter<ResponseBody, String> {
    @Override
    public String convert(ResponseBody value) throws IOException {

        String string = value.string();

        return string;
    }
}
