import com.mylicense.config.ConfigConstant;

/**
 * 出于对执行命令uninstall的考虑，所以将类名首字母小写
 */
public class uninstall {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        String cmd = null;
        String shellCmd = null;

        // 删除文件
        // 文件路径
        String originpath = ConfigConstant.LICENSE_FILE_PATH;
        if (osName.startsWith("windows")) {
            cmd = "cmd /c del /s/q "+originpath;
        } else {
            shellCmd = "rm -f " + originpath;
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
