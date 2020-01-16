package com.mylicense.api;


import com.alibaba.fastjson.JSON;
import com.mylicense.machine.AbstractMachineInfo;
import com.mylicense.machine.LinuxMachineInfo;
import com.mylicense.machine.WindowsMachineInfo;
import com.mylicense.param.LicenseCheckModel;

import java.io.IOException;
import java.util.Base64;

/**
 * 获取windows/linux机器码
 */
public class MachineCodeHolder {

    public static void main(String[] args) throws IOException {
        String osName = System.getProperty("os.name").toLowerCase();

        AbstractMachineInfo abstractMachineInfo = null;
        if (osName.startsWith("windows")) {
            abstractMachineInfo = new WindowsMachineInfo();
        } else {
            abstractMachineInfo = new LinuxMachineInfo();
        }
        LicenseCheckModel machineInfo = abstractMachineInfo.getMachineInfo();
        // 转Base64
        String encoderMsg = Base64.getUrlEncoder().encodeToString(JSON.toJSONBytes(machineInfo));
        System.out.println(encoderMsg);
    }
}
