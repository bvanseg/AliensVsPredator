package org.avp.common.api.machines;

public interface IDataDevice
{
    /** Read data from another device with specified ID implementing this interface **/
    void readFromOtherDevice(int ID);

    /** Write data to another device with specified ID implementing this interface **/
    void writeToOtherDevice(int ID);
}
