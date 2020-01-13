package com.mylicense.api;

public class LicenseHandler {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        String cmd = null;
        // 移动文件
        if(args.length == 2) {
            String originpath = args[0];
            String targetpath = args[1];

            if (osName.startsWith("windows")) {
                cmd = "cmd /c move " + originpath + " " + targetpath + "\\";
            } else {
                String[] shell =  {"/bin/bash", "-c", "mv " + originpath + " " + targetpath};
                try {
                    Process process = Runtime.getRuntime().exec(shell);
                    process.getOutputStream().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        // 删除文件
        if(args.length == 1) {
            String originpath = args[0];
            if (osName.startsWith("windows")) {
                cmd = "cmd /c del /s/q "+originpath;
            } else {
                String[] shell =  {"/bin/bash", "-c", "rm -f " + originpath};
                try {
                    Process process = Runtime.getRuntime().exec(shell);
                    process.getOutputStream().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if(cmd != null) {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.getOutputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
