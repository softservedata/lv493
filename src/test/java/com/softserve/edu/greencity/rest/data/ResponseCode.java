package com.softserve.edu.greencity.rest.data;

public enum ResponseCode {

        RESPONSE200(200),
        RESPONSE400(400);

        private int code;

        private ResponseCode(int code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return String.valueOf(code);
        }

    }