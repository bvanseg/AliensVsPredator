package org.avp.common.api.machines;

public interface INetworkDevice
{
    void sendData();

    void receiveData();

    INetworkDevice getHostDevice();

    String getChannel();
}
