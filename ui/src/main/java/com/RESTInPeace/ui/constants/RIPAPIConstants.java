package com.RESTInPeace.ui.constants;

public class RIPAPIConstants {
    public static final String RIP_API_URL_BASE = "http://localhost:8081";
    public static final String RIP_API_URL_GET_RECORD = String.format("%s/getRecords", RIP_API_URL_BASE);
    public static final String RIP_API_URL_SET_RECORD = String.format("%s/setRecords", RIP_API_URL_BASE);
}
