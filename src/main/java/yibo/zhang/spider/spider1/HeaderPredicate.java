package yibo.zhang.spider.spider1;

import java.util.function.Predicate;

import org.apache.http.Header;

public class HeaderPredicate {
	public static Predicate<Header> iscontentType() {
        return p -> p.getName().contains("Content-Type");
    }
}
