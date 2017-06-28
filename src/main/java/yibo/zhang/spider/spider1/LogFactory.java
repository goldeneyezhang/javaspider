package yibo.zhang.spider.spider1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 日志工厂
 * 
 * @author golde
 *
 */
public class LogFactory {
	private static final Logger logger;
	static{
		logger=Logger.getLogger("stdout");
		logger.setLevel(java.util.logging.Level.INFO);
	}
	public static void log(String info,Level level,Throwable ex){
		logger.log(level, info, ex);
	}
	public static Level getLogLevel(){
		return logger.getLevel();
	}
}
