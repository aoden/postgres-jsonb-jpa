package com.tdt.postgresjsonb.domain;

import com.tdt.postgresjsonb.config.ObjectMapperHolder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class BaseDomain implements Externalizable {


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        ObjectMapperHolder.getObjectMapper().writeValue(out, this);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        ObjectMapperHolder.getObjectMapper().readerForUpdating(this).readValue(in);
    }
}
