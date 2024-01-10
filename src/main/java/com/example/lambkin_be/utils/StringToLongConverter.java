package com.example.lambkin_be.utils;

 import org.modelmapper.AbstractConverter;

public class StringToLongConverter extends AbstractConverter<String,Long>{

    @Override
        protected Long convert(String source) {
            return source != null ? Long.valueOf(source) : null;
        }
    }

