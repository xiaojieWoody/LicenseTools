import com.mylicense.config.ConfigConstant;

/**
 * 出于对执行命令install的考虑，所以将类名首字母小写
 */
public class install {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();
        String cmd = null;
        String shellCmd = null;
        // 移动文件
        if(args.length == 2) {
            // 文件路径
            String originpath = args[1];
            // 目标路径
            String targetpath = ConfigConstant.LICENSE_INSTALL_PATH;

            if (osName.startsWith("windows")) {
                cmd = "cmd /c move " + originpath + " " + targetpath + "\\";
            } else {
                shellCmd = "mv " + originpath + " " + targetpath;
            }
        } else {
            System.out.println("command format error!");
            return;
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
