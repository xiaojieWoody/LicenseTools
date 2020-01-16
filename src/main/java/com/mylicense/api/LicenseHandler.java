package com.mylicense.api;

/**
 * 移动/删除文件
 * window/Linux
 */
public class LicenseHandler {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        String cmd = null;
        String shellCmd = null;
        // 移动文件
        if(args.length == 2) {
            // 文件路径
            String originpath = args[0];
            // 目标路径
            String targetpath = args[1];

            if (osName.startsWith("windows")) {
                cmd = "cmd /c move " + originpath + " " + targetpath + "\\";
            } else {
                shellCmd = "mv " + originpath + " " + targetpath;
            }
        }
        // 删除文件
        if(args.length == 1) {
            // 文件路径
            String originpath = args[0];
            if (osName.startsWith("windows")) {
                cmd = "cmd /c del /s/q "+originpath;
            } else {
                shellCmd = "rm -f " + originpath;
            }
        }

        // windows
        if(cmd != null) {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // linux
        if(shellCmd != null) {
            try {
                String[] shell =  {"/bin/bash", "-c", shellCmd};
                Process process = Runtime.getRuntime().exec(shell);
                process.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
