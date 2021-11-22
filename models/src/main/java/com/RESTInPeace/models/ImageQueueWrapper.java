package com.RESTInPeace.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class ImageQueueWrapper implements Serializable {
    private static final long serialVersionUID = 1420672609912364060L;
    public byte[] file;
    public String fileName;
}
