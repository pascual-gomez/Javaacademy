package com.gomezpascual.aws;

import com.gomezpascual.Instance;
import com.gomezpascual.ResourceFactory;
import com.gomezpascual.Storage;
//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {


    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
