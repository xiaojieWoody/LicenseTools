package com.mylicense.param;

import java.io.Serializable;
import java.util.List;

public class LicenseCheckModel implements Serializable {

    private static final long serialVersionUID = -31983343976980894L;

    /**
     * 可被允许的MAC地址
     */
    private List<String> macAddress;

    /**
     * 允许的IP地址
     */
    private List<String> ipAddress;

    /**
     * 可被允许的CPU序列号
     */
    private String cpuSerial;

    /**
     * 可被允许的主板序列号
     */
    private String mainBoardSerial;

    public List<String> getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(List<String> macAddress) {
        this.macAddress = macAddress;
    }

    public String getCpuSerial() {
        return cpuSerial;
    }

    public void setCpuSerial(String cpuSerial) {
        this.cpuSerial = cpuSerial;
    }

    public String getMainBoardSerial() {
        return mainBoardSerial;
    }

    public void setMainBoardSerial(String mainBoardSerial) {
        this.mainBoardSerial = mainBoardSerial;
    }

    public List<String> getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(List<String> ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "LicenseCheckModel{" +
                "macAddress=" + macAddress +
                ", ipAddress=" + ipAddress +
                ", cpuSerial='" + cpuSerial + '\'' +
                ", mainBoardSerial='" + mainBoardSerial + '\'' +
                '}';
    }
}
